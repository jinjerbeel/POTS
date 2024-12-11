/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

import assignmentdecsix.Config;
import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */
public class SuppliedItems {
    private String supplierID;
    private String itemCode;
    private Double cost; // Nullable to represent missing cost values
    private static ArrayList<Supplier> supplierList = new ArrayList<>();
    private static ArrayList <SuppliedItems> suppliedItemsList = new ArrayList<>();
    private static FileManager<Supplier> supplierManager = new FileManager<>(Config.getSupplierPath());
    private static FileManager<SuppliedItems> suppliedItemsManager = new FileManager<>(Config.getSuppliedItemsPath());
    private static String suppliedItemsPath = Config.getSuppliedItemsPath();


    public SuppliedItems(){}

    public SuppliedItems(String supplierID, String itemCode, Double cost) {
        this.supplierID = supplierID;
        this.itemCode = itemCode;
        this.cost = cost;
    }

    // Getters and Setters
    public String getSupplierID() {
        return supplierID;
    }
    
    public String getItemCode() {
        return itemCode;
    }
        
    public Double getCost() {
        return cost;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return supplierID + "," + itemCode + "," + (cost != null ? cost : "");
    }
    
    public static void rebuildSuppliedItems() {
        // Read suppliers from Supplier.txt
        supplierList.clear();
        supplierManager.read(supplierList, Supplier.class);

        // Read existing SupplierItems.txt for cost data
        suppliedItemsList.clear();
        suppliedItemsManager.read(suppliedItemsList, SuppliedItems.class);


        // Create a map for quick cost lookup by (supplierID + itemCode)
        Map<String, Double> costMap = new HashMap<>();
        for (SuppliedItems item : suppliedItemsList) {
            String key = item.getSupplierID() + ":" + item.getItemCode();
            costMap.put(key, item.getCost());
        }

        // Rebuild the supplied items list
        ArrayList<SuppliedItems> newSuppliedItems = new ArrayList<>();

        for (Supplier supplier : supplierList) {
            if (supplier.getSuppliedItemCodes() != null) {
                for (String itemCode : supplier.getSuppliedItemCodes()) {
                    String key = supplier.getSupplierCode() + ":" + itemCode;
                    Double cost = costMap.getOrDefault(key, null);
                    newSuppliedItems.add(new SuppliedItems(supplier.getSupplierCode(), itemCode, cost));

                    
                 }
            }
        }
        // Save the rebuilt list to SuppliedItems.txt
        suppliedItemsManager.save(newSuppliedItems);
    }

    public static boolean updateCost(ArrayList<SuppliedItems> suppliedItems, String supplierID, String itemCode, Double newCost) {
        SuppliedItems selectedItem = SuppliedItems.findSuppliedItem(suppliedItems, supplierID, itemCode);
        if (selectedItem == null){
            return false;
        }
        
        if (newCost == null){
            newCost = 0.0;
        }
        selectedItem.setCost(newCost);
        
        suppliedItemsManager.save(suppliedItems);
        
        return true;
    }
    public static SuppliedItems findSuppliedItem(ArrayList<SuppliedItems> suppliedItems, String supplierID, String itemCode) {
        // Read the file and populate the supplierItemsList
    // Search for the matching supplierID and itemCode
        for (SuppliedItems item : suppliedItems) {
            if (item.getSupplierID().equals(supplierID) && item.getItemCode().equals(itemCode)) {
                return item; // Return the matching SupplierItems object
            }
        }
        return null;
    }
    
    public static List<String> filterSuppliedItemsTable(
            String supplierIDInput,
            String itemCodeInput, 
            boolean viewAllCostPrice, 
            String minCostPriceInput, 
            String maxCostPriceInput) {
        
        List<String> matchingRows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(suppliedItemsPath))) {
            String line;
            
            while ((line = br.readLine()) != null ) {
                String[] parts = line.split(",");
                String supplierCode = parts[0].trim();
                String itemCode = parts[1].trim();
                String cost = (parts.length > 2) ? parts[2].trim() : ""; 
                
                boolean matches = true;
                

                if (!supplierIDInput.equals("ALL") && !supplierCode.equals(supplierIDInput)) {
                    matches = false;
                }

                // Check itemCode
                if (!itemCodeInput.equals("ALL") && !itemCode.equals(itemCodeInput)) {
                    matches = false;
                }

                
                if (!viewAllCostPrice && !cost.isEmpty()) {
                    try {
                        double itemCostPrice = Double.parseDouble(cost);
                        double minCostPrice = Double.parseDouble(minCostPriceInput);
                        double maxCostPrice = Double.parseDouble(maxCostPriceInput);

                        // Ensure item cost is within the specified range
                        if (!(itemCostPrice >= minCostPrice && itemCostPrice <= maxCostPrice)) {
                            matches = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing cost or price range: " + e.getMessage());
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



