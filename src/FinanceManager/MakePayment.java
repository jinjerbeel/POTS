/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FinanceManager;

import Main.Config;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rui
 */
public class MakePayment extends javax.swing.JFrame  {

    /**
     * Creates new form JFrame4
     */
    public MakePayment() {
        initComponents();
        this.refresh_data();
    }

    public void refresh_data() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0); // Clear existing rows from the table

            FileReader fr = new FileReader(Config.getPurchaseOrderPath());
            BufferedReader br = new BufferedReader(fr); //Object
            String read;

            while ((read = br.readLine()) != null) {
                String Po_number = read.split(",")[0];
                String Requisition_ID = read.split(",")[1];
                String Date = read.split(",")[2];
                String Supplier_ID = read.split(",")[3];
                String SupplierName = read.split(",")[4];
                String Item_Code = read.split(",")[5];
                String Item_Name = read.split(",")[6];
                String Quantity = read.split(",")[7];
                String Unit_Price = read.split(",")[8];
                String Total_Price = read.split(",")[9];
                String Approved_By = read.split(",")[10];
                String Status = read.split(",")[11];

                // Add row if status is "Approved"
                if (Status.equalsIgnoreCase(" Approved")) {
                    model.addRow(new Object[]{Po_number, Requisition_ID, Date, Supplier_ID, SupplierName, Item_Code , Item_Name, Quantity, Unit_Price, Total_Price, Approved_By, Status});

                }
            }

            // Close resources
            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1280, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 607));

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("Make Payment Page");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puchase Order ID", "Requisition ID", "Date", "Supplier ID", "Supplier Name", "Item ID", "Item Name", "Quantity", "Unit Price", "Total Price", "Approved By", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Make Payment");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setText("Search ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Search for Purchase Order :");

        jButton6.setText("Show All");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(jLabel1)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FinanceMenu jf1 = new FinanceMenu();
        jf1.show();

        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int selected_row = jTable3.getSelectedRow();
            if (selected_row == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to Make Payment.");
                return;
            }

            // File objects
            File inf = new File(Config.getPurchaseOrderPath());
            File tempFile = new File("temp.txt"); // Temporary file for PurchaseOrder
            File paymentFile = new File(Config.getPaymentHistoryPath()
);
            File addstockFile = new File("AddStock.txt");

            // File Readers and Writers
            FileReader fr = new FileReader(inf);
            FileWriter fwTemp = new FileWriter(tempFile);
            FileWriter fwPayment = new FileWriter(paymentFile, true); // Append to PaymentHistory.txt
            FileWriter fwAddstock = new FileWriter(addstockFile, true); // Append to AddStock.txt
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bwTemp = new BufferedWriter(fwTemp);
            BufferedWriter bwPayment = new BufferedWriter(fwPayment);
            BufferedWriter bwAddstock = new BufferedWriter(fwAddstock);

            String read;
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            String selectedRowId = model.getValueAt(selected_row, 0).toString();

            // Process the PurchaseOrder.txt file
            while ((read = br.readLine()) != null) {
                String[] fields = read.split(",");

                if (fields[0].equals(selectedRowId)) {
                    // This is the selected row; write it to PaymentHistory.txt with updated status
                    fields[fields.length - 1] = " Payment Made"; // Update status to 'Payment Made'
                    String updatedLine = String.join(",", fields);
                    bwPayment.write(updatedLine);  // delete line 
                    bwPayment.newLine();

                    // Write stock update to AddStock.txt
                    String Po_number = fields[0];
                    String Item_Code = fields[3];
                    String Quantity = fields[5];
                    bwAddstock.write(Po_number + "," + Item_Code + "," + Quantity); 
                    bwAddstock.newLine();
                } else {
                    // Write the other rows back to temp file
                    bwTemp.write(read);
                    bwTemp.newLine();
                }
            }

            // Close all file streams
            br.close();
            fr.close();
            bwTemp.close();
            fwTemp.close();
            bwPayment.close();
            fwPayment.close();
            bwAddstock.close();
            fwAddstock.close();

            // Replace the original PurchaseOrder.txt with the temp file
            if (!inf.delete()) {
                JOptionPane.showMessageDialog(null, "Error while updating the file.");
                return;
            }

            if (!tempFile.renameTo(inf)) {
                JOptionPane.showMessageDialog(null, "Error while renaming the file.");
                return;
            }

            JOptionPane.showMessageDialog(null, "Payment made successfully and Purchase Order updated.");

            // Refresh the table or UI if necessary
            this.refresh_data();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String str = jTextField1.getText().trim(); // Get the entered text and trim it
        if (!str.isEmpty()) {

            jTextField1.setText("");      // Clear the text field
        } else {
            JOptionPane.showMessageDialog(this, "Please enter text.");
        }  


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String enteredText = jTextField1.getText().trim(); // Get and trim text from the text field

        if (enteredText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Purchase Order number to search.");
            return;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0); // Clear existing rows from the table

            boolean found = false; // Initialize a flag to check for matches

            try (BufferedReader br = new BufferedReader(new FileReader(Config.getPurchaseOrderPath()))) {
                String read;

                while ((read = br.readLine()) != null) {
                    String[] data = read.split(","); // Split the line into an array of data

                    if (data.length < 12) { // Check if the line has at least 12 columns
                        JOptionPane.showMessageDialog(this, "Invalid data format in file.");
                        continue; // Skip invalid rows
                    }

                    String Po_number = data[0];       // Extract PO number
                    String Requisition_ID = data[1];
                    String Date = data[2];
                    String Supplier_ID = data[3];
                    String SupplierName = data[4];
                    String Item_Code = data[5];
                    String Item_Name = data[6];
                    String Quantity = data[7];
                    String Unit_Price = data[8];
                    String Total_Price = data[9];
                    String Approved_By = data[10];
                    String Status = data[11];

                    // Check if the PO number matches the entered text
                    if (Po_number.equalsIgnoreCase(enteredText)) {
                        found = true; // Match found
                        model.addRow(new Object[]{
                            Po_number, Requisition_ID, Date, Supplier_ID, SupplierName,
                            Item_Code, Item_Name, Quantity, Unit_Price, Total_Price,
                            Approved_By, Status
                        });
                    }
                }
            }

            // If no match is found, show a message
            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching Purchase Order found.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage());
        }
        // TODO add your handling code here:   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.refresh_data();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(MakePayment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakePayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
