package Sales_Manager;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;

public class Stock {
    private JTable tblStockLevel;
    
    public JTable getTblStockLevel() {
        return tblStockLevel;
    }
    
    public void setTblStockLevel(JTable tblStockLevel) {
        this.tblStockLevel = tblStockLevel;
    }
    
    public Stock(JTable tblStockLevel) {
        this.tblStockLevel = tblStockLevel;
    }

    public void loadStockLevel() {
        // Access the table model
        DefaultTableModel model = (DefaultTableModel) tblStockLevel.getModel();
        model.setRowCount(0); // Clear existing data in the table
        
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jessw\\OneDrive\\Desktop\\Wynns\\APU\\Level 2\\Level 2 Sem 1\\OODJAVA\\Inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the file has the format: itemCode,itemName,supplierID,stockLevel,price,category
                String[] itemData = line.split(",");
                
                if (itemData.length >= 4) { // Ensure there are enough columns in the file
                    Object[] row = {
                        itemData[0], // itemCode
                        itemData[1], // itemName
                        itemData[3]  // stockLevel
                    };
                    model.addRow(row); // Add the relevant data as a new row in the table model
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
}
