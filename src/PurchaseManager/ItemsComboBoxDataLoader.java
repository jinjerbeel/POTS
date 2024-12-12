
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

public class ItemsComboBoxDataLoader {
    
    private String filePath = Config.getInventoryPath();
    private File file = new File(filePath);
    
    // Constructor
    public ItemsComboBoxDataLoader() {}
    
    public ItemsComboBoxDataLoader(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }
    
    // Method to return unique calues from a specific column in file
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

    
    // Method to fill JComboBox with unique item names
    public void fillItemNameComboBox(JComboBox<String> comboBox) {
        
        comboBox.removeAllItems(); 
        comboBox.addItem("ALL");

        // Retrieve unique item names from column index 1
        List<String> itemNames = getUniqueValuesFromFile(1);
        
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
        List<String> categories = getUniqueValuesFromFile(2);
              
        // Add unique categories to JComboBox
        for (String category : categories) {
            comboBox.addItem(category); 
        }
        
    }
    
        
}
