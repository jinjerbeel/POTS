/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentdecsix.InventoryManager;

import assignmentdecsix.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;

public class ComboBoxDataLoader {
    
    private String itemPath = Config.getInventoryPath();
    private String supplierPath = Config.getSupplierPath();
    private File itemFile = new File(itemPath);
    private File supplierFile = new File(supplierPath);
    
    private String suppliedItemsPath = Config.getSuppliedItemsPath();
    private File suppliedItemsFile = new File(suppliedItemsPath);
    
    private String updateStockPath = Config.getAddStockPath();
    private File updateStockFile = new File(updateStockPath);
    // Constructor
    public ComboBoxDataLoader() {}
    
    public ComboBoxDataLoader(String itemFilePath, String supplierFilePath) {
        this.itemPath = itemFilePath;
        this.supplierPath = supplierFilePath;
        this.itemFile = new File(itemFilePath);
        this.supplierFile = new File(supplierFilePath);
    }
    
    // Method to return unique calues from a specific column in file
    private List<String> getUniqueValuesFromFile(File file,int columnIndex) {
        // Set to store unique values (no duplicates)
        Set<String> uniqueValues = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            
            // Read each line in the file
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > columnIndex) {
                    uniqueValues.add(columns[columnIndex].trim());
                }
            }
            
        } catch(IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        
        // Sort unique values and return as a List
        List<String> sortedValue = new ArrayList<>(uniqueValues);
        Collections.sort(sortedValue);
        return sortedValue;
        
    }
    public void fillPurchaseOrderComboBox(JComboBox<String> comboBox) {
        
        comboBox.removeAllItems(); 
        comboBox.addItem("NONE");

        // Retrieve unique item names from column index 1
        List<String> purchaseOrders = getUniqueValuesFromFile(updateStockFile, 0);
        
        // Add unique item name to JComboBox
        for (String purchaseOrder : purchaseOrders) {
            comboBox.addItem(purchaseOrder); 
        }
    }
    
    public void fillItemCodeComboBox(JComboBox<String> comboBox) {
        
        comboBox.removeAllItems(); 
        comboBox.addItem("NONE");

        // Retrieve unique item names from column index 1
        List<String> itemCodes = getUniqueValuesFromFile(itemFile, 0);
        
        // Add unique item name to JComboBox
        for (String itemCode : itemCodes) {
            comboBox.addItem(itemCode); 
        }
    }
    
    // Method to fill JComboBox with unique item names
    public void fillItemNameComboBox(JComboBox<String> comboBox) {
        
        comboBox.removeAllItems(); 
        comboBox.addItem("ALL");

        // Retrieve unique item names from column index 1
        List<String> itemNames = getUniqueValuesFromFile(itemFile, 1);
        
        // Add unique item name to JComboBox
        for (String itemName : itemNames) {
            comboBox.addItem(itemName); 
        }
    }
    
   
    // Method to fill JComboBox with unique categories
    public void fillCategoryComboBox(JComboBox<String> comboBox) {      
        
        // Clear existing items in the JComboBox
        comboBox.removeAllItems();
        comboBox.addItem("ALL");
        
        // Retrieve unique item names from column index 5
        List<String> categories = getUniqueValuesFromFile(itemFile,2);
              
        // Add unique categories to JComboBox
        for (String category : categories) {
            comboBox.addItem(category); 
        }
        
    }
    public void fillSupplierCodeComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("NONE");

        List<String> supplierCodes = getUniqueValuesFromFile(supplierFile, 0); // Column index for supplier names
        for (String supplierCode : supplierCodes) {
            comboBox.addItem(supplierCode);
        }
    }
    public void fillFilterSupplierCodeComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("ALL");

        List<String> supplierCodes = getUniqueValuesFromFile(suppliedItemsFile, 0); // Column index for supplier names
        for (String supplierCode : supplierCodes) {
            comboBox.addItem(supplierCode);
        }
    }
    public void fillFilterItemCodeComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("ALL");

        List<String> supplierCodes = getUniqueValuesFromFile(suppliedItemsFile, 1); // Column index for supplier names
        for (String supplierCode : supplierCodes) {
            comboBox.addItem(supplierCode);
        }
    }
    public void fillModifySupplierCodeComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("NONE");

        List<String> supplierCodes = getUniqueValuesFromFile(suppliedItemsFile, 0); // Column index for supplier names
        for (String supplierCode : supplierCodes) {
            comboBox.addItem(supplierCode);
        }
    }
    public void fillModifyItemCodeComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("NONE");

        List<String> supplierCodes = getUniqueValuesFromFile(suppliedItemsFile, 1); // Column index for supplier names
        for (String supplierCode : supplierCodes) {
            comboBox.addItem(supplierCode);
        }
    }
    public void fillSupplierNameComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("ALL");

        List<String> supplierNames = getUniqueValuesFromFile(supplierFile, 1); // Column index for supplier names
        for (String supplierName : supplierNames) {
            comboBox.addItem(supplierName);
        }
    }

    // Method to fill JComboBox with unique headquarters locations
    public void fillHeadquartersComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("ALL");

        List<String> headquarters = getUniqueValuesFromFile(supplierFile, 2); // Column index for headquarters
        for (String hq : headquarters) {
            comboBox.addItem(hq);
        }
    }
}
