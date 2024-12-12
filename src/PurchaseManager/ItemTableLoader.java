package PurchaseManager;


import Main.Config;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;


public class ItemTableLoader {
    // Declare the JTable
    private JTable tblItemsTable;  
    
    // Getter
    public JTable getTblItemsTable() { 
        return tblItemsTable;
    }

    // Setter
    public void setTblItemsTable(JTable tblItemsTable) {
        this.tblItemsTable = tblItemsTable;
    }

    
    // Assign JTable from another form or frame
    public ItemTableLoader(JTable tblItemsTable) {
        this.tblItemsTable = tblItemsTable; 

    }
    
    public void loadItemsData(){
        // Access the table model
        DefaultTableModel model = (DefaultTableModel) tblItemsTable.getModel(); 
        model.setRowCount(0); // Clear existing data in the table
        
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getInventoryPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // itemCode,itemName,supplierID,stockLevel,price,category
                String[] itemData = line.split(",");
                model.addRow(itemData); // Add the item as a new row in the table model
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
    
}
