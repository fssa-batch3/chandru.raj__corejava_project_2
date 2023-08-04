package Redefine.services;
import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import Rededine.validation.exception.InvalidUserException;
import Redefine.dao.*;
import Redefine.model.User;
import Redefine.services.*;
import Redefine.services.exception.serviceException;
import Redefine.validation.UserValidator;

public class UserService {

	public static boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
		if(UserValidator.ValidateUser(user)) { 
			if(userDAO.register(user)) {
				System.out.println(user.getUsername() + " Successfully Registered!");
				return true;
			} else {
				System.out.println("Registration not successful!");
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
}
