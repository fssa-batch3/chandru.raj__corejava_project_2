package com.fssa.redefine.services;

import com.fssa.redefine.dao.HallsDAO;
import com.fssa.redefine.dao.exception.DAOException;
import com.fssa.redefine.model.Halls;
import com.google.protobuf.ServiceException;

public class HallsService {
    private HallsDAO hallsDAO; 

    public HallsService() {
        this.hallsDAO = new HallsDAO(); 
    }

    public boolean addHall(Halls halls) throws ServiceException {
    // HallsDAO halls = new HallsDAO();
        try {
            if (HallsDAO.create(halls)) {
                System.out.println(halls.getHall_name() + " hall successfully added");
                return true;
            }
        } catch (Exception e) {
            throw new ServiceException("Error adding hall", e);
        }
        return false;
    }
    
    
        public boolean updateHall(Halls updatedHall) throws ServiceException {
            try {
                if (updatedHall.getHall_name() == null || updatedHall.getHall_name().isEmpty()) {
                    throw new ServiceException("Invalid hall name");
                }

                
                
                HallsDAO hallsDAO = new HallsDAO();
                boolean result = hallsDAO.update(updatedHall);

                if (result) {
                    System.out.println("Hall updated successfully.");
                } else {
                    System.out.println("Failed to update hall.");
                }
                return result;
            } catch (DAOException e) {
                throw new ServiceException("Error while updating hall", e);
            }
        }
    }

