/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import PurchaseManager.PurchaseRequisitionFrame;
import PurchaseManager.ItemFrame;
import PurchaseManager.SupplierFrame;
import PurchaseManager.TableLoader;
import javax.swing.JOptionPane;


public class PurchaseOrderFrame extends javax.swing.JFrame {

    public PurchaseOrderFrame() {
        initComponents();
        setSize(1010, 750);
        
        PurchaseRequisition.refreshComboBox(cbxRequisitionID);
        
         // Set default selection to none
        cbxRequisitionID.setSelectedIndex(-1); // No item selected initially
        
        cbxRequisitionID.setEditable(true);
        
        txtPRDate.setEnabled(false);
        txtSupplierID.setEnabled(false);
        txtSupplierName.setEnabled(false);
        txtItemCode.setEnabled(false);
        txtItemName.setEnabled(false); 
        txtQuantity.setEnabled(false);  
        txtUnitPrice.setEnabled(false); 
        txtTotalPrice.setEnabled(false); 
        txtRequestedBy.setEnabled(false); 
        txtStatus.setEnabled(false);
        
        
        // Manage POs Tab
        txtRequisitionID.setEnabled(false);
        txtPODate.setEnabled(false);
        txtPOSupplierName.setEnabled(false);
        txtPOItemCode.setEnabled(false);
        txtPOItemName.setEnabled(false); 
        txtPOUnitPrice.setEnabled(false); 
        txtPOTotalPrice.setEnabled(false); 
        txtPOApprovedBy.setEnabled(false); 
        txtPOStatus.setEnabled(false);
        
        POComboBoxLoader readPOFile = new POComboBoxLoader();
        readPOFile.populatePOIDComboBox(cbxPO_ID);
        
        cbxNewSupplierID.removeAllItems(); 


    }
    


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnItems = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        btnPurchaserOrders = new javax.swing.JButton();
        btnRequisition = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnSignOut = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblCategory = new javax.swing.JLabel();
        lblRequisitionID = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        cbxRequisitionID = new javax.swing.JComboBox<>();
        lblPMID = new javax.swing.JLabel();
        txtApprovedBy = new javax.swing.JTextField();
        lblItemName = new javax.swing.JLabel();
        lblItemCode = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtSupplierName = new javax.swing.JTextField();
        lblSupplierName = new javax.swing.JLabel();
        lblSupplierID = new javax.swing.JLabel();
        txtRequestedBy = new javax.swing.JTextField();
        lblRequestedBy = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        lblTotalPrice = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        lblUnitPrice = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        txtSupplierID = new javax.swing.JTextField();
        txtPRDate = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPRTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnLoadAllData = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbxPO_ID = new javax.swing.JComboBox<>();
        lblRequisitionID1 = new javax.swing.JLabel();
        lblRequisitionID2 = new javax.swing.JLabel();
        lblPOStatus = new javax.swing.JLabel();
        txtPOApprovedBy = new javax.swing.JTextField();
        lblPMID1 = new javax.swing.JLabel();
        txtNewQuantity = new javax.swing.JTextField();
        txtPOUnitPrice = new javax.swing.JTextField();
        txtPOTotalPrice = new javax.swing.JTextField();
        txtPOItemCode = new javax.swing.JTextField();
        txtPOItemName = new javax.swing.JTextField();
        txtPODate = new javax.swing.JTextField();
        lblQuantity1 = new javax.swing.JLabel();
        lblUnitPrice1 = new javax.swing.JLabel();
        lblTotalPrice1 = new javax.swing.JLabel();
        lblItemCode1 = new javax.swing.JLabel();
        lblItemName1 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtRequisitionID = new javax.swing.JTextField();
        txtPOStatus = new javax.swing.JTextField();
        lblSupplierName1 = new javax.swing.JLabel();
        txtPOSupplierName = new javax.swing.JTextField();
        lblSupplierID1 = new javax.swing.JLabel();
        cbxNewSupplierID = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPOTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnLoadAllPOData = new javax.swing.JToggleButton();

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
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRequisition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPurchaserOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setPreferredSize(new java.awt.Dimension(119, 50));

        lblTitle.setText("Purchase Order");
        lblTitle.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
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

        lblUser.setText("User: LIM JUN NA (Purchase Manager)");
        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblRequisitionID.setText("REQUISITION ID: ");
        lblRequisitionID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        cbxRequisitionID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxRequisitionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRequisitionIDActionPerformed(evt);
            }
        });

        lblPMID.setText("Approved By:");
        lblPMID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtApprovedBy.setText("PM001");
        txtApprovedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApprovedByActionPerformed(evt);
            }
        });

        lblItemName.setText("Item Name:");
        lblItemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblItemCode.setText("Item Code:");
        lblItemCode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtItemCode.setPreferredSize(new java.awt.Dimension(64, 25));
        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });

        txtSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierNameActionPerformed(evt);
            }
        });

        lblSupplierName.setText("Supplier Name: ");
        lblSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblSupplierID.setText("Supplier ID:");
        lblSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtRequestedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestedByActionPerformed(evt);
            }
        });

        lblRequestedBy.setText("Requested By: ");
        lblRequestedBy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtTotalPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtTotalPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });

        lblTotalPrice.setText("Total Price:");
        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtUnitPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitPriceActionPerformed(evt);
            }
        });

        lblUnitPrice.setText("Unit Price:");
        lblUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtQuantity.setMinimumSize(new java.awt.Dimension(64, 25));
        txtQuantity.setPreferredSize(new java.awt.Dimension(64, 25));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        lblQuantity.setText("Quantity:");
        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblDate.setText("PR Created Date:");
        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });

        txtSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierIDActionPerformed(evt);
            }
        });

        txtPRDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPRDateActionPerformed(evt);
            }
        });

        lblStatus.setText("Status: ");
        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtStatus.setMinimumSize(new java.awt.Dimension(64, 25));
        txtStatus.setPreferredSize(new java.awt.Dimension(64, 25));
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPRDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblItemName)
                                        .addComponent(lblItemCode))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSupplierName)
                                        .addComponent(lblSupplierID))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblQuantity)
                                        .addGap(36, 36, 36)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(lblRequestedBy)
                                    .addGap(141, 141, 141)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(txtRequestedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(lblCategory)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(180, 180, 180))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblRequisitionID)
                        .addGap(18, 18, 18)
                        .addComponent(cbxRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPMID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApprovedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRequisitionID)
                            .addComponent(lblPMID)
                            .addComponent(txtApprovedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDate)
                                    .addComponent(txtPRDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSupplierID)
                                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSupplierName))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblItemName)
                                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblItemCode)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblQuantity)
                                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(99, 99, 99))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblUnitPrice)
                                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblStatus)
                                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblTotalPrice)
                                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblRequestedBy)
                                            .addComponent(txtRequestedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(lblCategory)))
                .addContainerGap(15, Short.MAX_VALUE))
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
        jScrollPane3.setViewportView(tblPRTable);

        jScrollPane4.setViewportView(jScrollPane3);

        jLabel13.setText("Purchase Requisition");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        btnLoadAllData.setText("Load All Data");
        btnLoadAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAllDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoadAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create POs", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbxPO_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPO_ID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPO_IDItemStateChanged(evt);
            }
        });
        cbxPO_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPO_IDActionPerformed(evt);
            }
        });

        lblRequisitionID1.setText("PURCHASE ORDER ID: ");
        lblRequisitionID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblRequisitionID2.setText("REQUISITION ID: ");
        lblRequisitionID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblPOStatus.setText("Status: ");
        lblPOStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtPOApprovedBy.setMinimumSize(new java.awt.Dimension(64, 24));
        txtPOApprovedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOApprovedByActionPerformed(evt);
            }
        });

        lblPMID1.setText("Approved By:");
        lblPMID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtNewQuantity.setMinimumSize(new java.awt.Dimension(64, 25));
        txtNewQuantity.setPreferredSize(new java.awt.Dimension(64, 25));
        txtNewQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewQuantityActionPerformed(evt);
            }
        });
        txtNewQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewQuantityKeyReleased(evt);
            }
        });

        txtPOUnitPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtPOUnitPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtPOUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOUnitPriceActionPerformed(evt);
            }
        });

        txtPOTotalPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtPOTotalPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtPOTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOTotalPriceActionPerformed(evt);
            }
        });

        txtPOItemCode.setPreferredSize(new java.awt.Dimension(64, 25));
        txtPOItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOItemCodeActionPerformed(evt);
            }
        });

        txtPOItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOItemNameActionPerformed(evt);
            }
        });

        txtPODate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPODateActionPerformed(evt);
            }
        });

        lblQuantity1.setText("New Quantity:");
        lblQuantity1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblUnitPrice1.setText("Unit Price:");
        lblUnitPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblTotalPrice1.setText("Total Price:");
        lblTotalPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblItemCode1.setText("Item Code:");
        lblItemCode1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblItemName1.setText("Item Name:");
        lblItemName1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblDate1.setText("PO Created Date:");
        lblDate1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtRequisitionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequisitionIDActionPerformed(evt);
            }
        });

        txtPOStatus.setMinimumSize(new java.awt.Dimension(64, 25));
        txtPOStatus.setPreferredSize(new java.awt.Dimension(64, 25));

        lblSupplierName1.setText("Supplier Name: ");
        lblSupplierName1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtPOSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOSupplierNameActionPerformed(evt);
            }
        });

        lblSupplierID1.setText("New Supplier ID:");
        lblSupplierID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        cbxNewSupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNewSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNewSupplierIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblRequisitionID2)
                        .addGap(18, 18, 18)
                        .addComponent(txtRequisitionID))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItemName1)
                                    .addComponent(lblItemCode1))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPOItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPOItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUnitPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 47, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPOTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtPOUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPODate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblSupplierName1)
                                .addGap(5, 5, 5)
                                .addComponent(txtPOSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPMID1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPOStatus))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPOStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtPOApprovedBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblSupplierID1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxNewSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblRequisitionID1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPO_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPO_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRequisitionID1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRequisitionID2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDate1)
                        .addComponent(txtPODate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName1)
                    .addComponent(txtPOItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity1)
                    .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPOApprovedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPMID1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPOItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItemCode1))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUnitPrice1)
                            .addComponent(txtPOUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalPrice1)
                            .addComponent(txtPOTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupplierID1)
                            .addComponent(cbxNewSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPOStatus)
                            .addComponent(txtPOStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupplierName1)
                            .addComponent(txtPOSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPOTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PO_ID", "REQ_ID", "Date", "Supplier_ID", "Supplier Name", "Item_Code", "Item_Name", "Quantity", "Unit_Price", "Total_Price", "Approved_By", "Status"
            }
        ));
        jScrollPane5.setViewportView(tblPOTable);

        jScrollPane1.setViewportView(jScrollPane5);

        jLabel14.setText("Purchase Order");
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        btnLoadAllPOData.setText("Load All Data");
        btnLoadAllPOData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAllPODataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoadAllPOData, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadAllPOData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage POs", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                            .addComponent(jTabbedPane1))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1))
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

    private void btnRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequisitionActionPerformed
        PurchaseRequisitionFrame PR = new PurchaseRequisitionFrame();
        PR.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnRequisitionActionPerformed

    private void btnLoadAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAllDataActionPerformed
        TableLoader viewPR = new TableLoader(tblPRTable); 
        viewPR.loadPurchaseRequisitionData();
    }//GEN-LAST:event_btnLoadAllDataActionPerformed

    
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignOutActionPerformed

    
    private void btnPurchaserOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaserOrdersActionPerformed
        PurchaseOrderFrame PO = new PurchaseOrderFrame();
        PO.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnPurchaserOrdersActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed

    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceActionPerformed

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void txtRequestedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestedByActionPerformed

    private void txtSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierNameActionPerformed

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void txtApprovedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApprovedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApprovedByActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        String selectedREQID  = cbxRequisitionID.getEditor().getItem().toString();
        String approvedBy = txtApprovedBy.getText();

        if (selectedREQID .isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a Requisition ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PurchaseRequisition requisition = new PurchaseRequisition();
        requisition.loadData(selectedREQID );
    
        if (requisition.validate()) {
            requisition.approve(approvedBy);

            // Automatically refresh the table
            PurchaseRequisition.refreshPRTable(tblPRTable);
            PurchaseRequisition.refreshComboBox(cbxRequisitionID);
            JOptionPane.showMessageDialog(this, "Requisition approved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid requisition data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        cbxRequisitionID.setSelectedIndex(-1);  // Clears the ComboBox selection
        
        txtPRDate.setText("");
        txtSupplierID.setText("");
        txtSupplierName.setText("");
        txtItemCode.setText("");
        txtItemName.setText("");
        txtQuantity.setText("");
        txtUnitPrice.setText("");
        txtTotalPrice.setText("");
        txtRequestedBy.setText("");
        txtStatus.setText("");
        txtApprovedBy.setText("PM001");  
        
        POComboBoxLoader readPOFile = new POComboBoxLoader();
        readPOFile.populatePOIDComboBox(cbxPO_ID);
        

    }//GEN-LAST:event_btnApproveActionPerformed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void txtSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierIDActionPerformed

    private void txtPRDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPRDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPRDateActionPerformed

    private void cbxRequisitionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRequisitionIDActionPerformed
        try {
        String selectedREQID = (String) cbxRequisitionID.getSelectedItem();

        // Handle empty or null selections
        if (selectedREQID == null || selectedREQID.trim().isEmpty()) {
            return; // Do nothing and exit
        }

        // Load requisition data and fill the details
        PurchaseRequisition requisition = new PurchaseRequisition();
        requisition.loadData(selectedREQID);

        if (requisition.validate()) {
            // Populate text fields with requisition details
            txtPRDate.setText(requisition.getDate());
            txtSupplierID.setText(requisition.getSupplierID());
            txtSupplierName.setText(requisition.getSupplierName());
            txtItemCode.setText(requisition.getItemCode());
            txtItemName.setText(requisition.getItemName());
            txtQuantity.setText(String.valueOf(requisition.getQuantity()));
            txtUnitPrice.setText(String.valueOf(requisition.getUnitPrice()));
            txtTotalPrice.setText(String.valueOf(requisition.getTotalPrice()));
            txtRequestedBy.setText(requisition.getRequestedBy());
            txtStatus.setText(requisition.getStatus());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid requisition data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace(); // Print the stack trace for debugging
        JOptionPane.showMessageDialog(this, "An error occurred while loading the requisition data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_cbxRequisitionIDActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void cbxPO_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPO_IDActionPerformed
        String selectedPOID = (String) cbxPO_ID.getSelectedItem();
        
        if (selectedPOID == null || selectedPOID.trim().isEmpty()) {
            return; // Do nothing if no PO_ID is selected
        }

        PurchaseOrder po = new PurchaseOrder();
        po.loadData(selectedPOID);
        
        // Populate fields with PO details
        txtRequisitionID.setText(po.getREQ_ID());
        txtPODate.setText(po.getDate());
        txtPOSupplierName.setText(po.getSupplierName());
        txtPOItemCode.setText(po.getItemCode());
        txtPOItemName.setText(po.getItemName());
        txtNewQuantity.setText(String.valueOf(po.getQuantity()));
        txtPOUnitPrice.setText(String.valueOf(po.getUnitPrice()));
        txtPOTotalPrice.setText(String.valueOf(po.getTotalPrice()));
        txtPOApprovedBy.setText(po.getApprovedBy());
        txtPOStatus.setText(po.getStatus());
        
        POComboBoxLoader SupplierLoader = new POComboBoxLoader();
        SupplierLoader.loadSuppliers(po.getItemCode(), cbxNewSupplierID);
        
        cbxNewSupplierID.setSelectedItem(po.getSupplierID());
    }//GEN-LAST:event_cbxPO_IDActionPerformed

    private void txtPOApprovedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOApprovedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOApprovedByActionPerformed

    private void txtNewQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewQuantityActionPerformed
    
    }//GEN-LAST:event_txtNewQuantityActionPerformed

    private void txtPOUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOUnitPriceActionPerformed

    private void txtPOTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOTotalPriceActionPerformed

    private void txtPOItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOItemCodeActionPerformed

    private void txtPOItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOItemNameActionPerformed

    private void txtPOSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOSupplierNameActionPerformed

    private void txtPODateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPODateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPODateActionPerformed

    private void btnLoadAllPODataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAllPODataActionPerformed
        TableLoader viewPO = new TableLoader(tblPOTable);
        viewPO.loadPurchaseOrderData();
    }//GEN-LAST:event_btnLoadAllPODataActionPerformed

    private void txtRequisitionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequisitionIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequisitionIDActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String poID = cbxPO_ID.getSelectedItem().toString();
        String newSupplierID = (String) cbxNewSupplierID.getSelectedItem();
        String newQuantity = txtNewQuantity.getText();
        
        if (poID == null || poID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a PO_ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PurchaseOrder po = new PurchaseOrder();
        boolean success = po.saveChanges(poID, newSupplierID, newQuantity);
        PurchaseOrder.refreshPOTable(tblPOTable);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Purchase order updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error updating purchase order.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNewQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewQuantityKeyReleased
        POComboBoxLoader readFile = new POComboBoxLoader();
        readFile.calculateTotalPrice(txtNewQuantity, txtPOUnitPrice, txtPOTotalPrice);
    }//GEN-LAST:event_txtNewQuantityKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String PO_ID = cbxPO_ID.getSelectedItem().toString();
        
        if (PO_ID == null || PO_ID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a PO_ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PurchaseOrder po = new PurchaseOrder();
        boolean deleted = po.deletePOData(PO_ID, tblPOTable);
        PurchaseOrder.refreshPOTable(tblPOTable);
        
        if (deleted) {
            JOptionPane.showMessageDialog(this, "Purchase order deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error updating purchase order.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbxNewSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNewSupplierIDActionPerformed
        String selectedSupplierID = (String) cbxNewSupplierID.getSelectedItem();
        POComboBoxLoader supplierLoader = new POComboBoxLoader();
        supplierLoader.updateSupplierName(selectedSupplierID, txtPOSupplierName);
        
    }//GEN-LAST:event_cbxNewSupplierIDActionPerformed

    private void cbxPO_IDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPO_IDItemStateChanged

    }//GEN-LAST:event_cbxPO_IDItemStateChanged

    

    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnItems;
    private javax.swing.JToggleButton btnLoadAllData;
    private javax.swing.JToggleButton btnLoadAllPOData;
    private javax.swing.JButton btnPurchaserOrders;
    private javax.swing.JButton btnRequisition;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JComboBox<String> cbxNewSupplierID;
    private javax.swing.JComboBox<String> cbxPO_ID;
    private javax.swing.JComboBox<String> cbxRequisitionID;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblItemCode;
    private javax.swing.JLabel lblItemCode1;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblItemName1;
    private javax.swing.JLabel lblPMID;
    private javax.swing.JLabel lblPMID1;
    private javax.swing.JLabel lblPOStatus;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantity1;
    private javax.swing.JLabel lblRequestedBy;
    private javax.swing.JLabel lblRequisitionID;
    private javax.swing.JLabel lblRequisitionID1;
    private javax.swing.JLabel lblRequisitionID2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSupplierID;
    private javax.swing.JLabel lblSupplierID1;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JLabel lblSupplierName1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTotalPrice1;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JLabel lblUnitPrice1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblPOTable;
    private javax.swing.JTable tblPRTable;
    private javax.swing.JTextField txtApprovedBy;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtPOApprovedBy;
    private javax.swing.JTextField txtPODate;
    private javax.swing.JTextField txtPOItemCode;
    private javax.swing.JTextField txtPOItemName;
    private javax.swing.JTextField txtPOStatus;
    private javax.swing.JTextField txtPOSupplierName;
    private javax.swing.JTextField txtPOTotalPrice;
    private javax.swing.JTextField txtPOUnitPrice;
    private javax.swing.JTextField txtPRDate;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtRequestedBy;
    private javax.swing.JTextField txtRequisitionID;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
