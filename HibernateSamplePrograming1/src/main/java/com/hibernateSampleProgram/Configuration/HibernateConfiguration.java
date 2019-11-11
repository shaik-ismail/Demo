package com.hibernateSampleProgram.Configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:Locale/App.properties"})
@ComponentScan({"com.hibernateSampleProgram"})
public class HibernateConfiguration
{
	@Autowired
	private Environment environment;

	@Bean
	public org.springframework.orm.hibernate4.LocalSessionFactoryBean sessionFactory()
	{
		org.springframework.orm.hibernate4.LocalSessionFactoryBean sessionFactory = new org.springframework.orm.hibernate4.LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]{"com.hibernateSampleProgram"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	/*
	 * @Bean public HibernateTemplate template() {
	 * 
	 * }
	 */

	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(this.environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(this.environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(this.environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties hibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", this.environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", this.environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", this.environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", this.environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.use_sql_comments", "true");
		properties.put("hibernate.autocommit", "false");

		properties.put("hibernate.max_fetch_depth", "2");
		properties.put("hibernate.jdbc.batch_size", "20");

		properties.put("C3P0_MIN_SIZE", this.environment.getProperty("hibernate.c3p0.min_size"));
		properties.put("C3P0_MAX_SIZE", this.environment.getProperty("hibernate.c3p0.max_size"));
		properties.put("C3P0_ACQUIRE_INCREMENT", this.environment.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put("C3P0_TIMEOUT", this.environment.getProperty("hibernate.c3p0.timeout"));
		properties.put("C3P0_MAX_STATEMENTS", this.environment.getProperty("hibernate.c3p0.max_statements"));
		return properties;
	}

	@Bean
	@Autowired
	public org.springframework.orm.hibernate4.HibernateTransactionManager transactionManager(SessionFactory s)
	{
		org.springframework.orm.hibernate4.HibernateTransactionManager txManager = new org.springframework.orm.hibernate4.HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
