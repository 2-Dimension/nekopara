package com.zml.nekopara;

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
 * API文档访问url：http://localhost:8080/swagger-ui.html
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/5
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableSwagger2
public class Swapper2Config {

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zml.nekopara.controller"))//要扫描的API(Controller)基础包
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("nekopara API文档")
                .contact("zhumeilu")
                .version("1.0")
                .build();
    }
}
