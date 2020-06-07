/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

/**
 *
 * @author Kelvin Wang
 */
import java.sql.Connection;

public abstract class OrderDB {
    protected String URL = "jdbc:derby://localhost:1527/"; //replace this string with your jdbc:derby local host url;
    protected String db = "iotbaydb";//name of the database   
    protected String dbuser = "iotbayadmin";//db root user   
    protected String dbpass = "password123"; //db root password   
    protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
    protected Connection conn; //connection null-instance to be initialized in sub-classes
}
