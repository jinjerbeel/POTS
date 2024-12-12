/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;


import Main.Config;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author huawei d15
 */
public class SupplierTableLoader {
    private JTable tblSupplierTable;
    
    // Getter
    public JTable getTblSupplierTable() {
        return tblSupplierTable;
    }
    
    // Setter
    public void setTblSupplierTable(JTable tblSupplierTable) {
        this.tblSupplierTable = tblSupplierTable;
    }

    // Assign JTable from another form or frame
    public SupplierTableLoader(JTable tblSupplierTable) {
        this.tblSupplierTable = tblSupplierTable;
    }
    
    public void loadSupplierData() {
        DefaultTableModel model = (DefaultTableModel) tblSupplierTable.getModel();
        model.setRowCount(0);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getSupplierPath()))) {
            String line;
            
            while((line = reader.readLine()) != null) {
                String[] supplierData = line.split(",");
                String supplierCode = supplierData[0].trim();
                String supplierName = supplierData[1].trim();
                String headquarters = supplierData[2].trim();
                String contactNum = supplierData[3].trim();
                String emailAddress = supplierData[4].trim();
                
                // Get the list of supplied item codes from the line
                List<String> suppliedItemCodes = Arrays.asList(supplierData).subList(5, supplierData.length);
                
                // Concatenate the item codes into a single string, separated by commas
                String itemCodes = String.join(", ", suppliedItemCodes);
            
                // Create a row to add to the table with the concatenated item codes
                Object[] rowData = {
                    supplierCode,
                    supplierName,
                    headquarters,
                    contactNum,
                    emailAddress,
                    itemCodes // Concatenated item codes in the last column
                };
//                
//                
                
                model.addRow(rowData);
            }
            
        } catch(IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
    
}

