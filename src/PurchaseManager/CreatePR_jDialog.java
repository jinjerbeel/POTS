/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package PurchaseManager;

import PurchaseManager.Supplier;
import PurchaseManager.Item;
import PurchaseManager.ComboBoxLoader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class CreatePR_jDialog extends javax.swing.JDialog {

    public CreatePR_jDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Generate the next requisition ID
        GenerateRequisitionID generateID = new GenerateRequisitionID();
        String nextID = generateID.generateNextRequisitionID();
        txtRequisitionID.setText(nextID);
        txtRequisitionID.setEditable(false);
        
        txtCurrentDate.setEditable(false);
        txtSupplierName.setEditable(false);
        txtItemCode.setEditable(false);
        txtUnitPrice.setEditable(true);
        txtTotalPrice.setEditable(false);
        
        ComboBoxLoader readFile = new ComboBoxLoader();
        readFile.fillPRItemNameInCreatePR(cbxItemName);
        
        // Remove "ALL" option if it exists
        if(cbxItemName.getItemAt(0).equals("ALL")) {
            cbxItemName.removeItem("ALL");
        }
        
        
        txtRequestedBy.setText("PM001");
        txtRequestedBy.setEditable(false);
        
         // Set the current date
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // Date format of your choice
        txtCurrentDate.setText(currentDate);  // Set the current date as the text in the field
        txtCurrentDate.setEditable(false);  


    }
    
 
    
    private CreatePR createRequisition(int quantity, double unitPrice) {
        String requisitionID = txtRequisitionID.getText().trim();
        String currentDate = txtCurrentDate.getText().trim();
        String supplierID = (String) cbxSupplierID.getSelectedItem();
        String supplierName = txtSupplierName.getText().trim();
        String itemCode = txtItemCode.getText().trim();
        String itemName = (String) cbxItemName.getSelectedItem();
        String requestedBy = txtRequestedBy.getText().trim();
        String status = "Pending"; // Default status        
        
        if (itemName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an item.");
            return null;
        }

        if (supplierID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a supplier.");
            return null;
        }
          
        // Validate quantity and unit price
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
            return null;
        }

        if (unitPrice <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid unit price.");
            return null;
        }
        
        Item item = new Item(itemCode, itemName, unitPrice);
        Supplier supplier = new Supplier(supplierID, supplierName);
        
        
        double totalPrice = quantity * unitPrice;  // Calculate the total price based on quantity and unit price


        return new CreatePR(requisitionID, currentDate, item, supplier, 
                quantity, totalPrice, requestedBy, status);
    }
    
    
    // Method to update total price based on quantity and unit price
    private void updateTotalPrice() {
        try {
            int quantity = Integer.parseInt(txtQuantityValue.getText());
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            double totalPrice = quantity * unitPrice;
            txtTotalPrice.setText(String.format("%.2f", totalPrice));  // Display total price with 2 decimal places
        } catch (NumberFormatException e) {
            txtTotalPrice.setText("0.00");  // Default value in case of invalid input
        }
    }







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        lblItemCode = new javax.swing.JLabel();
        lblItemName = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        txtCurrentDate = new javax.swing.JTextField();
        txtQuantityValue = new javax.swing.JTextField();
        lblRequisitionID = new javax.swing.JLabel();
        txtRequisitionID = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        lblUnitPrice = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        lblTotalPrice = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        lblRequestedBy = new javax.swing.JLabel();
        txtRequestedBy = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnCreatePR = new javax.swing.JButton();
        cbxItemName = new javax.swing.JComboBox<>();
        lblSupplierID = new javax.swing.JLabel();
        lblSupplierName = new javax.swing.JLabel();
        cbxSupplierID = new javax.swing.JComboBox<>();
        txtSupplierName = new javax.swing.JTextField();
        txtItemCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblItemCode.setText("Item Code:");
        lblItemCode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblItemName.setText("Item Name:");
        lblItemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblQuantity.setText("Quantity:");
        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtCurrentDate.setPreferredSize(new java.awt.Dimension(64, 25));
        txtCurrentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentDateActionPerformed(evt);
            }
        });

        txtQuantityValue.setText("0");
        txtQuantityValue.setMinimumSize(new java.awt.Dimension(64, 25));
        txtQuantityValue.setPreferredSize(new java.awt.Dimension(64, 25));
        txtQuantityValue.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                txtQuantityValueComponentShown(evt);
            }
        });
        txtQuantityValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityValueActionPerformed(evt);
            }
        });
        txtQuantityValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityValueKeyReleased(evt);
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

        lblDate.setText("Current Date:");
        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblUnitPrice.setText("Unit Price:");
        lblUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtUnitPrice.setText("0");
        txtUnitPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitPriceActionPerformed(evt);
            }
        });
        txtUnitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnitPriceKeyReleased(evt);
            }
        });

        lblTotalPrice.setText("Total Price:");
        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtTotalPrice.setText("0");
        txtTotalPrice.setMinimumSize(new java.awt.Dimension(64, 25));
        txtTotalPrice.setPreferredSize(new java.awt.Dimension(64, 25));
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });

        lblRequestedBy.setText("Requested By: ");
        lblRequestedBy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtRequestedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestedByActionPerformed(evt);
            }
        });

        jLabel12.setText("Enter Purchase Requisition Details");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnCreatePR.setText("CREATE PR");
        btnCreatePR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePRActionPerformed(evt);
            }
        });

        cbxItemName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxItemName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxItemNameItemStateChanged(evt);
            }
        });
        cbxItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxItemNameActionPerformed(evt);
            }
        });

        lblSupplierID.setText("Supplier ID:");
        lblSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblSupplierName.setText("Supplier Name: ");
        lblSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        cbxSupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSupplierIDActionPerformed(evt);
            }
        });

        txtSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierNameActionPerformed(evt);
            }
        });

        txtItemCode.setPreferredSize(new java.awt.Dimension(64, 25));
        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblRequisitionID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblItemName)
                                        .addComponent(lblItemCode))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbxItemName, 0, 123, Short.MAX_VALUE)
                                        .addComponent(txtItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSupplierName)
                                        .addComponent(lblSupplierID))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(txtRequestedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(lblQuantity)
                                            .addGap(36, 36, 36)
                                            .addComponent(txtQuantityValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblRequestedBy)
                                        .addGap(141, 141, 141)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategory)))
                        .addGap(0, 45, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btnCreatePR, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(lblCategory))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRequisitionID)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRequisitionID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblQuantity)
                                        .addComponent(txtQuantityValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDate)
                                    .addComponent(txtCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblItemName)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblUnitPrice)
                                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalPrice)
                                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemCode)
                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRequestedBy)
                            .addComponent(txtRequestedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupplierID)
                            .addComponent(cbxSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierName))
                .addGap(59, 59, 59)
                .addComponent(btnCreatePR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCurrentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentDateActionPerformed

    }//GEN-LAST:event_txtCurrentDateActionPerformed

    
    private void txtQuantityValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityValueActionPerformed
    }//GEN-LAST:event_txtQuantityValueActionPerformed

    
    
    private void txtUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceActionPerformed

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void btnCreatePRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePRActionPerformed
        try {
            // Retrieve values 
            int quantityValue = Integer.parseInt(txtQuantityValue.getText().trim()); 
            double unitPriceValue = Double.parseDouble(txtUnitPrice.getText().trim());  

            
            // Create the requisition object based on the input values
            CreatePR requisition = createRequisition(quantityValue, unitPriceValue);
            
            // If requisition creation is successful, save it to file
            if (requisition != null) {
                requisition.saveRequisitionToFile();
                JOptionPane.showMessageDialog(this, "Purchase Requisition created successfully!");
                this.dispose();  // Close the dialog after successful creation
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and unit price.");
        }
          
    }//GEN-LAST:event_btnCreatePRActionPerformed

    
    private void txtRequisitionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequisitionIDActionPerformed
        
        
    }//GEN-LAST:event_txtRequisitionIDActionPerformed

    private void cbxSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSupplierIDActionPerformed
        String selectedSupplierID = (String) cbxSupplierID.getSelectedItem();
        
        if (selectedSupplierID != null && !selectedSupplierID.isEmpty()) {
            
             // CreatePR instance and get supplier details
            CreatePR pr = new CreatePR();
            pr.setSupplierDetails(selectedSupplierID); // Set supplier details using the selected ID

            Supplier supplier = pr.getSupplier(); // Get the supplier object
            
            txtSupplierName.setText(supplier.getSupplierName());
        } else {
            txtSupplierName.setText("");
        }
    }//GEN-LAST:event_cbxSupplierIDActionPerformed

    
    private void cbxItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxItemNameActionPerformed
        String selectedItemName = (String) cbxItemName.getSelectedItem();
        
        System.out.println("Selected Item: " + selectedItemName);
    
        // Skip processing if the selected item is null or the default placeholder
        if (selectedItemName == null || selectedItemName.isEmpty() || "Select an item".equals(selectedItemName) || "ALL".equals(selectedItemName)) {
            System.out.println("No valid item selected. Exiting...");
            return;
        }

        // Create a CreatePR instance and fetch item details
        CreatePR pr = new CreatePR();
        List<String> supplierList = pr.setItemDetails(selectedItemName);

        // Check if the item was set correctly
        if (pr.getItem() == null) {
            System.out.println("Item details not found for: " + selectedItemName);
            JOptionPane.showMessageDialog(this, "Item details could not be loaded. Please check the inventory file.");
            return;
        }

        // Update the text fields with the fetched data
        Item item = pr.getItem();
        txtItemCode.setText(item.getItemCode()); // Set the item code
        txtUnitPrice.setText(String.valueOf(item.getUnitPrice())); // Set the unit price

        // Populate the Supplier ID combo box
        cbxSupplierID.removeAllItems();
        for (String supplierID : supplierList) {
            cbxSupplierID.addItem(supplierID);
        }

        // Set the default supplier details if available
        if (!supplierList.isEmpty()) {
            pr.setSupplierDetails(supplierList.get(0));
            Supplier supplier = pr.getSupplier();
            txtSupplierName.setText(supplier.getSupplierName()); // Set the supplier name
        }
    }//GEN-LAST:event_cbxItemNameActionPerformed

    private void txtSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierNameActionPerformed

    private void txtRequestedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestedByActionPerformed

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void txtQuantityValueComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtQuantityValueComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityValueComponentShown

    private void txtQuantityValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityValueKeyReleased
         updateTotalPrice();
    }//GEN-LAST:event_txtQuantityValueKeyReleased

    private void txtUnitPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitPriceKeyReleased
         updateTotalPrice();
    }//GEN-LAST:event_txtUnitPriceKeyReleased

    private void cbxItemNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxItemNameItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxItemNameItemStateChanged

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
            java.util.logging.Logger.getLogger(CreatePR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePR_jDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreatePR_jDialog dialog = new CreatePR_jDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCreatePR;
    private javax.swing.JComboBox<String> cbxItemName;
    private javax.swing.JComboBox<String> cbxSupplierID;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblItemCode;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRequestedBy;
    private javax.swing.JLabel lblRequisitionID;
    private javax.swing.JLabel lblSupplierID;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JTextField txtCurrentDate;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtQuantityValue;
    private javax.swing.JTextField txtRequestedBy;
    private javax.swing.JTextField txtRequisitionID;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
