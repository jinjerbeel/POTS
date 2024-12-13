/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import PurchaseManager.Item;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemFilter {   
    private static final String ITEMS_FILE_PATH = Config.getInventoryPath();
    
    // Method to filter item data based on specified criteria
    public List<String> filterItemsTable(
            String itemCodeInput, String itemNameInput, String categoryInput, 
            String comparisonOperatorInput, String quantityValueInput, 
            boolean viewAllCostPrice, String minCostPriceInput, String maxCostPriceInput, String supplierIDInput) {
        
        List<String> matchingRows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ITEMS_FILE_PATH))) {
            String line;
            
            while ((line = br.readLine()) != null ) {
                String[] columns = line.split(","); 
                
                Item item = new Item(columns[0], columns[1], columns[2], 
                        Integer.parseInt(columns[3]), Double.parseDouble(columns[4]), columns[5]);
                                
                boolean matches = true;
                
                // Apply individual filters
                if(!itemCodeInput.isEmpty() && !columns[0].contains(itemCodeInput)) matches = false;
                if(!itemNameInput.equals("ALL") && !columns[1].contains(itemNameInput)) matches = false;
                if(!categoryInput.equals("ALL") && !columns[2].contains(categoryInput)) matches = false;
                if(!supplierIDInput.isEmpty() && !columns[5].contains(supplierIDInput)) matches = false;

                
                // Quantity filter with comparison operator
                if (!quantityValueInput.isEmpty() && !comparisonOperatorInput.equals("ALL")) {
                    try {
                        int itemQuantity = Integer.parseInt(columns[3].trim()); 
                        int quantityInput = Integer.parseInt(quantityValueInput);

                        // Switch statement to handle different comparison operators
                        switch (comparisonOperatorInput) {
                            case ">":
                                if (!(itemQuantity > quantityInput)) matches = false;
                                break;
                            case ">=":
                                if (!(itemQuantity >= quantityInput)) matches = false;
                                break;
                            case "<":
                                if (!(itemQuantity < quantityInput)) matches = false;
                                break;
                            case "<=":
                                if (!(itemQuantity <= quantityInput)) matches = false;
                                break;
                            case "==":
                                if (!(itemQuantity == quantityInput)) matches = false;
                                break; 
                            default:
                                // Handle unrecognized operators
                                matches = false; 
                                System.out.println("Invalid comparison operator: " + comparisonOperatorInput);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format for quantity. Skipping filter.");
                        matches = false; 
                    }
                }
                
                
                // Cost price filter
                if (!viewAllCostPrice) {
                    double itemCostPrice = Double.parseDouble(columns[4].trim());
                    double minCostPrice = Double.parseDouble(minCostPriceInput);
                    double maxCostPrice = Double.parseDouble(maxCostPriceInput);

                    // Check if item’s cost price is within the specified range
                    if (!(itemCostPrice >= minCostPrice && itemCostPrice <= maxCostPrice)) {
                        matches = false;
                    }
                }
                
                
                
                if (matches) {
                    matchingRows.add(line);
                }        
            }
            
        } catch(IOException ex){
            System.out.println("Error reading file: " + ex.getMessage());   
        }    
        
        return matchingRows;
    }

}
