
package PurchaseManager;

import Main.Config;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemFilter {   
    // Method to filter item data based on specified search criteria
    public List<String> filterItemsTable(
            String itemCodeInput, 
            String itemNameInput, 
            String categoryInput, 
            String comparisonOperatorInput, 
            String quantityValueInput, 
            boolean viewAllCostPrice, 
            String minCostPriceInput, 
            String maxCostPriceInput, 
            boolean viewAllSellingPrice, 
            String minSellingPriceInput, 
            String maxSellingPriceInput, 
            String supplierIDInput) {
        
        List<String> matchingRows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(Config.getInventoryPath()))) {
            String line;
            
            while ((line = br.readLine()) != null ) {
                String[] columns = line.split(",");                
                
                List<String> supplierID = Arrays.asList(columns).subList(6, columns.length);
                
                boolean matches = true;
                
                
                if(!itemCodeInput.isEmpty() && !columns[0].contains(itemCodeInput)) matches = false;
                if(!itemNameInput.equals("ALL") && !columns[1].contains(itemNameInput)) matches = false;
                if(!categoryInput.equals("ALL") && !columns[2].contains(categoryInput)) matches = false;
                if(!supplierIDInput.isEmpty() && !columns[6].contains(supplierIDInput)) matches = false;

                
                // Quantity filter with comparison operator
                if (!quantityValueInput.isEmpty() && !comparisonOperatorInput.equals("ALL")) {
                    try {
                        int itemQuantity = Integer.parseInt(columns[3].trim()); // Parse quantity from the data file
                        int quantityInput = Integer.parseInt(quantityValueInput); // Parse input quantity

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
                                matches = false; // Handle unrecognized operators
                                System.out.println("Invalid comparison operator: " + comparisonOperatorInput);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format for quantity. Skipping filter.");
                        matches = false; // Invalid number format means this filter fails
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
                
                
                // Selling price filter
                if (!viewAllSellingPrice) {
                    double itemSellingPrice = Double.parseDouble(columns[5].trim());
                    double minSellingPrice = Double.parseDouble(minSellingPriceInput);
                    double maxSellingPrice = Double.parseDouble(maxSellingPriceInput);

                    // Check if item’s selling price is within the specified range
                    if (!(itemSellingPrice >= minSellingPrice && itemSellingPrice <= maxSellingPrice)) {
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
