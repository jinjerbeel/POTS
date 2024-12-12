package Sales_Manager;

import Main.Config;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;

public class Item {
    private JTable tblItemList;
    
    public JTable getTblItemTable(){
        return tblItemList;
    }
    
    public void setTblItemTable(JTable tblItemList){
        this.tblItemList = tblItemList;
    }
    
    public Item(JTable tblItemList){
        this.tblItemList = tblItemList;
    }

    
    public void loadItemList()
    {
        // Access the table model
        DefaultTableModel model = (DefaultTableModel) tblItemList.getModel(); 
        model.setRowCount(0); // Clear existing data in the table
        
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getInventoryPath()))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // itemCode,itemName,supplierID,stockLevel,price,category
                String[] itemData = line.split(",");
                model.addRow(itemData); // Add the item as a new row in the table model
            }
        } catch (IOException ex) 
        {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
}
