package com.rishi.tourist.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class I118NConfig {


	@Bean
	public ResourceBundleMessageSource messageSource () {
		ResourceBundleMessageSource r = new ResourceBundleMessageSource();
		r.addBasenames("success-message");
		return r;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver s = new SessionLocaleResolver();
		s.setDefaultLocale(Locale.ENGLISH);
		return s;
	}
	
	
}
