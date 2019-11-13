package com.lti.config;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lti.dao.EmployeeDao;
import com.lti.dao.EmployeeDaoImpl;
import com.lti.model.Employee;
import com.lti.service.EmployeeService;
import com.lti.service.EmployeeServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.lti"}) // looks for all the beans at specific location... so that our service and dao will be created.
public class AppConfig {

	@Bean(name="employee")
	public Employee getEmployee()
	{
		return new Employee(); //violating the rule of spring ioc.
	}
	
	/*@Bean(name="service")
	public EmployeeService getEmployeeService()
	{
		return new EmployeeServiceImpl();
	}
	
	@Bean(name="dao")
	public EmployeeDao getEmployeeDao()
	{
		return new EmployeeDaoImpl();
	}*/
	
	// above beans are created using annotation @Service(for service) and @Repositry(for dao)
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource); // it will take bean of dataSource while creating this object.
	}
	
	@Bean
	public DataSource getDataSource(){ 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		return dataSource; 
	}
			
}
