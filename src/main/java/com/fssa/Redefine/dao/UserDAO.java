package com.fssa.redefine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.redefine.dao.exception.DAOException;
import com.fssa.redefine.model.User;

import io.github.cdimascio.dotenv.Dotenv;

public class UserDAO {	
	 //connect to database
	public Connection getConnection() throws SQLException {
		String DB_URL;
		String DB_USER; 
		String DB_PASSWORD;
		
		
		
		
		
 
		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else { 	
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
	 Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	 return connection;
	}

	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO user (userID,username,phone,date_of_birth,email,password) VALUES (?,?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, user.getUserID());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getMobile_number());
		pst.setString(4, user.getDate_of_birth());
		pst.setString(5, user.getEmail());
		pst.setString(6, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}

   //login
	public boolean loginUser(User user) throws DAOException {
		String email = user.getEmail();
		String password = user.getPassword();

		String query = "SELECT user_mail,user_pwd FROM userdata WHERE user_mail = ? AND user_pwd = ?";
		try (Connection connection = getConnection(); PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {

				// User found, login successful else
				return rs.next();

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String SELECTQUERY = "SELECT user_mail FROM userdata WHERE user_mail = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist");
		}
	}
	
	public boolean isLogin(User user) throws DAOException {

		final String SELECTQUERY = "SELECT user_mail, user_pwd FROM userdata WHERE user_mail = ? AND user_pwd = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the user email and password exists
			}

		} catch (SQLException e) {
			throw new DAOException("Error in loggin in");
		}
}
}

