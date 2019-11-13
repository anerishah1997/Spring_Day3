package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lti.model.Users;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate template;
	public UserDaoImpl(JdbcTemplate template)
	{
		this.template = template;
	}
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private static final String READ_LOGIN = "Select * from Users where username=? and password=?";
	private static final String INSERT_USER = "Insert into Users(Username,firstname,lastname,mobilenumber,password) values(?,?,?,?,?)";
	private static final String UPDATE_USER = "Update Users set firstname=?, lastname=?, mobilenumber=? where username=?";
	private static final String DELETE_USER= "Delete from Users where username=?";
	private static final String SELECT_ALL_USERS="Select * from Users";
	
	
	public int readLogin(String username, String password){
		// for select queries with parameters.
		List<Users> list = template.query(READ_LOGIN, new Object[]{username,password} /*object array*/, new EmployeeRowMapper());
		return list!=null?list.size():0;
	
	}
	
	
	public int createUser(Users user){
		int result = template.update(INSERT_USER,user.getUsername(),user.getFirstname(),user.getLastname(),user.getMobilenumber(),user.getPassword());
		return result;
	}
	
	public List<Users> readAllUsers(){
		List<Users> list = template.query(SELECT_ALL_USERS, new EmployeeRowMapper());
		return list;
	}
	
		
	public Users updateUser(Users user) {
		int result = template.update(UPDATE_USER,user.getFirstname(),user.getLastname(),user.getMobilenumber(),user.getUsername());
		if(result == 1)
			return user;
		else
			return null;
	}
	
	public int deleteUser(String username){
		int result = template.update(DELETE_USER,username);
		return result;
	}
	
	

	
	
}


	
	
	
	
	
	
	


                                                                                                                     