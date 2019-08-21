package com.pipihaohao.demo;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xfh
 * @create: 2019-07-02 13:56
 **/

public class Swagger2 {

    private Docket createRestApi(String version, String description) {
        List<Parameter> parameters = getParameterBuilder();

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(PropertiesConfig.swaggerEnable)
                .groupName(version).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/" + version + "/**")).build()
                .apiInfo(apiInfo(version, description)).globalOperationParameters(parameters);
    }

    @Bean
    public Docket createRestApi1() {
        return createRestApi("v1", "版本1");
    }

    @Bean
    public Docket createRestApi2() {
        return createRestApi("v2", "版本2");
    }

    private List<Parameter> getParameterBuilder() {
        List<Parameter> parameters = new ArrayList<>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder
                .name("x-auth-token")
                .parameterType("header")
                .description("用户tp token, 暂时用默认值")
                .defaultValue("r:77adccdb068a47c699f7962402b8fb04")
                .required(false)
                .modelRef(new ModelRef("string"));
        parameters.add(parameterBuilder.build());
        return parameters;
    }

    private ApiInfo apiInfo(String version, String description) {
        return new ApiInfoBuilder()
                .title("Bamboo API " + version)
                .version("1.0.0")
                /*.description(ForumConfig.discuzxBaseUrl
                        + description)*/
                .build();
    }

}
