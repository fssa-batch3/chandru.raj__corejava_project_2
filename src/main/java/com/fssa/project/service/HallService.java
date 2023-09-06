package com.fssa.project.service;

import com.fssa.project.dao.HallDAO;
import com.fssa.project.exception.DAOException;
import com.fssa.project.exception.ServiceException;
import com.fssa.project.model.Hall;

import java.util.List;

public class HallService {

    public int createHall(Hall hall) throws ServiceException {
        try {
        	//ToDo need check  whether the data already exists
            return HallDAO.createHall(hall);
        } catch (DAOException e) {
            throw new ServiceException("Failed to create hall", e);
        }
    }
                        
    public Hall readHall(int hallId) throws ServiceException {
        try {
            return HallDAO.getHallById(hallId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to read hall", e);
        }
    }

    public static List<Hall> getAllHalls() throws ServiceException {
        try {
            return HallDAO.getAllHalls();
        } catch (DAOException e) {
            throw new ServiceException("Failed to get halls", e);
        }
    }
      
    public boolean updateHall(Hall hall) throws ServiceException {
        try {
            return HallDAO.updateHall(hall);
        } catch (DAOException e) {
            throw new ServiceException("Failed to update hall", e);
        }
    }

    public boolean deleteHall(int hallId) throws ServiceException {
        try {
            return HallDAO.deleteHall(hallId);
        } catch (DAOException e) {
            throw new ServiceException("Failed to delete hall", e);
        }
    }
}
