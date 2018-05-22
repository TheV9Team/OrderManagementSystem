/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrames;

import Model.Reports;
import Model.Stocks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bimalka
 */
public class DailyProductionFrame extends javax.swing.JInternalFrame {

   //db connection setup
    String url="jdbc:mysql://localhost:3306/els";
    String username="root";
    String password="";
    Connection con=null;
    Statement st1=null;
    ResultSet rs1=null;
    Statement st2=null;
    ResultSet rs2=null;
    
    
    public DailyProductionFrame() {
        initComponents();
    }
    
    public ArrayList<Stocks> dailyProduction(Reports r){
        ArrayList<Stocks> productionList=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=(Connection) DriverManager.getConnection(url,username,password);
            String query1="SELECT * FROM stocks";
            st1=(Statement) con.createStatement();
            rs1=st1.executeQuery(query1);
            while(rs1.next()){
                Stocks s = new Stocks();
                s.setItemNO(rs1.getString("item_number"));
                s.setDescription(rs1.getString("description"));
                try{
                    String query2="SELECT `"+s.getItemNO()+"` FROM report WHERE Date='"+r.getDate()+"'";
                    st2=(Statement) con.createStatement();
                    rs2=st2.executeQuery(query2);
                    while(rs2.next()){
                    s.setQty(rs2.getInt(s.getItemNO()));
                    if(s.getQty()>0){
                    productionList.add(s);
                     }
                    }
                }catch(Exception e){
                    System.out.println("Exception -->"+e);
                
                }
                
            }
        }catch(Exception e){
            System.out.println("exception -->"+e);
        }
        
    return productionList;
    } 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_production_report = new javax.swing.JTable();
        txtDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daily Production Report");

        jTable_production_report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Number", "Description", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable_production_report);

        txtDate.setName("yyyy-mm-dd"); // NOI18N
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Date Here :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        
        
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        Reports report = new Reports();
        report.setDate(txtDate.getText());
        ArrayList<Stocks> list=dailyProduction(report);
        DefaultTableModel model=(DefaultTableModel)jTable_production_report.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
        model.removeRow(i);
        }
        Object[] row=new Object[3];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getItemNO();
        row[1]=list.get(i).getDescription();
        row[2]=list.get(i).getQty();
        model.addRow(row);
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_production_report;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
