/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrames;


import Model.Stocks;
import Model.Target;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bimalka
 */
public class DailyTargetFrame extends javax.swing.JInternalFrame {

    //DB connection settings
    String url="jdbc:mysql://localhost:3306/els";
    String username="root";
    String password="";
    Connection con=null;
    Statement st1,st2=null;
    ResultSet rs1,rs2=null;
    
    public ArrayList<Target> targetUpdate(){
        ArrayList<Target> targetList= new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=(Connection) DriverManager.getConnection(url,username,password);
            
            //get item numbers
            String query1="SELECT * FROM stocks";
            st1=(Statement)con.createStatement();
            rs1=st1.executeQuery(query1);
            while(rs1.next()){
                Stocks s =new Stocks();
                Target target=new Target();
                try{
                s.setItemNO(rs1.getString("item_number"));    
                int dailyTarget=0;
                
                //select that row in orders table
                String query2="SELECT * FROM orders WHERE is_deleted=0 && item_number='"+s.getItemNO()+"'";
                st2=(Statement)con.createStatement();
                rs2=st2.executeQuery(query2);
                while(rs2.next()){
                
                //get description,item number,deadline,to be cast values    
                target.setDescription(rs2.getString("description"));
                target.setItemNO(rs2.getString("item_number"));
                
                //calculate the daily target
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String deadline=rs2.getString("deadline");
                Date d2=format.parse(deadline);
                
                //getCurrentDate
                long millis=System.currentTimeMillis();  
                java.sql.Date d1=new java.sql.Date(millis);
                
                //calculate day difference
                int remaining=getDifferenceDays(d1, d2)+1;
                dailyTarget+=rs2.getInt("to_be_cast")/remaining;
                
                
                }
                //set daily target
                target.setDailyTarget(dailyTarget);
                
                //select daily target greater than 0 values and add those objects to list
                if(target.getDailyTarget()>0){
                   System.out.println(target.getDailyTarget());
                   System.out.println(target.getItemNO());
                   System.out.println(target.getDescription());
                   targetList.add(target);
                }
                
                }catch(Exception e){
                    System.out.println("Exception-->"+e);
                }
            }
             
        }catch(Exception e){
            System.out.println("Exception -->"+e);
        }
        return targetList;
    }
    
    public void showDailyTargetReport(){
        ArrayList<Target> list=targetUpdate();
        DefaultTableModel model=(DefaultTableModel)jTable_daily_target_report.getModel();
        Object[] row=new Object[3];
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getItemNO());
            row[0]=list.get(i).getItemNO();
            row[1]=list.get(i).getDescription();
            row[2]=list.get(i).getDailyTarget();
            model.addRow(row);
        
        }
    
    }
    
    int getDifferenceDays(Date d1,Date d2){
    int dayDiff;
    long diff=d2.getTime()-d1.getTime();
    long diffDays=diff/(24*60*60*1000);
    dayDiff=(int)diffDays;
    return dayDiff;
    }

    
    public DailyTargetFrame() {
        initComponents();
        showDailyTargetReport();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_daily_target_report = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daily Target Report");

        jTable_daily_target_report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Number", "Description", "Daily Target"
            }
        ));
        jScrollPane1.setViewportView(jTable_daily_target_report);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_daily_target_report;
    // End of variables declaration//GEN-END:variables
}
