/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import PurchaseManager.BaseRequisition;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterPR {
    private static final String PR_FILE_PATH = Config.getPurchaseRequisitionPath();

    // Method to filter the Purchase Requisition data
    public List<BaseRequisition> filterPRTable(
            String requisitionIDInput, 
            String dateInput, 
            String supplierIDInput,
            String supplierNameInput,
            String itemCodeInput, 
            String itemNameInput, 
            String comparisonOperatorInput, 
            String quantityValueInput, 
            boolean viewAllUnitPrice, String minUnitPriceInput, String maxUnitPriceInput,  
            boolean viewAllTotalPrice, String minTotalPriceInput, String maxTotalPriceInput, 
            String requestedByInput, 
            String statusInput) {
        
        // To store the filtered rows
        List<BaseRequisition> matchingRows = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) { 
            String line;
            
            SimpleDateFormat datePickerFormat = new SimpleDateFormat("MMMM dd, yyyy");
            SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date inputDate = null;
            
            // Parse the input date if it's provided
            if(!dateInput.isEmpty()) {
                try {
                    inputDate = datePickerFormat.parse(dateInput);
                } catch (ParseException e) {
                    System.out.println("Invalid date format for dateInput: " + dateInput);
                }
            }

            
            // Iterate through each line in the file
            while((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                
                boolean matches = true;
                
                BaseRequisition requisition = new PurchaseRequisition();
                
                // Set fields using the values from columns (e.g., from file data)
                requisition.setREQ_ID(columns[0].trim());
                requisition.setDate(columns[1].trim());
                requisition.setSupplierID(columns[2].trim());
                requisition.setSupplierName(columns[3].trim());
                requisition.setItemCode(columns[4].trim());
                requisition.setItemName(columns[5].trim());
                requisition.setQuantity(Integer.parseInt(columns[6].trim()));
                requisition.setUnitPrice(Double.parseDouble(columns[7].trim()));
                requisition.setTotalPrice(Double.parseDouble(columns[8].trim()));
                requisition.setRequestedBy(columns[9].trim());
                requisition.setStatus(columns[10].trim());
                
                // Filter checks for various fields
                if (!requisition.getREQ_ID().contains(requisitionIDInput) && !requisitionIDInput.isEmpty()) {
                    matches = false;
                }
                if (!requisition.getItemCode().contains(itemCodeInput) && !itemCodeInput.isEmpty()) {
                    matches = false;
                }
                if (!requisition.getItemName().contains(itemNameInput) && !itemNameInput.equals("ALL")) {
                    matches = false;
                }
                if (!requisition.getSupplierID().contains(supplierIDInput) && !supplierIDInput.isEmpty()) {
                    matches = false;
                }
                if (!requisition.getSupplierName().contains(supplierNameInput) && !supplierNameInput.equals("ALL")) {
                    matches = false;
                }
                if (!requisition.getRequestedBy().contains(requestedByInput) && !requestedByInput.isEmpty()) {
                    matches = false;
                }
                if (!requisition.getStatus().contains(statusInput) && !statusInput.equals("ALL")) {
                    matches = false;
                }

                // Date check
                if (inputDate != null && !requisition.getDate().isEmpty()) { 
                    try {
                        Date fileDate = fileDateFormat.parse(requisition.getDate().trim());
                        if (!inputDate.equals(fileDate)) {
                            matches = false;
                        }  
                    } catch (ParseException e) {
                        System.out.println("Error parsing date: " + e.getMessage()); 
                        matches = false;
                    }
                }
                
                       
             
                // Quantity filter with comparison operator
                if (!quantityValueInput.isEmpty() && !comparisonOperatorInput.equals("ALL")) {
                    try {
                        int itemQuantity = requisition.getQuantity(); // Parse quantity from the data file
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
                
                
                // Unit price filter
                if (!viewAllUnitPrice) {
                    double PRUnitPrice = requisition.getUnitPrice();
                    double minUnitPrice = Double.parseDouble(minUnitPriceInput);
                    double maxUnitPrice = Double.parseDouble(maxUnitPriceInput);

                    // Check if item’s unit price is within the specified range
                    if (!(PRUnitPrice >= minUnitPrice && PRUnitPrice <= maxUnitPrice)) {
                        matches = false;
                    }
                }
                
                
                // Total price filter
                if (!viewAllTotalPrice) {
                    double PRTotalPrice = requisition.getTotalPrice();
                    double minTotalPrice = Double.parseDouble(minTotalPriceInput);
                    double maxTotalPrice = Double.parseDouble(maxTotalPriceInput);

                    // Check if item’s total price is within the specified range
                    if (!(PRTotalPrice >= minTotalPrice && PRTotalPrice <= maxTotalPrice)) {
                        matches = false;
                    }
                }
        
                  
                
                if (matches) {
                    matchingRows.add(requisition);
                }                    
                
            }
            
        } catch(Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        
        return matchingRows;
    }
}
