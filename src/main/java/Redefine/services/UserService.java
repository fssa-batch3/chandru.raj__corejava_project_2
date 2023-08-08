package Redefine.services;

import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import Rededine.validation.exception.InvalidUserException;
import Redefine.dao.*;
import Redefine.dao.exception.DAOException;
import Redefine.model.User;
import Redefine.validation.UserValidator;

public class UserService {

	public static boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (UserValidator.ValidateUser(user)) {
				if (userDAO.register(user)) {
					System.out.println(user.getUsername() + " Successfully Registered!");
					return true;
				} else {
					System.out.println("Registration not successful!");
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	public boolean loginUser(User user) throws ServiceException {
		try {

			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.isLogin(user)) {
				return userDAO.loginUser(user); // Return true for successful login.
			} else {
				return false;
			}
		} catch (DAOException e) {

			throw new ServiceException(e.getMessage());
		}
	}

}
