package com.fssa.project.service;

import com.fssa.project.dao.BookingDAO;
import com.fssa.project.exception.DAOException;
import com.fssa.project.model.Booking;

import java.util.List;

public class BookingService {

    private BookingService() {
    }

    public static boolean createBooking(Booking booking) throws DAOException {
        try {
            return BookingDAO.createBooking(booking);
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public static List<Booking> getAllBookings() throws DAOException {
        try {
            return BookingDAO.getAllBookings();
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public static List<Booking> getBookingsByMallId(int hallId) throws DAOException {
        try {
            return BookingDAO.getBookingsByMallId(hallId);
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
}
