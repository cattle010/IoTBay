
package uts.isd.model.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Xuanhao Zhou
 */
public class DBManager {
    private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
  }

public boolean checkProduct(int productid) throws SQLException{
    String fetch = "select * from iotbayadmin.product_t where productid = "+ productid ;      
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()){
        int pid = rs.getInt(1);
        if(pid == productid)
            return true;
    }
       return false;
}

public void addProduct(int productid, String productname, String brandname, String description, double costperunit, int stock) throws SQLException {
    st.executeUpdate("insert into iotbayadmin.product_t" + " values(" + productid + ", '" + productname+ "', '"+brandname+"', '"+description+"', "+costperunit+", "+stock+")");
}

public boolean checkUser(int userid,String password) throws SQLException{
    String fetch = "select * from iotbayadmin.user_t where USERID= '"+ userid +"' and PASSWORD = '" + password + "'";      
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()){
        int uid = rs.getInt(1);
        String userpass = rs.getString(5);
        if(uid == userid && userpass.equals(password))
            return true;
    }
       return false;
}

public Product findProduct(int productid) throws SQLException{
   String fetch = "select * from product_t where productid = "+ productid ;//setup the select sql query string       
   ResultSet rs = st.executeQuery(fetch);   //execute this query using the statement field       
   

   while(rs.next()){
      int pid = rs.getInt(1);
      if(pid == productid){
           String productname = rs.getString(2);
           String brandname = rs.getString(3);
           String description = rs.getString(4);
           double cpu = rs.getDouble(5);
            int stock = rs.getInt(6);
            return new Product(pid,productname,brandname,description,cpu,stock);
            }
   }
   
   return null;   

}

public ArrayList<Product> fetchProduct() throws SQLException{
    String fetch = "select * from iotbayadmin.product_t";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList temp = new ArrayList();
    
    while(rs.next()){
        int productID = rs.getInt(1);
        String productName = rs.getString(2);
        String brandName = rs.getString(3);
        String description = rs.getString(4);
        double costPerUnit = rs.getDouble(5);
        int stock = rs.getInt(6);
        temp.add(new Product(productID,productName,brandName,description,costPerUnit,stock));
    }
    return temp;
}

public void updateProduct(int productid, String productname, String brandname, String description, double costperunit, int stock) throws SQLException {       
     st.executeUpdate("update iotbayadmin.product_t set productname = '" +  productname + "', brandname = '" + brandname + "', description = '" + 
                                                          description + "', costperunit = " + costperunit + ", stock = " + stock + " where productid = " + productid );

}     

public void deleteProduct(int productid) throws SQLException{       
   st.executeUpdate("delete from iotbayadmin.product_t where productid = " + productid);

}

}