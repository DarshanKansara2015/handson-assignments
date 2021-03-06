package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class MainViewController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		// This is getting service object
		UserService service = (UserService) UserFactory.getInstance(Type.SERVICE);
		int option = 0;
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Find User by id 4: Update PhoneNo. 5: Update Password 6: Exit");
			System.out.println("*****************************************************************************************");
			option = scanner.nextInt();
			switch(option) {
			case 1: 
				User user = new User();
				System.out.println("Enter name");		
				user.setName(scanner.next());
//				String name = scanner.next();
//				user.setName(name);
				
				System.out.println("Enter password");	
				user.setPassword(scanner.next());
				System.out.println("Enter phone no");	
				user.setPhone(scanner.nextLong());
				User createdUser = service.storeUser(user);
				System.out.println("User created with an id: "+createdUser.getUserId());
				break;
			case 2: 
				User[] users = service.getAllUsers();
				for(User temp : users) {
					if(temp!=null)
					System.out.println(temp);
				}
				break;
			case 3:
				try{
					System.out.println("Enter User Id");
					User user1 = service.fetchById(scanner.nextInt());
					System.out.println(user1);
				}
				catch(UserNotFoundException e){
					System.err.print(e.getMessage());
				}
				break;
			case 4:
				try{
					User user1 = new User();
					
					System.out.println("Enter User Id");
					user1.setUserId(scanner.nextInt());
					
					System.out.println("Enter phone no");	
					user1.setPhone(scanner.nextLong());
					
					User updatedUser = service.updatePhoneNo(user1);
					
					System.out.println(updatedUser);
				}
				catch(UserNotFoundException e){
					System.err.print(e.getMessage());
				}
				break;
				
			case 5:
				try{
					User user1 = new User();
					
					System.out.println("Enter User Id");
					user1.setUserId(scanner.nextInt());
					
					System.out.println("Enter password");	
					user1.setPassword(scanner.next());
					
					User updatedUser = service.updatePassword(user1.getUserId(), user1.getPassword());
					
					System.out.println(updatedUser);
				}
				catch(UserNotFoundException e){
					System.err.print(e.getMessage());
				}
				break;
				
			}
		} while(option != 6);
		
		scanner.close();
	}

}
