package com.fssa.project.dao;

import com.fssa.project.exception.DAOException;

import com.fssa.project.model.Hall;
import com.fssa.project.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Data Access Object (DAO) for managing Hall objects in the database.
 * 
 * @author ChandruRaj
 */
public class HallDAO {

    /**
     * Constructs a new HallDAO object.
     */
    public HallDAO() {
    }

    /**
     * Creates a new hall record in the database.
     *
     * @param hall The Hall object to be inserted into the database.
     * @return The number of rows affected by the insert operation.
     * @throws DAOException If a database error occurs.
     */
    public static int createHall(Hall hall) throws DAOException {
        String query = "INSERT INTO halls (hall_name, hall_location, mobile_no, capacity, price, email, url, url1, url2, url3, url4, url5, url6) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, hall.getHallName());
            pst.setString(2, hall.getHallLocation());
            pst.setString(3, hall.getMobileNumber());
            pst.setString(4, hall.getCapacity());
            pst.setString(5, hall.getPricing());
            pst.setString(6, hall.getEmail());
            pst.setString(7, hall.getUrl());
            pst.setString(8, hall.getUrl1());
            pst.setString(9, hall.getUrl2());
            pst.setString(10, hall.getUrl3());
            pst.setString(11, hall.getUrl4());
            pst.setString(12, hall.getUrl5());
            pst.setString(13, hall.getUrl6());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retrieves a Hall object by its unique ID from the database.
     *
     * @param hallId The ID of the Hall to retrieve.
     * @return The Hall object if found, or null if not found.
     * @throws DAOException If a database error occurs.
     */
    public static Hall getHallById(int hallId) throws DAOException {
        String query = "SELECT * FROM halls WHERE hall_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, hallId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return extractHallFromResultSet(rs);
                }
                return null;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static Hall getHallByIdLong(long hallId) throws DAOException {
        String query = "SELECT * FROM halls WHERE hall_id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, hallId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Create a Hall object from the retrieved data
                    Hall hall = extractHallFromResultSet(rs);
                    return hall;
                } else {
                    // Hall not found, return null
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void main(String[] args) {
        try {
            Hall hall = HallDAO.getHallById(34);

            System.out.println(hall);
            System.out.println(hall.getCapacity());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a list of all Hall objects from the database.
     *
     * @return A List of Hall objects representing all halls in the database.
     * @throws DAOException If a database error occurs.
     */
    public static List<Hall> getAllHalls() throws DAOException {
        List<Hall> halls = new ArrayList<>();
        String query = "SELECT * FROM halls WHERE is_deleted = 0";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                halls.add(extractHallFromResultSet(rs));
            }
            return halls;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Updates an existing hall record in the database.
     *
     * @param hall The Hall object with updated information.
     * @return True if the update was successful, false otherwise.
     * @throws DAOException If a database error occurs.
     */
    public static boolean updateHall(Hall hall) throws DAOException {
        String query = "UPDATE halls SET hall_name=?, hall_location=?, mobile_no=?, capacity=?, price=?, email=?, url=?, url1=?, url2=?, url3=?, url4=?, url5=?, url6=? WHERE hall_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, hall.getHallName());
            pst.setString(2, hall.getHallLocation());
            pst.setString(3, hall.getMobileNumber());
            pst.setString(4, hall.getCapacity());
            pst.setString(5, hall.getPricing());
            pst.setString(6, hall.getEmail()); 
            pst.setString(7, hall.getUrl());
            pst.setString(8, hall.getUrl1());
            pst.setString(9, hall.getUrl2());
            pst.setString(10, hall.getUrl3());
            pst.setString(11, hall.getUrl4());
            pst.setString(12, hall.getUrl5());
            pst.setString(13, hall.getUrl6());
            pst.setInt(14, hall.getHallId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected == 1;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Deletes a hall record from the database by its unique ID.
     *
     * @param hallId The ID of the Hall to delete.
     * @return True if the delete operation was successful, false otherwise.
     * @throws DAOException If a database error occurs.
     */
    public static boolean deleteHalls(int hallId) throws DAOException {
        String query = "DELETE FROM halls WHERE hall_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, hallId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean deleteHall(int hallId) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE halls SET is_deleted = 1 WHERE hall_id = ?")) {

            statement.setInt(1, hallId);

            int rows = statement.executeUpdate();

            return (rows == 1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Extracts a Hall object from a ResultSet obtained from a database query.
     *
     * @param rs The ResultSet containing the hall information.
     * @return The extracted Hall object.
     * @throws SQLException If a database error occurs while extracting data.
     */
    private static Hall extractHallFromResultSet(ResultSet rs) throws SQLException {
        int hallId = rs.getInt("hall_id");
        String hallName = rs.getString("hall_name");
        String hallLocation = rs.getString("hall_location");
        String mobileNumber = rs.getString("mobile_no");
        String capacity = rs.getString("capacity");
        String pricing = rs.getString("price");
        String email = rs.getString("email"); // Add this line for email
        String url = rs.getString("url");
        String url1 = rs.getString("url1");
        String url2 = rs.getString("url2");
        String url3 = rs.getString("url3");
        String url4 = rs.getString("url4");
        String url5 = rs.getString("url5");
        String url6 = rs.getString("url6");

        Hall hall = new Hall(hallId, hallName, hallLocation, mobileNumber, capacity, pricing, email, url, url1, url2, url3, url4, url5, url6);
        hall.setHallId(hallId);
        hall.setHallName(hallName);
        hall.setHallLocation(hallLocation);
        hall.setMobileNumber(mobileNumber);
        hall.setCapacity(capacity);
        hall.setPricing(pricing);
        hall.setEmail(email);
        hall.setUrl(url);
        hall.setUrl1(url1);
        hall.setUrl2(url2);
        hall.setUrl3(url3);
        hall.setUrl4(url4);
        hall.setUrl5(url5);
        hall.setUrl6(url6);
        return hall;
    }
}
