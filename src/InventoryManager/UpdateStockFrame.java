/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InventoryManager;

import Main.Config;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UpdateStockFrame extends javax.swing.JFrame {

    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<UpdateStock> stockList = new ArrayList<>();
    private static FileManager<Item> itemManager = new FileManager<>(Config.getInventoryPath());
    private static FileManager<UpdateStock> stockManager = new FileManager<>(Config.getAddStockPath());
    
    public UpdateStockFrame() {

        initComponents();
        setSize(900, 700);
        lblNoMatchMsg.setVisible(false);
        loadStockTable();    
        
        ComboBoxDataLoader readFile = new ComboBoxDataLoader();
        
        // Call the fillComboBox method to populate cbxItemName
        readFile.fillPurchaseOrderComboBox(cbxPurchaseOrder); 
        jPanelUpdateStock.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnSignOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnItems = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        btnSuppliedItems = new javax.swing.JButton();
        btnUpdateStock = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollBar1 = new javax.swing.JScrollBar();
        lblNoMatchMsg = new javax.swing.JLabel();
        jPanelUpdateStock = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblItemCode2 = new javax.swing.JLabel();
        lblSupplierID2 = new javax.swing.JLabel();
        btnConfirmUpdateStock = new javax.swing.JButton();
        lblCostPrice4 = new javax.swing.JLabel();
        txtUpdateStockQuantity = new javax.swing.JTextField();
        cbxPurchaseOrder = new javax.swing.JComboBox<>();
        txtUpdateStockItemCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUpdateStock = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(990, 535));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(4, 40));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUser.setText("User: Cheah Thong Yau (Inventory Manager)");

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

        btnSuppliedItems.setText("Supplied Items");
        btnSuppliedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppliedItemsActionPerformed(evt);
            }
        });

        btnUpdateStock.setText("Update Stock");
        btnUpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuppliedItems, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnItems, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuppliedItems, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setPreferredSize(new java.awt.Dimension(119, 50));

        lblTitle.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 24)); // NOI18N
        lblTitle.setText("Update Stock Levels");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addContainerGap())
        );

        lblNoMatchMsg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNoMatchMsg.setForeground(new java.awt.Color(255, 0, 0));
        lblNoMatchMsg.setText("No Orders Pending");

        jPanelUpdateStock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Update Stock Level");

        lblItemCode2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblItemCode2.setText("Item Code:");

        lblSupplierID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSupplierID2.setText("Purchase Order: ");

        btnConfirmUpdateStock.setText("Update Stock");
        btnConfirmUpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmUpdateStockActionPerformed(evt);
            }
        });

        lblCostPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostPrice4.setText("Quantity:");

        txtUpdateStockQuantity.setText("0");
        txtUpdateStockQuantity.setMinimumSize(new java.awt.Dimension(64, 25));
        txtUpdateStockQuantity.setPreferredSize(new java.awt.Dimension(64, 25));
        txtUpdateStockQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateStockQuantityActionPerformed(evt);
            }
        });

        cbxPurchaseOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPurchaseOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPurchaseOrderActionPerformed(evt);
            }
        });

        txtUpdateStockItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateStockItemCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdateStockLayout = new javax.swing.GroupLayout(jPanelUpdateStock);
        jPanelUpdateStock.setLayout(jPanelUpdateStockLayout);
        jPanelUpdateStockLayout.setHorizontalGroup(
            jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateStockLayout.createSequentialGroup()
                .addGroup(jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUpdateStockLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9))
                    .addGroup(jPanelUpdateStockLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCostPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItemCode2)
                            .addComponent(lblSupplierID2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxPurchaseOrder, 0, 123, Short.MAX_VALUE)
                            .addComponent(txtUpdateStockQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txtUpdateStockItemCode))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpdateStockLayout.createSequentialGroup()
                .addGap(0, 102, Short.MAX_VALUE)
                .addComponent(btnConfirmUpdateStock)
                .addGap(91, 91, 91))
        );
        jPanelUpdateStockLayout.setVerticalGroup(
            jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateStockLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(33, 33, 33)
                .addGroup(jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierID2)
                    .addComponent(cbxPurchaseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItemCode2)
                    .addComponent(txtUpdateStockItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelUpdateStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUpdateStockQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCostPrice4))
                .addGap(43, 43, 43)
                .addComponent(btnConfirmUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblUpdateStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Purchase Order", "Item ID", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tblUpdateStock);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNoMatchMsg)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNoMatchMsg)
                                .addGap(0, 89, Short.MAX_VALUE))
                            .addComponent(jPanelUpdateStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        getContentPane().add(jPanel3, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppliersActionPerformed
        SupplierFrame it = new SupplierFrame();
        it.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemsActionPerformed
        ItemsFrame it = new ItemsFrame();
        it.setVisible(true);
        this.hide();
        
    }//GEN-LAST:event_btnItemsActionPerformed

    private void btnSuppliedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppliedItemsActionPerformed
        SuppliedItemsFrame it = new SuppliedItemsFrame();
        it.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnSuppliedItemsActionPerformed

    private void cbxPurchaseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPurchaseOrderActionPerformed
        String selectedOrder = (String) cbxPurchaseOrder.getSelectedItem();

        UpdateStock stock = UpdateStock.findPurchaseOrder(stockList, selectedOrder);
        if (stock != null) {
            // Autofill the text fields with the supplier data
            txtUpdateStockItemCode.setText(stock.getItemCode());
            txtUpdateStockQuantity.setText(String.valueOf(stock.getQuantity()));
        }
        
        txtUpdateStockItemCode.setEnabled(false);
        txtUpdateStockQuantity.setEnabled(false);
    }//GEN-LAST:event_cbxPurchaseOrderActionPerformed

    private void txtUpdateStockQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateStockQuantityActionPerformed


    }//GEN-LAST:event_txtUpdateStockQuantityActionPerformed

    private void btnConfirmUpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmUpdateStockActionPerformed
        String purchaseOrder = (String) cbxPurchaseOrder.getSelectedItem();
        String itemCode = txtUpdateStockItemCode.getText().trim();
        int quantity = Integer.parseInt(txtUpdateStockQuantity.getText().trim());

        itemList.clear();
        itemManager.read(itemList, Item.class);
        stockList.clear();
        stockManager.read(stockList, UpdateStock.class);

        // Validation checks
        if(purchaseOrder.equals("NONE")){
            JOptionPane.showMessageDialog(this, "Select an order to fulfill.");
            return;
        }
 
        UpdateStock.updateStockQuantity(itemList,itemCode,quantity);
        UpdateStock.deleteOrder(stockList, purchaseOrder);

        loadStockTable();
        JOptionPane.showMessageDialog(this, "Stock Levels updated successfully!");

    }//GEN-LAST:event_btnConfirmUpdateStockActionPerformed

    private void btnUpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateStockActionPerformed

    private void txtUpdateStockItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateStockItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateStockItemCodeActionPerformed


    private void loadStockTable(){
        stockList.clear();

        stockManager.read(stockList, UpdateStock.class);
        // Add items to the JTable
        DefaultTableModel model = (DefaultTableModel) tblUpdateStock.getModel();
        model.setRowCount(0);  // Clear existing rows

        for (UpdateStock order : stockList) {
            model.addRow(new Object[]{
                order.getPurchaseOrder(), 
                order.getItemCode(), 
                order.getQuantity()
            });
        }

        // Optionally, handle case when no items are found
        if (stockList.isEmpty()) {
            lblNoMatchMsg.setVisible(true); // Show no items found message
        } else {
            lblNoMatchMsg.setVisible(false); // Hide the message
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
            java.util.logging.Logger.getLogger(ItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStockFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmUpdateStock;
    private javax.swing.JButton btnItems;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnSuppliedItems;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JButton btnUpdateStock;
    private javax.swing.JComboBox<String> cbxPurchaseOrder;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelUpdateStock;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCostPrice4;
    private javax.swing.JLabel lblItemCode2;
    private javax.swing.JLabel lblNoMatchMsg;
    private javax.swing.JLabel lblSupplierID2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblUpdateStock;
    private javax.swing.JTextField txtUpdateStockItemCode;
    private javax.swing.JTextField txtUpdateStockQuantity;
    // End of variables declaration//GEN-END:variables
}
