package PurchaseManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Main.Config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TableLoader {
    private static final String ITEMS_FILE_PATH = Config.getInventoryPath();
    private static final String SUPPLIER_FILE_PATH = Config.getSupplierPath();
    private static final String PR_FILE_PATH = Config.getPurchaseRequisitionPath();
    private static final String PO_FILE_PATH = "src/TextFile/PurchaseOrder.txt";

    // JTable instancea
    private JTable table; 
    
    // Constructor to initialize the table
    public TableLoader(JTable table) {
        this.table = table; 
    }

    // Getter for JTable
    public JTable getTable() { 
        return table;
    }

    // Setter for JTable
    public void setTable(JTable table) {
        this.table = table;
    }

        
    // Method to load data into JTable from a specified file path
    public void loadData(String filePath) {
        DefaultTableModel model = (DefaultTableModel) table.getModel(); 
        model.setRowCount(0); // Clear existing rows
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                model.addRow(rowData); // Add the row to the table model
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    // Loading items data
    public void loadItemsData() {
        loadData(ITEMS_FILE_PATH);
    }

    // Loading supplier data
    public void loadSupplierData() {
        loadData(SUPPLIER_FILE_PATH);
    }
    
    // Loading PR data
    public void loadPurchaseRequisitionData() {
        loadData(PR_FILE_PATH);
    }
    
    // Loading PO data
    public void loadPurchaseOrderData() {
        loadData(PO_FILE_PATH);
    }
    
}
