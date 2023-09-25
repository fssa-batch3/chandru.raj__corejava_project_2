package com.fssa.project.service;

import java.util.List;

import com.fssa.project.dao.HallDAO;
import com.fssa.project.exception.DAOException;
import com.fssa.project.exception.ServiceException;
import com.fssa.project.model.Hall;
import com.fssa.project.validation.HallValidator;

public class HallService {

	public boolean createHall(Hall hall) throws ServiceException {
		try {
			HallValidator.validateHall(hall);
			int rowsInserted = HallDAO.createHall(hall);
			return rowsInserted > 0;
		} catch (Exception e) {
			throw new ServiceException("Error creating hall", e);
		}
	}

	public Hall readHall(int hallId) throws ServiceException {
		try {
			Hall hall = HallDAO.getHallById(hallId);
			if (hall == null) {
				throw new ServiceException("Hall not found");
			}
			return hall;
		} catch (Exception e) {
			throw new ServiceException("Error reading hall", e);
		}
	}

	public boolean updateHall(Hall hall) throws ServiceException {
		try {

			HallValidator.validateHall(hall);

			if (HallDAO.updateHall(hall)) {
				return true;
			} else {
				System.out.println("Service");
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException("Error updating hall", e);
		}
	}

	public boolean deleteHalls(int hallId) throws ServiceException {
		HallDAO hallDao = new HallDAO();
		try {
			return hallDao.deleteHall(hallId);
		} catch (Exception e) {
			throw new ServiceException("Error deleting hall", e);
		}
	}

	public static List<Hall> getAllHalls() throws ServiceException {
		try {
			return HallDAO.getAllHalls();
		} catch (Exception e) {
			throw new ServiceException("Error retrieving all halls", e);
		}
	}

	public Hall getHallByIdLong(long hallId) throws ServiceException {
		try {
			// Call the DAO to retrieve a hall by its ID
			return HallDAO.getHallByIdLong(hallId);
		} catch (DAOException e) {
			throw new ServiceException("Error retrieving hall by ID", e);
		}
	}
	
	public boolean deleteHall(int hallId) throws ServiceException {
	    HallDAO userDAO = new HallDAO();
	    try {
	        // No need for User object here, just pass the email
    
	        if (userDAO.deleteHall(hallId)) {
	            System.out.println(hallId + " Details are Successfully deleted!");
	            return true;
	        } else {
	            return false;
	        }

	    } catch (DAOException e) {
	        throw new ServiceException(e.getMessage());
	    }
	}
	
	
}
