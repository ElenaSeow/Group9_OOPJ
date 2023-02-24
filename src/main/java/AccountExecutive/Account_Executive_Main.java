/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AccountExecutive;


import com.mycompany.group9_oopj.Main_Page;
import cClasses.Invoices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.server.UID;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Account_Executive_Main extends javax.swing.JFrame {
    
    Invoices.FileManipulation IV = new Invoices.FileManipulation();
    /**
     * Creates new form Account_Executive_Main
     */
    public Account_Executive_Main() {
        initComponents();
        
        dt(); //Input Date and Time
    }
    
    public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fees = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        unitID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        outstandingFees = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        paymentAmount = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        clearBtn = new javax.swing.JButton();
        addPaymentBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        receiptBtn = new javax.swing.JButton();
        getInfoBtn = new javax.swing.JButton();
        Time = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(114, 126, 224));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Account Executive");

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Parkhill Residence");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(67, 63, 113));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        logoutBtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("   Logout");
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        jTabbedPane1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel4.setText("Search User ID");

        userID.setText("User ID");
        userID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userIDMouseClicked(evt);
            }
        });
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });

        jLabel5.setText("Fees:");

        fees.setText("Fees");
        fees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feesMouseClicked(evt);
            }
        });

        jLabel6.setText("Unit ID:");

        unitID.setText("Unit ID");
        unitID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unitIDMouseClicked(evt);
            }
        });

        jLabel7.setText("Outstanding Fees:");

        outstandingFees.setText("Outstanding");
        outstandingFees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outstandingFeesMouseClicked(evt);
            }
        });

        jLabel8.setText("Payment Amount:");

        paymentAmount.setText("Amount");
        paymentAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentAmountMouseClicked(evt);
            }
        });

        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        addPaymentBtn.setText("Add Payment");
        addPaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPaymentBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        receiptBtn.setText("Print Receipt");
        receiptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptBtnActionPerformed(evt);
            }
        });

        getInfoBtn.setText("Get Info");
        getInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getInfoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userID)
                        .addGap(18, 18, 18)
                        .addComponent(getInfoBtn)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addPaymentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(receiptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(unitID)
                                            .addComponent(fees)
                                            .addComponent(outstandingFees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(paymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getInfoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outstandingFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn)
                            .addComponent(receiptBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addPaymentBtn)
                            .addComponent(clearBtn))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Payment", jPanel2);

        Time.setBackground(new java.awt.Color(0, 0, 0));
        Time.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setText("Time");

        Date.setBackground(new java.awt.Color(255, 255, 255));
        Date.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Date.setText("Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Time)
                    .addComponent(Date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // For Date and Time
    Timer t;
    SimpleDateFormat st;
    
    public void dt(){
    
        // Date
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String dd = sdf.format(d);
        Date.setText(dd);
        
        // Time
        t = new Timer (0, new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                
                String tt = st.format(dt);
                Time.setText(tt);
            }
        }); 
           t.start(); 
        
    }
    
    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        Main_Page MP = new Main_Page();
        MP.show(); //display Main Page

        dispose(); //close current frame after open new frame
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        
    }//GEN-LAST:event_userIDActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        if(table.getSelectedRow() != -1){
            fees.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            unitID.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            outstandingFees.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_tableMousePressed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        table.setModel(new DefaultTableModel());
        userID.setText("");
        unitID.setText("...");
        fees.setText("");
        outstandingFees.setText("");
        paymentAmount.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void addPaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPaymentBtnActionPerformed
        if(!paymentAmount.getText().equals("")){
            String outstanding = Integer.toString(Integer.parseInt(outstandingFees.getText())-Integer.parseInt(paymentAmount.getText()));
            String date = LocalDate.now().now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            IV.addFile(userID.getText(), unitID.getText(), fees.getText(), outstanding, date);
            JOptionPane.showMessageDialog(null,"Successfully Made Payment!");
            paymentAmount.setText("");
        }
    }//GEN-LAST:event_addPaymentBtnActionPerformed

    private void receiptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptBtnActionPerformed
        if(table.getSelectedRow() != -1){
            String ID = table.getValueAt(table.getSelectedRow(), 0).toString();
            String userID = table.getValueAt(table.getSelectedRow(), 1).toString();
            String unitID = table.getValueAt(table.getSelectedRow(), 2).toString();
            String fee = table.getValueAt(table.getSelectedRow(), 3).toString();
            String out = table.getValueAt(table.getSelectedRow(), 4).toString();
            String date = table.getValueAt(table.getSelectedRow(), 5).toString();
            JOptionPane.showMessageDialog(null,"============== Receipt ==============\n"
                                                            + "Invoice ID: " + ID + "\n"
                                                            + "User ID: " + userID + "\n"
                                                            + "Unit ID: " + unitID + "\n"
                                                            + "Fee: " + fee + "\n"
                                                            + "Outstanding: " + out + "\n"
                                                            + "Date: " + date + "\n"
                                                            + "====================================\n"
                                                            + "============= Thank You! ============="
            );
        }
    }//GEN-LAST:event_receiptBtnActionPerformed

    private void getInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getInfoBtnActionPerformed
        String userIDInput = userID.getText();
        if (!userIDInput.equals("")) {
            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);
            try (BufferedReader br = new BufferedReader(new FileReader("Invoices.txt"))) {
                String firstLine = br.readLine().trim();
                String[] columnNames = firstLine.split(",");
                model.setColumnIdentifiers(columnNames);
                Object[] tableLines = br.lines().toArray();
                for (Object tableLine : tableLines) {
                    String line = tableLine.toString().trim();
                    String[] dataRow = line.split(",");
                    if (dataRow.length == columnNames.length && dataRow[1].equals(userIDInput)) {
                     model.addRow(dataRow);
                        unitID.setText(dataRow[2]);
                        fees.setText(dataRow[3]);
                        outstandingFees.setText(dataRow[4]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Data format error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_getInfoBtnActionPerformed

    private void userIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userIDMouseClicked
        userID.setText("");
    }//GEN-LAST:event_userIDMouseClicked

    private void feesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feesMouseClicked
        fees.setText("");
    }//GEN-LAST:event_feesMouseClicked

    private void unitIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unitIDMouseClicked
        unitID.setText("");
    }//GEN-LAST:event_unitIDMouseClicked

    private void outstandingFeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outstandingFeesMouseClicked
        outstandingFees.setText("");
    }//GEN-LAST:event_outstandingFeesMouseClicked

    private void paymentAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentAmountMouseClicked
        paymentAmount.setText("");
    }//GEN-LAST:event_paymentAmountMouseClicked

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if(table.getSelectedRow() != -1){
            String ID = table.getValueAt(table.getSelectedRow(), 0).toString();
            String date = table.getValueAt(table.getSelectedRow(), 5).toString();
            IV.editFile(ID, userID.getText(), unitID.getText(), fees.getText(), outstandingFees.getText(), date);
            JOptionPane.showMessageDialog(null,"Successfully Updated Invoice!");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     

        if(!userID.getText().equals("")){
            table.setModel(new DefaultTableModel());
            try {
                BufferedReader br = new BufferedReader(new FileReader("Invoices.txt"));
                String firstLine = br.readLine().trim();
                String[] columnsName = firstLine.split(":");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setColumnIdentifiers(columnsName);
                Object[] tableLines = br.lines().toArray();
                for (int i = 0; i < tableLines.length; i++) {
                    String line = tableLines[i].toString().trim();
                    String[] dataRow = line.split(":");
                    if(dataRow[1].equals(userID.getText())){
                        model.addRow(dataRow);
                        unitID.setText(dataRow[2]);
                        fees.setText(dataRow[3]);
                        outstandingFees.setText(dataRow[4]);
                    }
                }

            } catch (IOException e) {
                System.out.println("Incorrect File");
            }
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Account_Executive_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account_Executive_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account_Executive_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account_Executive_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account_Executive_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JButton addPaymentBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField fees;
    private javax.swing.JButton getInfoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JTextField outstandingFees;
    private javax.swing.JTextField paymentAmount;
    private javax.swing.JButton receiptBtn;
    private javax.swing.JTable table;
    private javax.swing.JTextField unitID;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables
}
