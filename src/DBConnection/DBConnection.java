/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBConnection;
import Model.Orders;
import java.sql.*;

/**
 *
 * @author Bimalka
 */
public class DBConnection {
    String url="jdbc:mysql://localhost:3306/els";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public boolean addOrders(Orders o){
    try{
    System.out.println("Add New Order 1");
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    System.out.println("Add New Order 1");
    con = (Connection)DriverManager.getConnection(url,username,password);
    String query ="INSERT INTO orders VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    pst = (PreparedStatement) con.prepareStatement(query);
    pst.setInt(1, o.getRequestNumber());
    pst.setString(2,o.getDescription());
    pst.setString(3,o.getItemNo());
    pst.setString(4, o.getClient());
    pst.setString(5,o.getOrderDate() );
    pst.setString(6, o.getJobNumber());
    pst.setString(7,o.getLocation());
    pst.setInt(8, o.getQuantity());
    pst.setString(9, o.getDeadline());
    pst.setInt(10, o.getToBeCast());
    pst.setInt(11, o.getDeliveredQuantity());
    pst.setInt(12, o.getToBeDeliver());
    pst.setInt(13, o.getIsDeleted());
    System.out.println("Add New Order2");
    pst.executeUpdate();
    System.out.println("Add New Order3");
    return true;
    }catch(Exception e){
    System.out.println("exe-->"+e);
    return false;
    }finally{
    try{
    
    }catch(Exception e){
    System.out.println("");
    }
    
    }
    
    }
    
    
}
