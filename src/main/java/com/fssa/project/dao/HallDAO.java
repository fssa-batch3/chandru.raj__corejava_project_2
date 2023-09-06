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

public class HallDAO {

    public HallDAO() {
    }

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
         
    private static Hall extractHallFromResultSet(ResultSet rs) throws SQLException {
        int hallId = rs.getInt("hall_id");
        String hallName = rs.getString("hall_name");
        String hallLocation = rs.getString("hall_location");
        String mobileNumber = rs.getString("mobile_number"); 
        
        Hall hall = new Hall(hallId, hallName, hallLocation, mobileNumber);
        hall.setHallId(hallId);
        hall.setHallName(hallName);
        hall.setHallLocation(hallLocation);
        hall.setMobileNumber(mobileNumber);
        return hall;
    }

}
