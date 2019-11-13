package com.lti.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lti.model.Users;

@Configuration
@ComponentScan(basePackages={"com.lti"})
public class AppConfig {
	
	@Bean(name="user")
	public Users getUsers()
	{
		System.out.println("User created");
		return new Users();
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource)
	{
		System.out.println("JdbcTemplate created");
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSource getDataSource(){
		System.out.println("DataSource created");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		return dataSource; 
	}

}
