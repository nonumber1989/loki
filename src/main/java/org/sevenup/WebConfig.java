package org.sevenup;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:9000")
			.allowedMethods("PUT", "DELETE","GET","POST")
//			.allowedHeaders("header1", "header2", "header3")
//			.exposedHeaders("header1", "header2")
			.allowCredentials(false).maxAge(3600);
	}
}