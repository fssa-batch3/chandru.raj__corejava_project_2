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
        String query = "INSERT INTO halls (hall_name, hall_location, mobile_no) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, hall.getHallName());
            pst.setString(2, hall.getHallLocation());
            pst.setString(3, hall.getMobileNumber());

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
    /**
     * Retrieves a list of all Hall objects from the database.
     *
     * @return A List of Hall objects representing all halls in the database.
     * @throws DAOException If a database error occurs.
     */
    public static List<Hall> getAllHalls() throws DAOException {
        List<Hall> halls = new ArrayList<>();
        String query = "SELECT * FROM halls";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	System.out.println("yes");
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
        String query = "UPDATE halls SET hall_name=?, hall_location=?, mobile_no=? WHERE hall_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, hall.getHallName());
            pst.setString(2, hall.getHallLocation());
            pst.setString(3, hall.getMobileNumber());
            pst.setInt(4, hall.getHallId());

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
    public static boolean deleteHall(int hallId) throws DAOException {
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
        
        Hall hall = new Hall(hallId, hallName, hallLocation, mobileNumber);
        hall.setHallId(hallId);
        hall.setHallName(hallName);
        hall.setHallLocation(hallLocation);
        hall.setMobileNumber(mobileNumber);
        return hall;
    }

}
