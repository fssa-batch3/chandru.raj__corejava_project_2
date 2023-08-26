package com.fssa.project.service;

import com.fssa.project.dao.HallDAO;
import com.fssa.project.exception.DAOException;
import com.fssa.project.exception.ServiceException;
import com.fssa.project.exception.ValidationException;
import com.fssa.project.model.Hall;
import com.fssa.project.validation.HallValidator;

public class HallService {

    public String createHall(Hall hall) throws ServiceException {
        try {
            HallValidator hallValidator = new HallValidator(hall);
            hallValidator.validateAll();

            if (HallDAO.createHall(hall)) {
                return "Hall Created Successfully";
            } else {
                throw new ServiceException("Hall Creation Failed");
            }
        } catch (ValidationException e) {
            throw new ServiceException("Invalid Hall Data", e);
        } catch (DAOException e) {
            throw new ServiceException("Database Error", e);
        }
    }

    public Hall readHall(int hallId) throws ServiceException {
        try {
            return HallDAO.readHall(hallId);
        } catch (DAOException e) {
            throw new ServiceException("Error while reading hall", e);
        }
    }

    public String updateHall(Hall hall) throws ServiceException {
        try {
            HallValidator hallValidator = new HallValidator(hall);
            hallValidator.validateAll();

            if (HallDAO.updateHall(hall)) {
                return "Hall Updated Successfully";
            } else {
                throw new ServiceException("Hall Update Failed");
            }
        } catch (ValidationException e) {
            throw new ServiceException("Invalid Hall Data", e);
        } catch (DAOException e) {
            throw new ServiceException("Database Error", e);
        }
    }

    public String deleteHall(int hallId) throws ServiceException {
        try {
            if (HallDAO.deleteHall(hallId)) {
                return "Hall Deleted Successfully";
            } else {
                throw new ServiceException("Hall Deletion Failed");
            }
        } catch (DAOException e) {
            throw new ServiceException("Database Error", e);
        }
    }
}
