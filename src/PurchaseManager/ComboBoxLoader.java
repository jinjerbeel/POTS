/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PurchaseManager;

import Main.Config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;


public class ComboBoxLoader {
    private static final String ITEMS_FILE_PATH = Config.getInventoryPath();
    private static final String SUPPLIER_FILE_PATH = Config.getSupplierPath();
    private static final String PR_FILE_PATH = Config.getPurchaseRequisitionPath();
    private static final String INVENTORY_FILE_PATH = Config.getInventoryPath();


    // Method to return unique values from a specific column in a given file
    private List<String> getUniqueValuesFromFile(String filePath, int columnIndex) {
        // Set to store unique values (no duplicates)
        Set<String> uniqueValues = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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

    // Generic method to fill JComboBox with unique values from a specific file and column
    private void fillComboBox(JComboBox<String> comboBox, String filePath, int columnIndex) {
        comboBox.removeAllItems();
        comboBox.addItem("ALL");

        List<String> values = getUniqueValuesFromFile(filePath, columnIndex);
        for (String value : values) {
            comboBox.addItem(value);
        }
    }

    // Method to fill JComboBox with unique item names from the "Items.txt" file
    public void fillItemNameComboInItemsFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, ITEMS_FILE_PATH, 1);  // Column index for item names
    }

    // Method to fill JComboBox with unique categories from the "Items.txt" file
    public void fillCategoryComboInItemsFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, ITEMS_FILE_PATH, 2);  // Column index for categories
    }

    // Method to fill JComboBox with unique supplier names from the "Suppliers.txt" file
    public void fillSupplierNameComboInSupplierFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, SUPPLIER_FILE_PATH, 1);  // Column index for supplier names
    }

    // Method to fill JComboBox with unique Headquarters from the "Suppliers.txt" file
    public void fillHeadquartersComboInSupplierFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, SUPPLIER_FILE_PATH, 2);  // Column index for Headquarters
    }
    
    // Method to fill JComboBox with unique Item Name from the "PR.txt" file
    public void fillPRItemNameComboInPRFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, PR_FILE_PATH, 5);  // Column index for Item Name
    }

    // Method to fill JComboBox with unique Supplier Name from the "PR.txt" file
    public void fillPRSupplierNameComboInPRFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, PR_FILE_PATH, 3);  // Column index for Supplier Name
    }
    
    // Method to fill JComboBox with unique PR Status from the "PR.txt" file
    public void fillPRStatusComboInPRFrame(JComboBox<String> comboBox) {
        fillComboBox(comboBox, PR_FILE_PATH, 10);  // Column index for PR Status
    }
    
    
    // Method to fill JComboBox with unique Item Name from the "Inventory.txt" file
    public void fillPRItemNameInCreatePR(JComboBox<String> comboBox) {
        fillComboBox(comboBox, INVENTORY_FILE_PATH, 1);  // Column index for Item Name
    }

}
