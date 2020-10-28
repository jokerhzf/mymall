package com.hzf.mymall.config;

import com.hzf.mymall.component.JwtAuthenticationTokenFilter;
import com.hzf.mymall.component.RestAuthenticationEntryPoint;
import com.hzf.mymall.component.RestfulAccessDeniedHandler;
import com.hzf.mymall.dto.AdminUserDetails;
import com.hzf.mymall.model.UmsAdmin;
import com.hzf.mymall.model.UmsPermission;
import com.hzf.mymall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-10-28
 * @verison:1.0.0
 * @description：SpringSecurity的配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;// 当用户没有访问权限时的处理器，用于返回JSON格式的处理结果

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;// 当未登录或token失效时，返回JSON格式的结果

    /**
     * 用于配置需要拦截的url路径、jwt过滤器及出异常之后的处理器
     * @param httpSecurity  
     * @throws Exception
     * @return void
     * @author huangzifan
     * @since 2020-10-28 10:28
     */
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,// 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**")
                .permitAll()
                .antMatchers("/admin/login", "/admin/register")//对登陆注册y要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
              //.antMatchers("/**")//测试时全部运行访问
              //.permitAll()
                .anyRequest()//除了上面外的所有请求全部需要鉴权认证
                .authenticated();

        // 禁用缓存
        httpSecurity.headers().cacheControl();

        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // 添加自定义为授权和未登录时的处理器
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

    }

    /**
     * 用于配置UserDetailsService和PasswordEncoder
     * @param auth  
     * @throws Exception
     * @return void
     * @author huangzifan
     * @since 2020-10-28 10:34
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /**
     * SpringSecurity定义的用于对密码进行编码及比对的接口
     * 目前使用的是BCryptPasswordEncoder。
     * @return org.springframework.security.crypto.password.PasswordEncoder
     * @author huangzifan
     * @since 2020-10-28 10:57
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * SpringSecurity定义的核心接口
     * ，用于根据用户名获取用户信息，需要自行实现
     * @return org.springframework.security.core.userdetails.UserDetailsService
     * @author huangzifan
     * @since 2020-10-28 11:00
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            UmsAdmin admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId());
                // SpringSecurity定义用于封装用户信息的类（主要是用户信息和权限），需要自行实现
                return new AdminUserDetails(admin,permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    /**
     * 在用户名和密码校验前添加的过滤器
     * ，如果有jwt的token，会自行根据token信息进行登录。
     * @return JwtAuthenticationTokenFilter
     * @author huangzifan
     * @since 2020-10-28 11:01
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
