package com.lti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lti.model.Address;
import com.lti.model.Employee;

@Configuration
@ComponentScan(basePackages={"com.lti.model"})
public class JavaConfig {


	
	
	@Bean(name="address1")
	public Address getAddress()
	
	{ 
		System.out.println("addr1");
		return new Address();
	}
	
	@Bean(name="address2")
	public Address getAddress2()
	{
		System.out.println("addr2");
		return new Address();
	}
}
