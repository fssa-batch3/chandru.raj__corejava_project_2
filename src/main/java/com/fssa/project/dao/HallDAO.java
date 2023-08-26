package com.fssa.project.dao;

import com.fssa.project.exception.DAOException;

import com.fssa.project.model.Hall;

import com.fssa.project.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallDAO {

    private HallDAO() {
    }

    public static boolean createHall(Hall hall) throws DAOException {
        String query = "INSERT INTO halls (hall_name, hall_location, mobile_number) " +
                "VALUES (?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, hall.getHallName());
            pst.setString(2, hall.getHallLocation());
            pst.setString(3, hall.getMobileNumber());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    public static Hall readHall(int hallId) throws DAOException {
        String query = "SELECT * FROM halls WHERE hall_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, hallId);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                Hall hall = new Hall();
                hall.setHallId(resultSet.getInt("hall_id"));
                hall.setHallName(resultSet.getString("hall_name"));
                hall.setHallLocation(resultSet.getString("hall_location"));
                hall.setMobileNumber(resultSet.getString("mobile_number"));
                return hall;
            }

            return null; // Hall not found

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static boolean updateHall(Hall hall) throws DAOException {
        String query = "UPDATE halls SET hall_name = ?, hall_location = ?, mobile_number = ? WHERE hall_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, hall.getHallName());
            pst.setString(2, hall.getHallLocation());
            pst.setString(3, hall.getMobileNumber());
            pst.setInt(4, hall.getHallId()); // Assuming Hall class has a getHallId() method

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static boolean deleteHall(int hallId) throws DAOException {
        String query = "DELETE FROM halls WHERE hall_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, hallId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
