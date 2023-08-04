package Redefine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Redefine.dao.exception.*;
import Redefine.model.User;

public class UserDAO {

	
	 //connect to database
	public Connection getConnection() throws SQLException {
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","root");
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
   public boolean login(String email, String password) throws DAOException{
	try {   
	   Connection connection = getConnection();
	   String insertQuery = "Select * from Where email=? and password=?;";
	   PreparedStatement pst = connection.prepareStatement(insertQuery);
	   pst.setString(1,email);
	   pst.setString(2, password);
	   
	   
	
	   //Execute query
	   ResultSet rs = pst.executeQuery();
	   return rs.next();
  
	   }catch(SQLException e) {
		   throw new DAOException(e);
	   }
	   
   }
}

