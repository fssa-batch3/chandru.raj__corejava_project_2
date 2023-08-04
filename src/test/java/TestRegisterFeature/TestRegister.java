package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import Redefine.model.User;
import Redefine.services.UserService;
import Redefine.services.exception.serviceException;

public class TestRegister {

	public static void main(String[] args) {

		User user1 = new User("Chandru","9500320194","2004-12-26", "chandru@gmail.com","Chandru123");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}
    
	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("Chandru","9500320194","2004-12-26", "chandru@gmail.com","Chandru@123");
		try {

			assertTrue(UserService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
   fail();
		}
	}



}