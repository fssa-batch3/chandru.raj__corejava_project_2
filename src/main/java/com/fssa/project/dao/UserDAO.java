package com.fssa.project.dao;

import com.fssa.project.exception.DAOException;
import com.fssa.project.model.User;
import com.fssa.project.utils.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private UserDAO() {
    }

    public static boolean createUser(User user) throws DAOException {
        String query = "INSERT INTO user (name, gender, mobile_number, date_of_birth, email, password, is_active, is_deleted) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, user.getName());
            pst.setString(2, user.getGender());
            pst.setString(3, user.getMobileNumber());
            pst.setDate(4, Date.valueOf(user.getDateOfBirth()));
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getPassword());
            pst.setBoolean(7, user.isActive());
            pst.setBoolean(8, user.isDeleted());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static User getUserById(int userId) throws DAOException {
        String query = "SELECT * FROM user WHERE user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, userId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
                return null;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<User> getAllUsers() throws DAOException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
            return users;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static boolean updateUser(User user) throws DAOException {
        String query = "UPDATE user SET name=?, gender=?, mobile_number=?, date_of_birth=?, email=?, password=?, " +
                "is_active=?, is_deleted=? WHERE user_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, user.getName());
            pst.setString(2, user.getGender());
            pst.setString(3, user.getMobileNumber());
            pst.setDate(4, Date.valueOf(user.getDateOfBirth()));
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getPassword());
            pst.setBoolean(7, user.isActive());
            pst.setBoolean(8, user.isDeleted());
            pst.setInt(9, user.getUserId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static boolean deleteUser(int userId) throws DAOException {
        String query = "DELETE FROM user WHERE user_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, userId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        int userId = rs.getInt("user_id");
        String name = rs.getString("name");
        String gender = rs.getString("gender");
        String mobileNumber = rs.getString("mobile_number");
        LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
        String email = rs.getString("email");
        String password = rs.getString("password");
        boolean isActive = rs.getBoolean("is_active");
        boolean isDeleted = rs.getBoolean("is_deleted");

        User user = new User(name, gender, mobileNumber, dateOfBirth, email, password);
        user.setUserId(userId);
        user.setActive(isActive);
        user.setDeleted(isDeleted);
        return user;
    }

   
}
