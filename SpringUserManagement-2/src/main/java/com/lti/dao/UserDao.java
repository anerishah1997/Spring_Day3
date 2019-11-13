package com.lti.dao;

import java.util.List;

import com.lti.model.Users;

public interface UserDao {
	
	public int readLogin(String username, String password);
	public int createUser(Users user);
	public List<Users> readAllUsers();
	public Users updateUser(Users user);
	public int deleteUser(String username);

}
