package com.xxz.rent.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2API文档的配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Bean
    public Docket createRestApi(){
        ParameterBuilder headToken = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        headToken.name(tokenHeader).description("Token请求头")
                .modelRef(new ModelRef("string")).parameterType("header")
                .defaultValue(tokenHead + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzc4ODk1NzI5MSIsImNyZWF0ZWQiOjE1NjI3NDkwMTAxNzMsImV4cCI6MTU4MDg5MzAxMH0.B5oXk7z49d7oR9oEM_golb0fystDPmwLSagyPxtplrxlzLT5K5COxhFj69Q8kAAI6a2yuMSWFlQ5C-UZDHL9Aw")
                .required(true).build();
        pars.add(headToken.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xxz.rent.portal.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars)
                ;

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("前端接口系统")
                .description("接口系统")
                .contact("xxz")
                .version("1.0")
                .build();
    }
}
