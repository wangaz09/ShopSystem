package com.wangaz.mango.core.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration //声明该类为配置类
public class SwaggerConfig {
	

	@Bean
	public Docket createRestApi() {
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameterBuilder.name("token").description("令牌")
		.modelRef(new ModelRef("string")).parameterType("header")
		.required(false).build();
		parameters.add(parameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select().build().globalOperationParameters(parameters);
	}
	
    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                //不显示错误的接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();
    }*/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("这是我的接口文档")
                .description("这是SWAGGER_2生成的接口文档")
                .termsOfServiceUrl("NO terms of service")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("v1.0")
                .build();
    }

}
