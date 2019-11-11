package com.hibernateSampleProgram.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.hibernateSampleProgram")
@EnableTransactionManagement
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter
{
	@Autowired
	org.springframework.core.env.Environment environment;

	@Bean
	public ViewResolver internelViewResolver()
	{
		InternalResourceViewResolver viewResover = new InternalResourceViewResolver();
		// viewResover.setViewClass(JstlView.class);
		viewResover.setPrefix("/WEB-INF/pages/");
		viewResover.setSuffix(".jsp");
		return viewResover;
	}

	@Bean(name = "messageSource")
	public MessageSource getMessageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("Locale/Application_en");
		return messageSource;
	}

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
	{
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("Locale/App.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

}
