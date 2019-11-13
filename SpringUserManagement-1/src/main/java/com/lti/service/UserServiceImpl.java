package com.lti.service;

import java.util.List;

import com.lti.dao.UserDao;
import com.lti.model.Users;

public class UserServiceImpl implements UserService{
	private UserDao dao;
	
	public UserServiceImpl(UserDao dao)
	{
		this.dao=dao;
	}
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public boolean checkLogin(String username, String password){
		int result = dao.readLogin(username, password);
		if(result ==1)
			return true;
		else
			return false;
	}
	
	public boolean addUser(Users user){
		int result = dao.createUser(user);
		if(result == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public List<Users> findAllUsers(){
		return dao.readAllUsers();
	}
	
	public Users modifyUser(Users user) {
		return dao.updateUser(user);
	}
	
	
		
	
	
	public boolean removeUser(String username){
		int result = dao.deleteUser(username);
		if(result ==1){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	

	
}