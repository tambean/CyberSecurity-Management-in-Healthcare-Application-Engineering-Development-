/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ConfigurationMangerRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.InformationSecurityOraganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DataAnalysisWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anike
 */
public class ViewDirectoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    public ViewDirectoryJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        tblemp.getTableHeader().setForeground(new Color(0,153,255));
        populateOrganizationComboBox();
    }
    
    private void populateTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) tblemp.getModel();
        String tmp = null;
        model.setRowCount(0);
        for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
            Object[] row = new Object[4];
            row[0] = e;
            row[1] = e.getId();
            row[2] = e.getStatus();
            for(UserAccount u : organization.getUserAccountDirectory().getUserAccountList()){
                if(u.getEmployee().getName().matches(e.getName())){
                    tmp = u.getMacAddress();
                }
            }
            row[3] = tmp == null ? null : tmp;            
            model.addRow(row);
        }
    }
    
    public void populateOrganizationComboBox(){
        
        organizationJComboBox.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (!(organization instanceof InformationSecurityOraganization)) {
                organizationJComboBox.addItem(organization);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblemp = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnViewStatus = new javax.swing.JButton();
        btnViewAuthentication = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        backJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton1.setForeground(new java.awt.Color(0, 204, 255));
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Business/Images/back.jpg"))); // NOI18N
        backJButton1.setText("Back");
        backJButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("Employee Table");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Employee Status Table");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Business/utils/user_login_man_profile_account-128.png"))); // NOI18N

        jLabel9.setText("You are currently logged in.");

        tblemp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblemp.setForeground(new java.awt.Color(0, 204, 255));
        tblemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Name", "Employee ID", "Active/Inactive", "MAC Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblemp);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Select Organization");

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Delete Employee");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnViewStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewStatus.setForeground(new java.awt.Color(0, 204, 255));
        btnViewStatus.setText("View Status file");
        btnViewStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStatusActionPerformed(evt);
            }
        });

        btnViewAuthentication.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewAuthentication.setForeground(new java.awt.Color(0, 204, 255));
        btnViewAuthentication.setText("View Authentication file");
        btnViewAuthentication.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewAuthentication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAuthenticationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel5))
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(btnViewStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnViewAuthentication, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewAuthentication, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(backJButton1)
                        .addGap(68, 68, 68))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
         int selectedRow = tblemp.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row from table");
            return;
        }

        Employee e = (Employee) tblemp.getValueAt(selectedRow, 0);
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            organization.getEmployeeDirectory().deleteEmployee(e);
            if(e.getStatus().matches("Inactive")){
                String workingdirectory = System.getProperty("user.dir");
                workingdirectory += "\\emp_Status\\";
                workingdirectory += enterprise.getName();
                workingdirectory += "EmpStatus.txt";
                File f = new File(workingdirectory);
                if (f.exists() && !f.isDirectory()) {
                    f.delete();
                }
            }
            populateTable(organization);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnViewStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStatusActionPerformed
        // TODO add your handling code here:

        String workingdirectory = System.getProperty("user.dir");
        workingdirectory += "\\emp_Status\\";
        workingdirectory += enterprise.getName();
        workingdirectory += "EmpStatus.txt";
        Runtime rs = Runtime.getRuntime();
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", workingdirectory);

        File f = new File(workingdirectory);
        if (f.exists() && !f.isDirectory()) {
            try {
                pb.start();
            } catch (IOException e) {
   
            }
        }else{
            JOptionPane.showMessageDialog(null,"Status File Absent");
        }
       
    }//GEN-LAST:event_btnViewStatusActionPerformed

    private void btnViewAuthenticationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAuthenticationActionPerformed
        // TODO add your handling code here:
        String workingdirectory = System.getProperty("user.dir");
        workingdirectory += "\\authentication\\";
        workingdirectory += enterprise.getName();
        workingdirectory += "authentication.txt";
        Runtime rs = Runtime.getRuntime();
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", workingdirectory);

        File f = new File(workingdirectory);
        if (f.exists() && !f.isDirectory()) {
            try {
                pb.start();
            } catch (IOException e) {
                //System.out.println(e);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Authentication File Absent");
        }
        
        
    }//GEN-LAST:event_btnViewAuthenticationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton btnViewAuthentication;
    private javax.swing.JButton btnViewStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable tblemp;
    // End of variables declaration//GEN-END:variables
}
