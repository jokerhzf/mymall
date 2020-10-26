package com.hzf.mymall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hzf.mymall.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SwaagerUI")
                .description("mymall")
                .contact(new Contact("hzf","huangzifan.com","jokerhzf@icloud.com"))
                .version("1.0")
                .build();
    }
}
