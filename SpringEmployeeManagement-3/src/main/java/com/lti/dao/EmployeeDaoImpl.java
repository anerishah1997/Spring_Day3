package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lti.model.Employee;

@Repository // now no need of creating a bean explicitly , obj of this class will get registered in context object.
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired // means dao is already registered , we are just injecting object of JdbcTemplate(DI) here. 
	private JdbcTemplate template ;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private static final String INSERT_EMP_RECORD = "Insert Into Emp(Emp_Id, Emp_Name, Emp_Sal) Values(Emp_EmpId.nextval,?,?)";
	private static final String DELETE_EMP_RECORD = "Delete From Emp Where Emp_Id=?";
	private static final String UPDATE_EMP_RECORD = "Update Emp Set Emp_Name=?, Emp_Sal=? Where Emp_Id=?";
	private static final String SELECT_EMP_RECORD = "Select * from Emp";
	
	public int createEmployee(Employee employee) {
		// query and values of question mark is passed and id's value is inserted using a sequence.
		int result = template.update(INSERT_EMP_RECORD, employee.getEmployeeName(), employee.getEmployeeSalary());
		return result;
	}

	public List<Employee> readAllEmployees() {
		// this is quite different, only used for select query. For that make a new class EmployeeRowMapper.
		List<Employee> list = template.query(SELECT_EMP_RECORD, new EmployeeRowMapper());
		return list;
	}

	public int deleteEmployee(int employeeId) {
		int result = template.update(DELETE_EMP_RECORD,employeeId);
		return result;
	}

	public Employee updateEmployee(Employee employee) {
		int result = template.update(UPDATE_EMP_RECORD,employee.getEmployeeName(),employee.getEmployeeSalary(),employee.getEmployeeId());
		if(result == 1)
			return employee;
		else
			return null;
	}

}
