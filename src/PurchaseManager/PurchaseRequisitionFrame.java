/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PurchaseManager;


import PurchaseManager.ItemFrame;
import PurchaseManager.SupplierFrame;
import PurchaseManager.TableLoader;
import javax.swing.JTable;



public class PurchaseRequisitionFrame extends javax.swing.JFrame {
   
    public PurchaseRequisitionFrame() {
        initComponents();
        setSize(1010, 750);
    }
    
    
    public JTable getTblPRTable() {
        return tblPRTable;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkViewAllCostPrice = new javax.swing.JCheckBox();
        lblCostPrice = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMinCostPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaxCostPrice = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnItems = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        btnPurchaserOrders = new javax.swing.JButton();
        btnRequisition = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPRTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnSignOut = new javax.swing.JButton();
        btnFilterPR = new javax.swing.JButton();
        btnLoadAllData = new javax.swing.JToggleButton();
        btnCreatePR = new javax.swing.JButton();

        chkViewAllCostPrice.setText("View All Cost Price");
        chkViewAllCostPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewAllCostPriceActionPerformed(evt);
            }
        });

        lblCostPrice.setText("Cost Price:");
        lblCostPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setText("Min:");
        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N

        txtMinCostPrice.setText("0");
        txtMinCostPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMinCostPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtMinCostPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinCostPriceActionPerformed(evt);
            }
        });

        jLabel6.setText("Max:");
        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N

        txtMaxCostPrice.setText("40.00");
        txtMaxCostPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMaxCostPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtMaxCostPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxCostPriceActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnItems.setText("Items");
        btnItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemsActionPerformed(evt);
            }
        });

        btnSuppliers.setText("Suppliers");
        btnSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppliersActionPerformed(evt);
            }
        });

        btnPurchaserOrders.setText("Purchaser Orders");
        btnPurchaserOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaserOrdersActionPerformed(evt);
            }
        });

        btnRequisition.setText("Requisition");
        btnRequisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequisitionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPurchaserOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRequisition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnItems, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRequisition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPurchaserOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPRTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Requisition ID", "Date", "Supplier ID", "Supplier Name", "Item Code", "Item Name", "Quantity", "Unit Price", "Total Price", "Requested By", "Status"
            }
        ));
        tblPRTable.setMinimumSize(new java.awt.Dimension(105, 100));
        jScrollPane1.setViewportView(tblPRTable);

        jScrollPane3.setViewportView(jScrollPane1);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setPreferredSize(new java.awt.Dimension(119, 50));

        lblTitle.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        lblTitle.setText("Purchase Requisition");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(lblTitle))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(4, 40));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUser.setText("User: LIM JUN NA (Purchase Manager)");

        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnFilterPR.setText("Filter");
        btnFilterPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterPRActionPerformed(evt);
            }
        });

        btnLoadAllData.setText("Load All Data");
        btnLoadAllData.setPreferredSize(new java.awt.Dimension(110, 23));
        btnLoadAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAllDataActionPerformed(evt);
            }
        });

        btnCreatePR.setText("CREATE PR");
        btnCreatePR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnCreatePR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnFilterPR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLoadAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(56, 56, 56)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFilterPR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoadAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreatePR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemsActionPerformed
        ItemFrame IF = new ItemFrame();
        IF.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnItemsActionPerformed

    private void btnSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppliersActionPerformed
        SupplierFrame SF = new SupplierFrame();
        SF.setVisible(true);
        this.hide(); 
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnPurchaserOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaserOrdersActionPerformed
        PurchaseOrderFrame PO = new PurchaseOrderFrame();
        PO.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnPurchaserOrdersActionPerformed

    private void btnRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequisitionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRequisitionActionPerformed

    private void btnFilterPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterPRActionPerformed
        FilterPR_jDialog filterPR = new FilterPR_jDialog(null, true, tblPRTable);
        filterPR.setLocationRelativeTo(this); 
        filterPR.setVisible(true);
        
    }//GEN-LAST:event_btnFilterPRActionPerformed

    private void btnLoadAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAllDataActionPerformed

        TableLoader viewPR = new TableLoader(tblPRTable); // Pass the JTable 
        viewPR.loadPurchaseRequisitionData(); // Call the method to load data from the text file
    }//GEN-LAST:event_btnLoadAllDataActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void chkViewAllCostPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewAllCostPriceActionPerformed
        if (chkViewAllCostPrice.isSelected()) {
            txtMinCostPrice.setEnabled(false);
            txtMaxCostPrice.setEnabled(false);
        } else {
            txtMinCostPrice.setEnabled(true);
            txtMaxCostPrice.setEnabled(true);
        }
    }//GEN-LAST:event_chkViewAllCostPriceActionPerformed

    private void txtMinCostPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinCostPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinCostPriceActionPerformed

    private void txtMaxCostPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxCostPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxCostPriceActionPerformed

    private void btnCreatePRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePRActionPerformed
        CreatePR_jDialog createPR = new CreatePR_jDialog(this, true);
        createPR.setLocationRelativeTo(this);  
        createPR.setVisible(true);

    }//GEN-LAST:event_btnCreatePRActionPerformed



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
            java.util.logging.Logger.getLogger(PurchaseRequisitionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseRequisitionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseRequisitionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseRequisitionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseRequisitionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePR;
    private javax.swing.JButton btnFilterPR;
    private javax.swing.JButton btnItems;
    private javax.swing.JToggleButton btnLoadAllData;
    private javax.swing.JButton btnPurchaserOrders;
    private javax.swing.JButton btnRequisition;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JCheckBox chkViewAllCostPrice;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCostPrice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblPRTable;
    private javax.swing.JTextField txtMaxCostPrice;
    private javax.swing.JTextField txtMinCostPrice;
    // End of variables declaration//GEN-END:variables
}
