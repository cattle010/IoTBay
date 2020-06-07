package uts.isd.model.dao;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
/**
 *
 * @author Kelvin Wang
 */
public class OrderDBConnector extends OrderDB{

public OrderDBConnector() throws ClassNotFoundException, SQLException {

Class.forName(driver);

conn = DriverManager.getConnection(URL, dbuser, dbpass);

}

 

public Connection openConnection(){

return this.conn;

}

 

public void closeConnection() throws SQLException {

this.conn.close();

}
}
