/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import PurchaseManager.BaseRequisition;
import PurchaseManager.ComboBoxLoader;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FilterPR_jDialog extends javax.swing.JDialog {

    private final JTable tblPRTable;
    

    public FilterPR_jDialog(Frame parent, boolean modal, JTable tblPRTable) {
        super(parent, modal);
        initComponents();        
        this.tblPRTable = tblPRTable;

        
        cbxItemName.addItem("ALL");
        cbxSupplierName.addItem("ALL");

        
        // Empty comboBox and add comparison operator 
        cbxComparisonOperator.removeAllItems();
        cbxComparisonOperator.addItem("ALL");
        cbxComparisonOperator.addItem("==");
        cbxComparisonOperator.addItem(">");
        cbxComparisonOperator.addItem(">=");
        cbxComparisonOperator.addItem("<");
        cbxComparisonOperator.addItem("<=");
        
        
        ComboBoxLoader readFile = new ComboBoxLoader();
        readFile.fillPRItemNameComboInPRFrame(cbxItemName); 
        readFile.fillPRSupplierNameComboInPRFrame(cbxSupplierName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        lblItemCode = new javax.swing.JLabel();
        lblItemName = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtQuantityValue = new javax.swing.JTextField();
        cbxComparisonOperator = new javax.swing.JComboBox<>();
        lblRequisitionID = new javax.swing.JLabel();
        txtRequisitionID = new javax.swing.JTextField();
        dpcDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        lblDate = new javax.swing.JLabel();
        chkViewAllRequistionID = new javax.swing.JCheckBox();
        lblUnitPrice = new javax.swing.JLabel();
        lblMinUnitPrice = new javax.swing.JLabel();
        txtMinUnitPrice = new javax.swing.JTextField();
        lblMaxUnitPrice = new javax.swing.JLabel();
        txtMaxUnitPrice = new javax.swing.JTextField();
        chkViewAllTotalPrice = new javax.swing.JCheckBox();
        lblTotalPrice = new javax.swing.JLabel();
        lblMinTotalPrice = new javax.swing.JLabel();
        txtMinTotalPrice = new javax.swing.JTextField();
        lblMaxTotalPrice = new javax.swing.JLabel();
        txtMaxTotalPrice = new javax.swing.JTextField();
        lblRequestedBy = new javax.swing.JLabel();
        txtRequestedBy = new javax.swing.JTextField();
        btnFilterPR = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbxItemName = new javax.swing.JComboBox<>();
        lblSupplierID = new javax.swing.JLabel();
        txtSupplierID = new javax.swing.JTextField();
        cbxSupplierName = new javax.swing.JComboBox<>();
        lblSupplierName = new javax.swing.JLabel();
        chkViewAllUnitPrice = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblItemCode.setText("Item Code:");
        lblItemCode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblItemName.setText("Item Name:");
        lblItemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblQuantity.setText("Quantity:");
        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtItemCode.setPreferredSize(new java.awt.Dimension(64, 25));
        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });

        txtQuantityValue.setText("0");
        txtQuantityValue.setMinimumSize(new java.awt.Dimension(64, 25));
        txtQuantityValue.setPreferredSize(new java.awt.Dimension(64, 25));
        txtQuantityValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityValueActionPerformed(evt);
            }
        });

        cbxComparisonOperator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxComparisonOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxComparisonOperatorActionPerformed(evt);
            }
        });

        lblRequisitionID.setText("REQUISITION ID: ");
        lblRequisitionID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtRequisitionID.setPreferredSize(new java.awt.Dimension(64, 25));
        txtRequisitionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequisitionIDActionPerformed(evt);
            }
        });

        lblDate.setText("Date:");
        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        chkViewAllRequistionID.setText("View All Requisition ID");
        chkViewAllRequistionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewAllRequistionIDActionPerformed(evt);
            }
        });

        lblUnitPrice.setText("Unit Price:");
        lblUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblMinUnitPrice.setText("Min:");
        lblMinUnitPrice.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N

        txtMinUnitPrice.setText("0");
        txtMinUnitPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMinUnitPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtMinUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinUnitPriceActionPerformed(evt);
            }
        });

        lblMaxUnitPrice.setText("Max:");
        lblMaxUnitPrice.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N

        txtMaxUnitPrice.setText("40.00");
        txtMaxUnitPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMaxUnitPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtMaxUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxUnitPriceActionPerformed(evt);
            }
        });

        chkViewAllTotalPrice.setText("View All Total Price");
        chkViewAllTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewAllTotalPriceActionPerformed(evt);
            }
        });

        lblTotalPrice.setText("Total Price:");
        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblMinTotalPrice.setText("Min:");
        lblMinTotalPrice.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N

        txtMinTotalPrice.setText("0");
        txtMinTotalPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMinTotalPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtMinTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinTotalPriceActionPerformed(evt);
            }
        });

        lblMaxTotalPrice.setText("Max:");
        lblMaxTotalPrice.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N

        txtMaxTotalPrice.setText("40.00");
        txtMaxTotalPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMaxTotalPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtMaxTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxTotalPriceActionPerformed(evt);
            }
        });

        lblRequestedBy.setText("Requested By: ");
        lblRequestedBy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtRequestedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestedByActionPerformed(evt);
            }
        });

        btnFilterPR.setText("Filter");
        btnFilterPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterPRActionPerformed(evt);
            }
        });

        jLabel12.setText("Enter Purchase Requisition Details");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        cbxItemName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxItemNameActionPerformed(evt);
            }
        });

        lblSupplierID.setText("Supplier ID:");
        lblSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtSupplierID.setPreferredSize(new java.awt.Dimension(64, 25));
        txtSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierIDActionPerformed(evt);
            }
        });

        cbxSupplierName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSupplierNameActionPerformed(evt);
            }
        });

        lblSupplierName.setText("Supplier Name: ");
        lblSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        chkViewAllUnitPrice.setText("View All Unit Price");
        chkViewAllUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewAllUnitPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItemName)
                                    .addComponent(lblItemCode))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSupplierName)
                                    .addComponent(lblSupplierID))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSupplierID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblRequisitionID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkViewAllRequistionID)
                                    .addComponent(txtRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblQuantity)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cbxComparisonOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantityValue, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblRequestedBy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRequestedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblMinTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMaxTotalPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaxTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkViewAllTotalPrice)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblMinUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMaxUnitPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaxUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dpcDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(lblUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(chkViewAllUnitPrice)))))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel12)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFilterPR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDate)
                        .addComponent(dpcDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRequisitionID)
                        .addComponent(txtRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkViewAllRequistionID)
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSupplierID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupplierName)
                            .addComponent(cbxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItemCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemName)
                            .addComponent(cbxItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUnitPrice)
                            .addComponent(chkViewAllUnitPrice))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMinUnitPrice)
                            .addComponent(txtMinUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaxUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaxUnitPrice))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalPrice)
                            .addComponent(chkViewAllTotalPrice))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMinTotalPrice)
                            .addComponent(txtMinTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaxTotalPrice)
                            .addComponent(txtMaxTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxComparisonOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantityValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRequestedBy)
                            .addComponent(txtRequestedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnFilterPR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void txtQuantityValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityValueActionPerformed

                
    }//GEN-LAST:event_txtQuantityValueActionPerformed

    private void cbxComparisonOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxComparisonOperatorActionPerformed
        // Get current selected operator
        String selectedOperator = (String) cbxComparisonOperator.getSelectedItem();

        if ("ALL".equals(selectedOperator)) {
            txtQuantityValue.setText("");
            txtQuantityValue.setEnabled(false);
        } else {
            txtQuantityValue.setEnabled(true);
        }
    }//GEN-LAST:event_cbxComparisonOperatorActionPerformed

    private void txtRequisitionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequisitionIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequisitionIDActionPerformed

    private void chkViewAllRequistionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewAllRequistionIDActionPerformed
        if (chkViewAllRequistionID.isSelected()) {
            txtRequisitionID.setEnabled(false);
            txtRequisitionID.setText("");
        } else {
            txtRequisitionID.setEnabled(true);
        }
    }//GEN-LAST:event_chkViewAllRequistionIDActionPerformed

    private void txtMinUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinUnitPriceActionPerformed

    private void txtMaxUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxUnitPriceActionPerformed

    private void chkViewAllTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewAllTotalPriceActionPerformed
        if (chkViewAllTotalPrice.isSelected()) {
            txtMinTotalPrice.setEnabled(false);
            txtMaxTotalPrice.setEnabled(false);
        } else {
            txtMinTotalPrice.setEnabled(true);
            txtMaxTotalPrice.setEnabled(true);
        }
    }//GEN-LAST:event_chkViewAllTotalPriceActionPerformed

    private void txtMinTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinTotalPriceActionPerformed

    private void txtMaxTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxTotalPriceActionPerformed

    private void btnFilterPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterPRActionPerformed
        String requisitionIDInput = txtRequisitionID.getText();
        String dateInput = dpcDatePicker.getText();
        String supplierIDInput = txtSupplierID.getText();
        String supplierNameInput = (String) cbxItemName.getSelectedItem();
        String itemCodeInput = txtItemCode.getText();
        String itemNameInput = (String) cbxItemName.getSelectedItem();
        String comparisonOperatorInput = (String) cbxComparisonOperator.getSelectedItem();
        String quantityValueInput = txtQuantityValue.getText();
        boolean viewAllUnitPrice = chkViewAllUnitPrice.isSelected();
        String minUnitPriceInput = txtMinUnitPrice.getText();
        String maxUnitPriceInput = txtMaxUnitPrice.getText();
        boolean viewAllTotalPrice = chkViewAllTotalPrice.isSelected();
        String minTotalPriceInput = txtMinTotalPrice.getText();
        String maxTotalPriceInput = txtMaxTotalPrice.getText();
        String requestedByInput = txtRequestedBy.getText();
        String statusInput = "Pending";

        FilterPR readFile = new FilterPR();

        List<BaseRequisition> matchingRows = readFile.filterPRTable(
            requisitionIDInput,
            dateInput,
            supplierIDInput,
            supplierNameInput,
            itemCodeInput,
            itemNameInput,
            comparisonOperatorInput,
            quantityValueInput,
            viewAllUnitPrice,
            minUnitPriceInput,
            maxUnitPriceInput,
            viewAllTotalPrice,
            minTotalPriceInput,
            maxTotalPriceInput,
            requestedByInput,
            statusInput
        );
        

        DefaultTableModel tableModel = (DefaultTableModel) tblPRTable.getModel();
        tableModel.setRowCount(0); // Clear existing rows

        if (!matchingRows.isEmpty()) {
            for (BaseRequisition requisition : matchingRows) {
                // Add each requisition as a new row in the table
                tableModel.addRow(new Object[]{
                    requisition.getREQ_ID(),            
                    requisition.getDate(),              
                    requisition.getSupplierID(),       
                    requisition.getSupplierName(),      
                    requisition.getItemCode(),         
                    requisition.getItemName(),          
                    requisition.getQuantity(),         
                    requisition.getUnitPrice(),      
                    requisition.getTotalPrice(),        
                    requisition.getRequestedBy(),    
                    requisition.getStatus()           
                });
            }

            
        } else {
            JOptionPane.showMessageDialog(this, "No Matching Item Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterPRActionPerformed

    private void cbxItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxItemNameActionPerformed

    private void txtSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierIDActionPerformed

    private void cbxSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSupplierNameActionPerformed

    private void chkViewAllUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewAllUnitPriceActionPerformed
        if (chkViewAllUnitPrice.isSelected()) {
            txtMinUnitPrice.setEnabled(false);
            txtMaxUnitPrice.setEnabled(false);
        } else {
            txtMinUnitPrice.setEnabled(true);
            txtMaxUnitPrice.setEnabled(true);
        }
    }//GEN-LAST:event_chkViewAllUnitPriceActionPerformed

    private void txtRequestedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestedByActionPerformed


    
    
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
            java.util.logging.Logger.getLogger(FilterPR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilterPR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilterPR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilterPR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PurchaseRequisitionFrame instance = new PurchaseRequisitionFrame();
                
                JTable tblPRTable = instance.getTblPRTable();
                              
                FilterPR_jDialog dialog = new FilterPR_jDialog(new javax.swing.JFrame(), true, tblPRTable);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilterPR;
    private javax.swing.JComboBox<String> cbxComparisonOperator;
    private javax.swing.JComboBox<String> cbxItemName;
    private javax.swing.JComboBox<String> cbxSupplierName;
    private javax.swing.JCheckBox chkViewAllRequistionID;
    private javax.swing.JCheckBox chkViewAllTotalPrice;
    private javax.swing.JCheckBox chkViewAllUnitPrice;
    private com.github.lgooddatepicker.components.DatePicker dpcDatePicker;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblItemCode;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblMaxTotalPrice;
    private javax.swing.JLabel lblMaxUnitPrice;
    private javax.swing.JLabel lblMinTotalPrice;
    private javax.swing.JLabel lblMinUnitPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRequestedBy;
    private javax.swing.JLabel lblRequisitionID;
    private javax.swing.JLabel lblSupplierID;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtMaxTotalPrice;
    private javax.swing.JTextField txtMaxUnitPrice;
    private javax.swing.JTextField txtMinTotalPrice;
    private javax.swing.JTextField txtMinUnitPrice;
    private javax.swing.JTextField txtQuantityValue;
    private javax.swing.JTextField txtRequestedBy;
    private javax.swing.JTextField txtRequisitionID;
    private javax.swing.JTextField txtSupplierID;
    // End of variables declaration//GEN-END:variables
}
