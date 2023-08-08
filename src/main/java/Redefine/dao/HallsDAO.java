package Redefine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Redefine.dao.exception.DAOException;
import Redefine.model.Halls;

public class HallsDAO {
//Connect to database
	


public Connection getConnection() throws DAOException, SQLException{
	Connection connection = DriverManager.getConnection("jdbc:mysql;//localhost:3306/project","root","root");
	return  connection;
	
}	
//Prepare Sql Statement
public boolean create (Halls halls)throws SQLException, DAOException{
	Connection connection = getConnection();
	String insertQuery = "INSERT INTO halls(hall_id,hall_name,hall_location,mobile_no) VALUES(?,?,?,?);";
	PreparedStatement pst = connection.prepareStatement(insertQuery);
	pst.setInt(1, halls.getHall_id());
	pst.setString(2, halls.getHall_name());
	pst.setString(3,halls.getHall_location());
	pst.setInt(4,halls.getMobile_no());
	
	int rows = pst.executeUpdate();
	return (rows == 1);
	
}

}
