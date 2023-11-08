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

    public UserDAO() {
    }

    /**
     * Creates a new user in the database.
     *
     * @param user The User object representing the user to be created.
     * @return True if the user is created successfully, false otherwise.
     * @throws DAOException If an error occurs while interacting with the database.
     * 
     * 
     * @author ChandruRaj
     */
    public static boolean createUser(User user) throws DAOException {
        String query = "INSERT INTO user (name, mobile_number, email, password, isseller, is_active, is_deleted) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, user.getName());
            pst.setString(2, user.getMobileNumber());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.setInt(5, user.isseller);
            pst.setBoolean(6, user.isActive());
            pst.setBoolean(7, user.isDeleted());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    /**
     * Checks if a user with the given email already exists in the database.
     *
     * @param email The email address to be checked.
     * @return True if the email is available (not already in use), false otherwise.
     * @throws DAOException If an error occurs while interacting with the database.
     */
    
 // Check the user is already exists or not
 	public boolean checkUserDataExistOrNot(String email) throws DAOException {
 		String selectQuery = "SELECT email FROM user WHERE email = ?";
 		try (Connection connection = ConnectionUtil.getConnection();

 				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
 			statement.setString(1, email);

 			try (ResultSet resultSet = statement.executeQuery()) {
 				if (resultSet.next()) {
 					throw new DAOException("User email already exist, try another email");
 				} else {
 					return true;
 				}
 			}

 		} catch (SQLException e) {
 			throw new DAOException(e);
 		}
 	}
    
 	 /**
     * Retrieves a user from the database based on the user ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return The User object if found, or null if not found.
     * @throws DAOException If an error occurs while interacting with the database.
     */

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
    /**
     * Retrieves a list of all users from the database.
     *
     * @return A List of User objects.
     * @throws DAOException If an error occurs while interacting with the database.
     */
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
    /**
     * Updates the user information in the database.
     *
     * @param user The User object containing updated information.
     * @return True if the update is successful, false otherwise.
     * @throws DAOException If an error occurs while interacting with the database.
     */
    public static boolean updateUser(User user) throws DAOException {
        String query = "UPDATE user SET name=?, mobile_number=?, email=?, password=?, is_active=?, is_deleted=? WHERE user_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, user.getName());
            
            pst.setString(2, user.getMobileNumber());
            
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            
            pst.setBoolean(5, user.isActive());
            pst.setBoolean(6, user.isDeleted());
            pst.setInt(7, user.getUserId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    /**
     * Attempts to log in a user with the given email and password.
     *
     * @param email    The email address of the user.
     * @param password The password of the user.
     * @return True if login is successful, false otherwise.
     * @throws DAOException If an error occurs while interacting with the database.
     */
    public static boolean loginUser(String email, String password) throws DAOException {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, email);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    /**
     * Retrieves a user from the database based on the email address.
     *
     * @param email The email address of the user to retrieve.
     * @return The User object if found, or null if not found.
     * @throws DAOException If an error occurs while interacting with the database.
     */
    public static User getUserByEmail(String email) throws DAOException {
        String query = "SELECT * FROM user WHERE email = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, email);
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


    /**
     * Deletes a user from the database based on the user ID.
     *
     * @param userId The ID of the user to be deleted.
     * @return True if deletion is successful, false otherwise.
     * @throws DAOException If an error occurs while interacting with the database.
     */
 
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
    /**
     * Finds the user type (seller or not) based on the email address.
     *
     * @param email The email address of the user.
     * @return The user type (1 if seller, 0 if not).
     * @throws DAOException If an error occurs while interacting with the database.
     */
    public static int findTypeByEmail(String email) throws DAOException {
		String sql = "SELECT isseller FROM user WHERE email = ?";
		int type = 0; 
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				type = resultSet.getInt("isseller");
			} else {
				throw new DAOException("User not found.");
			}
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("Database error: " + e.getMessage());
		}
		return type;
	}
    /**
     * Retrieves the task assignee email from the database based on the email address.
     *
     * @param email The email address of the user to retrieve the task assignee email.
     * @return The task assignee email if found, or null if not found.
     * @throws DAOException If an error occurs while interacting with the database.
     */
    public static String getTaskAssigneeByEmail(String email) throws DAOException {
        String query = "SELECT email FROM users WHERE email = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, email);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("email");
                }
                return null;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        int userId = rs.getInt("user_id");
       
        String name = rs.getString("name");        
        String mobileNumber = rs.getString("mobile_number");        
        String email = rs.getString("email");
        String password = rs.getString("password");
        boolean isActive = rs.getBoolean("is_active");
        boolean isDeleted = rs.getBoolean("is_deleted");
        
        
        User user = new User(name, mobileNumber,email, password);
        user.setUserId(userId);
        int f=user.getUserId();
        user.setActive(isActive);
        user.setDeleted(isDeleted);
        return user;
    }

	
}
