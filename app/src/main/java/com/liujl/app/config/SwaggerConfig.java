package com.liujl.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by junlong_liu on 2017/3/30.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    @Value("${swagger.host}")
//    private String swagger_host;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liujl.app.rest"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这是样例工程的文档")
                .contact("刘骏龙")
                .version("1.0")
                .build();
    }

//    @Bean
//    public Docket createRestApi2() {
//        System.out.println("swaggerhost:" + swagger_host);
//        return new Docket(DocumentationType.SWAGGER_2).host(swagger_host)
//                .apiInfo(apiInfo2())
//                .select()
//                .paths(PathSelectors.any())
//                .build();
//
//    }
//
//    private ApiInfo apiInfo2() {
//        return new ApiInfoBuilder()
//                .title("test")
//                .description("test")
//                .contact("刘骏龙")
//                .version("1.0")
//                .build();
//    }


}
