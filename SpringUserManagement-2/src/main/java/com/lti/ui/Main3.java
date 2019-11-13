package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Users;
import com.lti.service.UserService;

public class Main3 {

	public static void main(String[] args) {
		String ans = "";
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService service = context.getBean("service",UserService.class);
		Users user = context.getBean("user",Users.class);
		boolean result = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username: ");
		String uname = sc.next();
		System.out.println("Enter Password: ");
		String pass = sc.next();
		result = service.checkLogin(uname, pass);
		if(result)
		{
		 do{
			System.out.println("---------------Menu---------------");
			System.out.println("1. Add User");
			System.out.println("2. Read All Users");
			System.out.println("3. Modify user");
			System.out.println("4. Delete User");
			int no = sc.nextInt();
			switch(no){
				case 1: System.out.println("Enter username: ");
						user.setUsername(sc.next());
						System.out.println("Enter Password: ");
						user.setPassword(sc.next());
						System.out.println("Enter Firstname: ");
						user.setFirstname(sc.next());
						System.out.println("Enter Lastname: ");
						user.setLastname(sc.next());
						System.out.println("Enter Mobilenumber: ");
						user.setMobilenumber(sc.next());
					    result = service.addUser(user);
					    if(result)
					    	System.out.println("User added to db successfully ");
					    else
					    	System.out.println("User not added");
					    
					    break;
					    
				case 2: List<Users> list = service.findAllUsers();
						for(Users e : list)
							System.out.println(e);
						break;
						
				case 3: System.out.println("Enter the username of user you wanna update: ");
						user.setUsername(sc.next());
						System.out.println("Enter the new Firstname: ");
						user.setFirstname(sc.next());
						System.out.println("Enter the new LastName: ");
						user.setLastname(sc.next());
						System.out.println("Enter the new MobilNumber: ");
						user.setMobilenumber(sc.next());
						
						Users updatedUser = service.modifyUser(user);
						System.out.println(updatedUser);
						break;
						
				case 4: System.out.println("Enter the username of the user you wanna delete: ");
						String username = sc.next();
						Boolean result1= service.removeUser(username);
						if(result1)
							System.out.println("User with username "+username+" is deleted from database");
						else
							System.out.println("User not deleted");
					    break;
				
			    default: System.out.println("Enter proper choice");
			    		 break;
			} 
			    System.out.println("Do you want to continue?? yes/no");
			    ans = sc.next();
					 
			
		 }while(ans.equals("yes") || ans.equals("Yes") || ans.equals("y"));
			
		}
		else
		{
			System.out.println("Wrong username and password");
		}
		
	}

}
