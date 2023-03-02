/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BuildingManager;




import cClasses.AccountExecutive;
import cClasses.BuildingExecutive;
import cClasses.BuildingManager;
import cClasses.Functions;
import cClasses.Session;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class BMUM extends javax.swing.JFrame {

    Session Session;
    ArrayList<BuildingExecutive> buildingexecutives = new ArrayList<>();
    ArrayList<AccountExecutive> ae = new ArrayList<>();
    /**
     * Creates new form Building_Manager_Sample
     */
    public BMUM(Session session) {
        initComponents();
//        AddRowToTable();
        buildingexecutives=new BuildingExecutive().Import();
        ae=new AccountExecutive().Import();
        this.Session = session;
        String id = session.getId();
        ArrayList<BuildingManager> buildingmanagers;
        buildingmanagers=new BuildingManager().Import();
        for(BuildingManager i:buildingmanagers){
            if(i.getId().equals(id)){
                Username.setText(i.getName());
            }
        }
        AccountExecutive.tabulateData(ae, Account_Table);
        BuildingExecutive.tabulateData(buildingexecutives, Building_Table);
    }
    
//        public void AddRowToTable()
//    {
//        DefaultTableModel AccTable = (DefaultTableModel)Account_Table.getModel();
//        AccTable.setRowCount(0);
//        ArrayList<String> accdata;
//        accdata = Functions.Read("AccountExecutive.txt");
//        for(String str:accdata){
//            String[] list = str.split(":");
//            String[] accDataRow = {list[0],list[1],list[2],list[5]};
//            AccTable.addRow(accDataRow);
//        }
//       
//        DefaultTableModel BuildTable = (DefaultTableModel)Building_Table.getModel();
//        BuildTable.setRowCount(0);
//        ArrayList<String> builddata;
//        builddata = Functions.Read("BuildingExecutive.txt");
//        for(String str:builddata){
//            String[] list = str.split(":");
//            String[] buildDataRow = {list[0],list[1],list[2],list[5]};
//            BuildTable.addRow(buildDataRow);
//        }
//        
//        
//    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        BuidlingExecutive = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        AccPanel = new javax.swing.JPanel();
        AccCreateBtn = new javax.swing.JButton();
        searchbox = new javax.swing.JTextField();
        AccUpdateBtn = new javax.swing.JButton();
        AccDeleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Account_Table = new javax.swing.JTable();
        BuildPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Building_Table = new javax.swing.JTable();
        BuildCreateBtn = new javax.swing.JButton();
        BuildUpdateBtn = new javax.swing.JButton();
        BuildDeleteBtn = new javax.swing.JButton();
        SearchBar2 = new javax.swing.JTextField();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(67, 63, 113));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Parkhill Residence");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(67, 63, 113));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(67, 63, 113));

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("View Reports");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(67, 63, 113));

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Operations and Budgets");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(67, 63, 113));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("    Logout");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(67, 63, 113));

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Team Structure");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(114, 126, 224));

        BuidlingExecutive.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        BuidlingExecutive.setForeground(new java.awt.Color(255, 255, 255));
        BuidlingExecutive.setText("Building Manager");

        Username.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(BuidlingExecutive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Username)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuidlingExecutive)
                    .addComponent(Username))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        TabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabbedPaneStateChanged(evt);
            }
        });
        TabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabbedPaneMouseClicked(evt);
            }
        });

        AccCreateBtn.setText("Create");
        AccCreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccCreateBtnActionPerformed(evt);
            }
        });

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        AccUpdateBtn.setText("Modify");
        AccUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccUpdateBtnActionPerformed(evt);
            }
        });

        AccDeleteBtn.setText("Delete");
        AccDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccDeleteBtnActionPerformed(evt);
            }
        });

        Account_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Contact Number"
            }
        )
        {
            public boolean isCellEditable(int row,int column){
                return false;
            }
        }
    );
    jScrollPane1.setViewportView(Account_Table);

    javax.swing.GroupLayout AccPanelLayout = new javax.swing.GroupLayout(AccPanel);
    AccPanel.setLayout(AccPanelLayout);
    AccPanelLayout.setHorizontalGroup(
        AccPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(AccPanelLayout.createSequentialGroup()
            .addGap(70, 70, 70)
            .addComponent(AccCreateBtn)
            .addGroup(AccPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AccPanelLayout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(AccUpdateBtn)
                    .addGap(123, 123, 123)
                    .addComponent(AccDeleteBtn))
                .addGroup(AccPanelLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(125, Short.MAX_VALUE))
        .addGroup(AccPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1)
            .addGap(15, 15, 15))
    );
    AccPanelLayout.setVerticalGroup(
        AccPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(AccPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(AccCreateBtn)
                .addComponent(AccUpdateBtn)
                .addComponent(AccDeleteBtn))
            .addContainerGap())
    );

    TabbedPane.addTab("Account Executives", AccPanel);

    Building_Table.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "ID", "Name", "Email", "Contact Number"
        }
    )
    {
        public boolean isCellEditable(int row,int column){
            return false;
        }
    }
    );
    jScrollPane2.setViewportView(Building_Table);

    BuildCreateBtn.setText("Create");
    BuildCreateBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BuildCreateBtnActionPerformed(evt);
        }
    });

    BuildUpdateBtn.setText("Modify");
    BuildUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BuildUpdateBtnActionPerformed(evt);
        }
    });

    BuildDeleteBtn.setText("Delete");
    BuildDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BuildDeleteBtnActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout BuildPanelLayout = new javax.swing.GroupLayout(BuildPanel);
    BuildPanel.setLayout(BuildPanelLayout);
    BuildPanelLayout.setHorizontalGroup(
        BuildPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(BuildPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2)
            .addContainerGap())
        .addGroup(BuildPanelLayout.createSequentialGroup()
            .addGroup(BuildPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BuildPanelLayout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(BuildCreateBtn)
                    .addGap(123, 123, 123)
                    .addComponent(BuildUpdateBtn)
                    .addGap(123, 123, 123)
                    .addComponent(BuildDeleteBtn))
                .addGroup(BuildPanelLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(SearchBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(83, 122, Short.MAX_VALUE))
    );
    BuildPanelLayout.setVerticalGroup(
        BuildPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(BuildPanelLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(SearchBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(BuildPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BuildCreateBtn)
                .addComponent(BuildUpdateBtn)
                .addComponent(BuildDeleteBtn))
            .addContainerGap())
    );

    TabbedPane.addTab("Building Executives", BuildPanel);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(TabbedPane)
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchboxActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void TabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabbedPaneMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_TabbedPaneMouseClicked
    
   
    private void AccUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccUpdateBtnActionPerformed
        // TODO add your handling code here:
        if(Account_Table.getSelectionModel().isSelectionEmpty()==false){
            int column = 0;
            int row = Account_Table.getSelectedRow();
            String Id = Account_Table.getModel().getValueAt(row, column).toString();
            BMUMUpdate_AE uf = new BMUMUpdate_AE(Session);
            uf.spamdata(Id);
            uf.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row.");
        }
            
            
    }//GEN-LAST:event_AccUpdateBtnActionPerformed

    private void TabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabbedPaneStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_TabbedPaneStateChanged

    private void BuildCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildCreateBtnActionPerformed
        // TODO add your handling code here:
        BMUMCreate_BE acf = new BMUMCreate_BE(Session);
        acf.setVisible(true);
        dispose();
    }//GEN-LAST:event_BuildCreateBtnActionPerformed

    private void AccCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccCreateBtnActionPerformed
        // TODO add your handling code here:
        
        BMUMCreate_AE cae = new BMUMCreate_AE(Session);
        cae.setVisible(true);
        dispose();
    }//GEN-LAST:event_AccCreateBtnActionPerformed

    private void AccDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccDeleteBtnActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = Account_Table.getSelectedRow();
        String Id = Account_Table.getModel().getValueAt(row, column).toString();
        AccountExecutive.Delete(ae, Id);
        BMUM bmum = new BMUM(Session);
        dispose();
        bmum.setVisible(true);

    }//GEN-LAST:event_AccDeleteBtnActionPerformed

    private void BuildUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildUpdateBtnActionPerformed
        // TODO add your handling code here:
//        if(Building_Table.getSelectionModel().isSelectionEmpty()==false){
//        int column = 0;
//        int row = Building_Table.getSelectedRow();
//        String Id = Building_Table.getModel().getValueAt(row, column).toString();
//        Build_Mod_Form uf = new Build_Mod_Form(logindetails);
//        uf.spamdata(Id);
//        uf.setVisible(true);
//        dispose();
//        }else{
//            JOptionPane.showMessageDialog(null, "Please select a row.");
//        }
    }//GEN-LAST:event_BuildUpdateBtnActionPerformed

    private void BuildDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildDeleteBtnActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = Building_Table.getSelectedRow();
        String Id = Building_Table.getModel().getValueAt(row, column).toString();
        buildingexecutives = new BuildingExecutive().Delete(buildingexecutives, Id);
        BMUM bmum = new BMUM(Session);
        dispose();
        bmum.setVisible(true);
    }//GEN-LAST:event_BuildDeleteBtnActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        
        String searchString = searchbox.getText();
        Functions.Search(searchString, Account_Table);
    }//GEN-LAST:event_searchboxKeyReleased

    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Building_Manager_Sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Building_Manager_Sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Building_Manager_Sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Building_Manager_Sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Building_Manager_Sample().setVisible(true);
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccCreateBtn;
    private javax.swing.JButton AccDeleteBtn;
    private javax.swing.JPanel AccPanel;
    private javax.swing.JButton AccUpdateBtn;
    private javax.swing.JTable Account_Table;
    private javax.swing.JLabel BuidlingExecutive;
    private javax.swing.JButton BuildCreateBtn;
    private javax.swing.JButton BuildDeleteBtn;
    private javax.swing.JPanel BuildPanel;
    private javax.swing.JButton BuildUpdateBtn;
    private javax.swing.JTable Building_Table;
    private javax.swing.JTextField SearchBar2;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JLabel Username;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField searchbox;
    // End of variables declaration//GEN-END:variables
}
