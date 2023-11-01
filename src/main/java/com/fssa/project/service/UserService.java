package com.fssa.project.service;

import com.fssa.project.dao.UserDAO;
import com.fssa.project.exception.DAOException;
import com.fssa.project.exception.ServiceException;
import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.User;
import com.fssa.project.validation.UserValidator;

public class UserService {

	public String createUser(User user) throws ServiceException {
	    try {
	    	UserDAO userDAO = new UserDAO();
	        UserValidator userValidator = new UserValidator(user);
	        userDAO.checkUserDataExistOrNot(user.getEmail());
	        userValidator.validateAll();
	        System.out.println("try user service"); 

	        // Assuming createUser is an instance method of UserDAO
	        
	        if (userDAO.createUser(user)) {
	            return "User Created Successfully";
	        } else {
	            throw new ServiceException("User Creation Failed");
	        }
	    } catch (ValidationException e) {
	        throw new ServiceException(e.getMessage(), e);
	    } catch (DAOException e) {
	        throw new ServiceException(e.getMessage());
	    }
	}


	public User getUserById(int userId) throws ServiceException {
		try {
			return UserDAO.getUserById(userId);
		} catch (DAOException e) {
			throw new ServiceException("Database Error", e);
		}
	}

	public boolean loginUser(User user) throws ServiceException {

		try {
			return UserDAO.loginUser(user.getEmail(), user.getPassword());
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public boolean updateUser(User user) throws ServiceException {
		try {
			UserValidator userValidator = new UserValidator(user);
			userValidator.validateAll();

			return UserDAO.updateUser(user);
		} catch (ValidationException e) {
			throw new ServiceException("Invalid User Data", e);
		} catch (DAOException e) {
			throw new ServiceException("Database Error", e);
		}
	}

	public boolean deleteUser(int userId) throws ServiceException {
		try {
			return UserDAO.deleteUser(userId);
		} catch (DAOException e) {
			throw new ServiceException("Database Error", e);
		}
	}
  
	
	
	public User readUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
