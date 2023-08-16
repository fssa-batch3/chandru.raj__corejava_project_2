package com.fssa.redefine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.redefine.dao.exception.DAOException;
import com.fssa.redefine.model.Halls;

public class HallsDAO {
//Connect to database

	public static Connection getConnection() throws DAOException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend","root","root");
		return connection;
       
	}

//Prepare Sql Statement
	public static boolean create(Halls halls) throws SQLException, DAOException {
	    Connection connection = getConnection();
	    String insertQuery = "INSERT INTO halls(hall_name,hall_location,mobile_no) VALUES(?,?,?);";
	    PreparedStatement pst = connection.prepareStatement(insertQuery);

	    pst.setString(1, halls.getHall_name());
	    pst.setString(2, halls.getHall_location());
	    pst.setInt(3, halls.getMobile_no());

	    int rows = pst.executeUpdate();
	    System.out.println(rows + " row(s) inserted.");
	    return (rows == 1);
	}


	

public boolean update(Halls halls)throws DAOException {
	
	int row = 0;
	try {
	Connection connection = getConnection();
	
	String updatequery = "UPDATE halls SET hall_name=?,hall_location=?,mobile_no=? WHERE 	hall_name=?";
	PreparedStatement pst = connection.prepareStatement(updatequery);
	

    pst.setString(1, halls.getHall_name());
    pst.setString(2, halls.getHall_location());
    pst.setInt(3, halls.getMobile_no());
    pst.setString(4, halls.getHall_name());
	
	
	row = pst.executeUpdate();
	
	}catch(SQLException e){
		throw new DAOException(e);
	}
	return (row == 1);
}

//delete
public boolean delete(Halls halls)throws DAOException {
	try {
	Connection connection = getConnection();
	
	String deletequery = "UPDATE halls SET hall_name=?,hall_location=?,mobile_no=? WHERE 	hall_name=?";
	PreparedStatement pst = connection.prepareStatement(deletequery);
	pst.setString(1, halls.getHall_name());
    pst.setString(2, halls.getHall_location());
    pst.setInt(3, halls.getMobile_no());
	
	int row = pst.executeUpdate();
	
	return (row == 1);
	
	
}catch(SQLException e) {
	throw new DAOException(e);
}
}
}