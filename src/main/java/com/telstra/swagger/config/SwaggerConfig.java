package com.telstra.swagger.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/** The title. */
    @Value( "${springboot.swagger.api.title}")
    private String title;

    /** The description. */
    @Value( "${springboot.swagger.api.description}")
    private String description;
  

    /** The license. */
    @Value( "${springboot.swagger.api.license}")
    private String license;

   
    /**
     * Api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description).license(license)
                .version("1.0").build();

    }

    /**
     * Post paths.
     *
     * @return the predicate
     */
    @SuppressWarnings( "unchecked")
    private Predicate<String> postPaths() {
        return or(regex("/api/Fibonacci.*"), regex("/api/ReverseWords.*"), regex("/api/TriangleType.*"),regex("/api/makeonearray.*"));
    }

    /**
     * Posts api.
     *
     * @return the docket
     */
    @Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}



}