package br.com.testeesigfullstack.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket swagger() {
		
		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.testeesigfullstack.resource")).paths(PathSelectors.regex("/.*"))
				.paths(PathSelectors.any())
				.build().ignoredParameterTypes(ApiIgnore.class).enableUrlTemplating(true);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API para controle de tarefas")
				.description("Api desenvolvida para processo seletivo da ESIG")
				.version("v.1.0")
				.build();
	}
}
