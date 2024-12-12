/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import Main.Config;
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


public class SupplierComboBoxDataLoader {
    
    private String filePath = Config.getSupplierPath();
    private File file = new File(filePath);
    
    // Constructor
    public SupplierComboBoxDataLoader() {}
    
    public SupplierComboBoxDataLoader(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }
    
    // Method to return unique values from a specific column in file
    private List<String> getUniqueValuesFromFile(int columnIndex) {
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

    
    // Method to fill JComboBox with unique supplier names
    public void fillSupplierNameComboBox(JComboBox<String> comboBox) {
        
        comboBox.removeAllItems(); 
        comboBox.addItem("ALL");

        // Retrieve unique supplier names from column index 1
        List<String> supplierNames = getUniqueValuesFromFile(1);
        
        // Add unique supplier name to JComboBox
        for (String supplierName : supplierNames) {
            comboBox.addItem(supplierName); 
        }
    }
    
   
    // Method to fill JComboBox with unique Headquarters
    public void fillHeadquartersComboBox(JComboBox<String> comboBox) {      
        
        // Clear existing items in the JComboBox
        comboBox.removeAllItems();
        comboBox.addItem("ALL");
        
        // Retrieve unique Headquarters from column index 5
        List<String> headquarters = getUniqueValuesFromFile(2);
              
        // Add unique Headquarters to JComboBox
        for (String headquarter : headquarters) {
            comboBox.addItem(headquarter); 
        }
        
    }
    
        
}
