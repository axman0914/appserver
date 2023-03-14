package boe.b4.appserver.config;

import boe.b4.appserver.utils.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("boe.b4.appserver")
                .title("app管理系统")
                .description("app理接口文档")
                .contactName("Axman")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
