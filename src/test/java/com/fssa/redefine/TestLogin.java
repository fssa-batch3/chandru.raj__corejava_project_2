package com.fssa.redefine;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.redefine.model.User;
import com.fssa.redefine.services.UserService;
import com.google.protobuf.ServiceException;


 class TestLogin {

	@Test

	 void loginSuccess() {
		UserService userService = new UserService();

		User user1 = new User("chandruchan2354@gmail.com",  "Chan@2002", null);
		try {
			
			assertTrue(userService.loginUser(user1));
			throw new ServiceException("Login successfully. Welcome, " + user1.getEmail() + "!");
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
	} 
    
	@Test
    
	 void loginFailed() {
		UserService userService = new UserService();
		User user1 = new User("dravidchan@gmail.com",  "dravid@2002", null);
		try {
			assertFalse(userService.loginUser(user1));
			throw new ServiceException("Login Failed.Kindly Register");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}