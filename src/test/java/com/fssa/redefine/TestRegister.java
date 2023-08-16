package com.fssa.redefine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.redefine.model.User;
import com.fssa.redefine.services.UserService;
import com.google.protobuf.ServiceException;

public class TestRegister {

	public static void main(String[] args) {

		User user1 = new User("Chandruis","9500320194","2004-12-26", "chandru2354997@gmail.com","Chandru@#12345");
		UserService userService = new UserService();

		try {
			UserService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}
    
	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("Chandruis","9500320194","2004-12-26", "chandru2354997@gmail.com","Chandru@#12345");
		try {

			assertTrue(UserService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
   fail();
		}
	}



}