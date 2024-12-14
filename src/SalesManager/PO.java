/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesManager;

import Main.Config;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;

public class PO {
    private JTable tblPurchaseOrder;

    public JTable getTblPurchaseOrder() {
        return tblPurchaseOrder;
    }

    public void setTblPurchaseOrder(JTable tblPurchaseOrder) {
        this.tblPurchaseOrder = tblPurchaseOrder;
    }

    public PO(JTable tblPurchaseOrder) {
        this.tblPurchaseOrder = tblPurchaseOrder;
    }

    public void loadPurchaseOrderList() {
        // Access the table model
        DefaultTableModel model = (DefaultTableModel) tblPurchaseOrder.getModel();
        model.setRowCount(0); // Clear existing data in the table

        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getPurchaseOrderPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the file format is: POCode,POName,SupplierID,StockLevel,Price,Category
                String[] purchaseOrderData = line.split(",");
                model.addRow(purchaseOrderData); // Add the data as a new row in the table model
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
}