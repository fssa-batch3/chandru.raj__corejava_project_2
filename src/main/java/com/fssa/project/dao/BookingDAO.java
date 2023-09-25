package com.fssa.project.dao;

import com.fssa.project.exception.DAOException;
import com.fssa.project.model.Booking;
import com.fssa.project.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private BookingDAO() {
    }

    public static boolean createBooking(Booking booking) throws DAOException {
        String query = "INSERT INTO bookings (user_email, hall_id, booking_date) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, booking.getUserEmail()); // Use user_email instead of user_id
            pst.setInt(2, booking.getHallId());
            pst.setDate(3, booking.getBookingDate());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the auto-generated ID
                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        booking.setId(id); // Set the generated ID in the Booking object
                    } else {
                        throw new DAOException("Failed to retrieve the generated ID.");
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Booking> getAllBookings() throws DAOException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                bookings.add(extractBookingFromResultSet(rs));
            }
            return bookings;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Booking> getBookingsByMallId(int hallId) throws DAOException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE hall_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, hallId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    bookings.add(extractBookingFromResultSet(rs));
                }
                return bookings;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private static Booking extractBookingFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String userEmail = rs.getString("user_email");
        int hallId = rs.getInt("hall_id");
        java.sql.Date bookingDate = rs.getDate("booking_date");

        // Create a Booking object without setting the ID initially
        Booking booking = new Booking(userEmail, hallId, bookingDate);

        // Set the ID separately
        booking.setId(id);

        return booking;
    }

    
    public static boolean isBookingDateOccupied(Date bookingDate, int hallId) throws DAOException {
        String query = "SELECT COUNT(*) FROM bookings WHERE booking_date = ? AND hall_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setDate(1, bookingDate);
            pst.setInt(2, hallId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // If count is greater than 0, the date is occupied
                } else {
                    throw new DAOException("Error while checking booking date occupancy.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    
}
