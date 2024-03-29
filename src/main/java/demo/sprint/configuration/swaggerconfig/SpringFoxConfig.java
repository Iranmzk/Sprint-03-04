package demo.sprint.configuration.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public ApiInfo info(){
        return new ApiInfoBuilder()
                .title("Walmart and Amazon API")
                .contact(new Contact("Iran",
                        "https://www.linkedin.com/in/iran-mizunski-5824b416b/",
                        "testeApi@gmail.com"))
                .description("Check prices and stock in the Walmart and Amazon shop")
                .version("Beta")
                .license("terms of service")
                .build();
    }
}
