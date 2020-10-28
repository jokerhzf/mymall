package com.hzf.mymall.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：010980380
 * @date:2020-10-27
 * @verison:1.0.0
 * @description：Swagger3配置文件
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                //添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3构建MyMall API")
                .description("Mymall接口平台")
                .termsOfServiceUrl("http://huangzifan.com")
                .contact(new Contact("hzf","huangzifan.com","jokerhzf@icloud.com"))
                .version("1.0")
                .build();
    }


    /**
     * 设置请求头信息
     * @return List<ApiKey>
     * @author huangzifan
     * @since 2020-10-28 15:08
     */
    private List<SecurityScheme> securitySchemes(){
        List<SecurityScheme> result = new ArrayList<>();
        SecurityScheme securityScheme = new ApiKey("Authorization","Authorization","header");
        result.add(securityScheme);
        return result;
    }

    /**
     * 设置需要登录认证的路径
     * @return List<SecurityContext>
     * @author huangzifan
     * @since 2020-10-28 15:10
     */
    private List<SecurityContext> securityContexts(){
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/brand/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }

}
