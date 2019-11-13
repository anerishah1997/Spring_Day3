package com.lti.ui;

import com.lti.model.Address;
import com.lti.model.Employee;

public class Main {

	public static void main(String[] args) {

		Employee employee = new Employee(1000, "Aneri", 5000);
		Address address = new Address("ABC road", "Mumbai", "400706");
		
		// this main class is doing dependency injection manually
		//employee.setAddress(address);
		System.out.println(employee);
		System.out.println(employee.getAddress());
	}

}
