package com.hzf.mymall.component;

import cn.hutool.json.JSONUtil;
import com.hzf.mymall.common.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author：010980380
 * @date:2020-10-28
 * @verison:1.0.0
 * @description：当未登录或者token失效访问接口时，自定义的返回结果
 */

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}
