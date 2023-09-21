package com.fssa.project.service;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import com.fssa.project.exception.*;
import com.fssa.project.model.*;
import com.fssa.project.service.*;

public class UserServiceTest {

	  @Test
	    public void testCreateUser_Success() {
	        User user = new User("JohDoe", "1234567890", 
	                             "chandru@gmail.com", "password");
	        UserService userService = new UserService();
	        String result;
			try {
				result = userService.createUser(user);
				assertEquals("User Created Successfully", result);
			} catch (ServiceException e) {
				fail("Unexpected exception: " + e.getMessage());
			}	
	    }

	    @Test
	    public void testCreateUser_InvalidData() {
	        User user = new User("", "1234567890", 
	                             "john@example.com", "password");
	        UserService userService = new UserService();

	        assertThrows(ServiceException.class, () -> userService.createUser(user));
	    }

    @Test
    public void testReadUser_Success() {
        // Assuming you have a valid user ID
        int userId = 1;
        UserService userService = new UserService();
        User user = userService.readUser(userId);

        assertNotNull(user);
    }

    @Test
    public void testReadUser_InvalidUserId() {
        // Assuming an invalid user ID that doesn't exist
        int userId = -1;
        UserService userService = new UserService();

        assertThrows(ServiceException.class, () -> userService.readUser(userId));
    }

    @Test
    public void testUpdateUser_Success() {
        // Assuming you have a valid user ID
        int userId = 1;
        UserService userService = new UserService();
        User user = userService.readUser(userId);

        user.setName("Updated Name");
        boolean result = false;
		try {
			result = userService.updateUser(user);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        assertEquals("User Updated Successfully", result);
    }

    @Test
    public void testUpdateUser_InvalidData() {
        // Assuming you have a valid user ID
        int userId = 1;
        UserService userService = new UserService();
        User user = userService.readUser(userId);

        user.setEmail(""); // Setting an invalid email
        assertThrows(ServiceException.class, () -> userService.updateUser(user));
    }

    @Test
    public void testDeleteUser_Success() {
        // Assuming you have a valid user ID
        int userId = 1;
        UserService userService = new UserService();
        boolean result = false;
		try {
			result = userService.deleteUser(userId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//assertTrue(result);
        assertEquals("User Deleted Successfully", result);
    }

    @Test
    public void testDeleteUser_InvalidUserId() {
        // Assuming an invalid user ID that doesn't exist
        int userId = -1;
        UserService userService = new UserService();

        assertThrows(ServiceException.class, () -> userService.deleteUser(userId));
    }
}
