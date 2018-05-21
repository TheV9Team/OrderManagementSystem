/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBConnection;
import Model.Orders;
import Model.Reports;
import Model.Stocks;
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
    int qty;
    int dqty;
    int i=2;
    
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
            String query="UPDATE orders SET is_deleted=? WHERE job_number=?";
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
            if(st!=null){
            st.close();
            }
        }catch(Exception e){
            System.out.println("Exception->>"+e);
        }
        }
    }
    public boolean updateStocks(Stocks s){
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con=(Connection)DriverManager.getConnection(url,username,password);
        String query1="SELECT * FROM stocks WHERE item_number='"+s.getItemNO()+"'";
        st=(Statement)con.createStatement();
        rs=st.executeQuery(query1);
        while(rs.next()){
        qty=rs.getInt("qty");
        qty=qty+new Integer(s.getQty()).intValue();
        String query2="UPDATE stocks SET qty=? WHERE item_number='"+s.getItemNO()+"'";
        pst=(PreparedStatement)con.prepareStatement(query2);
        pst.setInt(1, qty);
        pst.executeUpdate();
        }
        return true;
    }catch(Exception e){
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
            if(st!=null){
            st.close();
            }
        }catch(Exception e){
            System.out.println("Exception->>"+e);
        }
        }
    
    }
    public boolean updateReports(Reports r){
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con=(Connection)DriverManager.getConnection(url,username,password);
        
        //check whether Date is already available
        String query="SELECT * FROM report WHERE Date='"+r.getDate()+"'";
        st=(Statement) con.createStatement();
        rs=st.executeQuery(query);
        
        //If Date is not available , create a new row in a table and update item qty
        if(rs.next()==false){
        
        //insert a new date row
        String query1="INSERT INTO report VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
        pst=(PreparedStatement) con.prepareStatement(query1);
        pst.setString(1,r.getDate());
        while(i<298){
        pst.setInt(i,0);
        i++;
        }
        pst.executeUpdate();
        pst.close();
        
        //Set/update Item number qty
        String query4="UPDATE report SET `"+r.getItemno()+"`=? WHERE Date='"+r.getDate()+"'";
        pst=(PreparedStatement) con.prepareStatement(query4);
        pst.setInt(1, r.getQty());
        pst.executeUpdate();
        rs.close();
            System.out.println("create new date row");
        }
        //if date is available only upadte the item number,qty
        else{
            //Select date
            String query6="SELECT * FROM report WHERE Date='"+r.getDate()+"'";
            st=(Statement) con.createStatement();
            rs=st.executeQuery(query6);
            while(rs.next()){
            dqty=rs.getInt(r.getItemno());
            dqty=dqty+new Integer(r.getQty()).intValue();
            }
        //Update item number quantity
        String query5="UPDATE report SET `"+r.getItemno()+"`=? WHERE Date='"+r.getDate()+"'";
        pst=(PreparedStatement) con.prepareStatement(query5);
        pst.setInt(1, dqty);
        pst.executeUpdate();
            System.out.println("update created date row");
        }
        return true;
    }catch(Exception e){
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
            if(st!=null){
            st.close();
            }
        }catch(Exception e){
            System.out.println("Exception->>"+e);
        }
        }
    
    }
    
}
