package br.com.projetoaplicado.notificacao.configuracao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.projetoaplicado.notificacao.apresentacao"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo())
    }

    fun apiInfo(): ApiInfo {
        return ApiInfo(
                "CINEMA REST API",
           "CINEMA API.",
              "0.0.1", "Termos de serviço",
                      Contact("Dev", "br.com.netflixossplaygrond.cinema", "myeaddress@company.com"),
        "License of API", "API license URL", Collections.emptyList())
    }
}