package com.lti.service;

import java.util.List;

import com.lti.model.Users;

public interface UserService {
	public boolean checkLogin(String username, String password);
	public boolean addUser(Users user);
	public List<Users> findAllUsers();
	public Users modifyUser(Users user) ;
	public boolean removeUser(String username);

}
