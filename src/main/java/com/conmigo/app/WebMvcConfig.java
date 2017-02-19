package com.conmigo.app;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling( final DefaultServletHandlerConfigurer configurer ) {
		configurer.enable();
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames( "/resources/i18n/messages", "classpath:/conmigo" );
		messageSource.setUseCodeAsDefaultMessage( true );
		messageSource.setDefaultEncoding( "UTF-8" );
		return messageSource;
	}

}
