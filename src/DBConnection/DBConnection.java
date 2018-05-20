/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBConnection;
import Model.Orders;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    Statement st=null;
    
    int to_be_cast;
    int delivered_quantity;
    int to_be_deliver;
    
    public boolean addOrders(Orders o){
    try{
    System.out.println("Add New Order 1");
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    System.out.println("Add New Order 1");
    con = (Connection)DriverManager.getConnection(url,username,password);
    String query ="INSERT INTO orders VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
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
    pst.setInt(13,o.getDailyTarget());
    pst.setInt(14, o.getIsDeleted());
    System.out.println("Add New Order2");
    pst.executeUpdate();
    System.out.println("Add New Order3");
    return true;
    }catch(Exception e){
    System.out.println("exe-->"+e);
    return false;
    }finally{
    try{
    if(pst !=null){
        pst.close();
        }
        if(con !=null){
        con.close();
        }
        if(rs !=null){
        rs.close();
        }
    }catch(Exception e){
    System.out.println("exe-->"+e);
    }
    
    }
    
    }
    public boolean deleteJob(String jobno){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=(Connection)DriverManager.getConnection(url,username,password);
            String query="UPDATE orders set is_deleted=? WHERE job_number=?";
            pst=(PreparedStatement)con.prepareStatement(query);
            pst.setInt(1, 1);
            pst.setString(2,jobno);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception->>"+e);
            return false;
        }finally{
        try{
            if(con!=null){
            con.close();
            }
            if(pst!=null){
            pst.close();
            }
            if(rs!=null){
            rs.close();
            }
        }catch(Exception e){
            System.out.println("Exception->>"+e);
        }
        }
    }
    public boolean updateJob(Orders o,int proqty,int delqty){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("1");
            con=(Connection)DriverManager.getConnection(url,username,password);
            System.out.println("2");
            String query1="SELECT * FROM orders WHERE job_number='"+o.getJobNumber()+"' && item_number='"+o.getItemNo()+"'";
            System.out.println("3");
            st=(Statement)con.createStatement();
            System.out.println("4");
            rs=st.executeQuery(query1);
            System.out.println("5");
            while(rs.next()){
            to_be_cast=rs.getInt("to_be_cast")-proqty;
            System.out.println("6");
            delivered_quantity=rs.getInt("delivered_quantity")+delqty;
            System.out.println("7");
            to_be_deliver=rs.getInt("to_be_deliver")-delqty;
            }
            String query2="UPDATE orders SET to_be_cast=?,delivered_quantity=?,to_be_deliver=? WHERE job_number='"+o.getJobNumber()+"' && item_number='"+o.getItemNo()+"'";
            System.out.println("8");
            pst=(PreparedStatement)con.prepareStatement(query2);
            System.out.println("9");
            pst.setInt(1, to_be_cast);
            System.out.println("10");
            pst.setInt(2, delivered_quantity);
            System.out.println("11");
            pst.setInt(3,to_be_deliver);
            pst.executeUpdate();
            System.out.println("12");
            return true;
        }catch(Exception e){
            System.out.println("exception->>"+e);
            return false;
        }
    }
    
}
