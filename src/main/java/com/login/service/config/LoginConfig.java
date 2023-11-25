package com.login.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		 templateResolver.setPrefix("classpath:/templates/");
		 
		 templateResolver.setSuffix(".html");
		 templateResolver.setTemplateMode("HTML");
		 return templateResolver;
	}
	 @Bean
	 public SpringTemplateEngine tempaEngine() {
		 SpringTemplateEngine templateEngine= new SpringTemplateEngine();
		 templateEngine.setTemplateResolver(templateResolver());
		 return templateEngine;
	 }
	 
	 @Override
	 public void configureViewResolvers(ViewResolverRegistry registry) {
		 ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		 resolver.setTemplateEngine(tempaEngine());
		 registry.viewResolver(resolver);
	 }
	 @Bean
	 public ClassLoaderTemplateResolver secondaryTemplateResolver() {
	     ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
	     secondaryTemplateResolver.setPrefix("templates/");
	     secondaryTemplateResolver.setSuffix(".html");
	     secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
	     secondaryTemplateResolver.setCharacterEncoding("UTF-8");
	     secondaryTemplateResolver.setOrder(1);
	     secondaryTemplateResolver.setCheckExistence(true);
	         
	     return secondaryTemplateResolver;
	 }

}
