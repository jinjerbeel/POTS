/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class Item {
    private String itemCode;
    private String itemName;
    private String description;
    private int quantity;   
    private double sellingPrice;
    private ArrayList<String> supplierCodes;
    
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Supplier> supplierList = new ArrayList<>();
    private static FileManager<Item> itemManager = new FileManager<>("C:\\Users\\User\\OneDrive\\Documents\\APU\\Java Y2\\NetBeansProjects\\Inventory Manager\\src\\inventory\\manager\\Inventory.txt");
    private static FileManager<Supplier> supplierManager = new FileManager<>("C:\\Users\\User\\OneDrive\\Documents\\APU\\Java Y2\\NetBeansProjects\\Inventory Manager\\src\\inventory\\manager\\Supplier.txt");
    private static String itemPath = "C:\\Users\\User\\OneDrive\\Documents\\APU\\Java Y2\\NetBeansProjects\\Inventory Manager\\src\\inventory\\manager\\Inventory.txt";

    public Item(){};
    public Item(String itemCode, String itemName, String description, int quantity, double sellingPrice, ArrayList<String> supplierCodes) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.description = description;
        this.quantity= quantity;
        this.sellingPrice = sellingPrice;
        this.supplierCodes = supplierCodes;
    }
    
    
    // Getters

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getSupplierCodes() {
        return supplierCodes;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSupplierCodes(ArrayList<String> supplierCodes) {
        this.supplierCodes = supplierCodes;
    }
    
    @Override
    public String toString() {
        // Replace null or empty supplierCodes with "NONE"
        String supplierCodesStr = (supplierCodes == null || supplierCodes.isEmpty()) ? "" : String.join(";", supplierCodes);

        String quantityStr = String.valueOf(quantity);
        String sellingPriceStr = String.valueOf(sellingPrice);

        // Return the CSV representation of the Item object
        return itemCode + "," + itemName + "," + description + "," + 
                quantityStr + "," + sellingPriceStr + "," + supplierCodesStr;
    }

    
    public static boolean addItem(ArrayList<Item> items, ArrayList<Supplier> suppliers, Item newItem){
        // Add the new item to the in-memory list
        items.add(newItem);
        
        // Associate the item with each supplier in newItem's supplierCodes list
        for (String supplierCode : newItem.getSupplierCodes()) {
            Supplier supplier = Supplier.findSupplierByCode(suppliers, supplierCode);
            if (supplier != null) {
                supplier.addSuppliedItemCode(newItem.getItemCode());
            }
        }
      
        // Save both the items and suppliers lists to files
        supplierManager.save(suppliers);
        itemManager.save(items);

        System.out.println("Item added and saved successfully, with supplier codes updated.");
        return true;
    }
    
    public static boolean deleteItem(ArrayList<Item> items, ArrayList<Supplier> suppliers, String itemCode) {
        // Remove the item from the in-memory list
        Item unwantedItem = Item.findItemByCode(items, itemCode);
        items.remove(unwantedItem);
        
        // Remove the item code from all associated suppliers
        if(unwantedItem.getSupplierCodes() != null){
            for (String supplierCode : unwantedItem.getSupplierCodes()) {
                Supplier supplier = Supplier.findSupplierByCode(suppliers, supplierCode);
                if (supplier != null) {
                    supplier.removeSuppliedItemCode(unwantedItem.getItemCode());
                }
            }
        }       
        // Save both the items and suppliers lists to files
        supplierManager.save(suppliers);
        itemManager.save(items);

        System.out.println("Item deleted and suppliers' item codes updated.");
        return true;
    }
 
    // Modify the details of an existing item
    public static boolean modifyItem(ArrayList<Item> items, ArrayList<Supplier> suppliers, String itemCode, String newName, String newDescription, 
            int newQuantity, double newSellingPrice, ArrayList<String> newSupplierCodes) {
        if(newSupplierCodes != null && newSupplierCodes.stream().noneMatch(String::isBlank)){
            for (String newSupplierCode : newSupplierCodes) {
                if (Supplier.findSupplierByCode(suppliers, newSupplierCode) == null) {  // If item code does not exist in items
                    System.out.println("Invalid item code: " + newSupplierCode);
                    return false;  // Exit if any invalid code is found
                }
            }
        }
       
        Item selectedItem = Item.findItemByCode(items, itemCode);
        ArrayList<String> oldSupplierCodes = selectedItem.getSupplierCodes() != null ? new ArrayList<>(selectedItem.getSupplierCodes()) : new ArrayList<>();
        
        if (oldSupplierCodes != null&& !oldSupplierCodes.isEmpty()&& oldSupplierCodes.stream().noneMatch(String::isBlank)){
            for (String oldSupplierCode : oldSupplierCodes) {
                if (newSupplierCodes == null || !newSupplierCodes.contains(oldSupplierCode)) {
                    selectedItem.removeSupplierCode(oldSupplierCode);
                    Supplier oldSupplier = Supplier.findSupplierByCode(suppliers, oldSupplierCode);
                    if (oldSupplier != null) {
                        oldSupplier.removeSuppliedItemCode(itemCode);
                    }
                }
            }
        }

        // Loop through the new item codes and add associations that are newly added
        if (newSupplierCodes != null && !newSupplierCodes.isEmpty()&& newSupplierCodes.stream().noneMatch(String::isBlank)){
            for (String newSupplierCode : newSupplierCodes) {
                if (oldSupplierCodes == null || !oldSupplierCodes.contains(newSupplierCode)) {
                    selectedItem.addSupplierCode(newSupplierCode);
                    Supplier newSupplier = Supplier.findSupplierByCode(suppliers, newSupplierCode);
                    if (newSupplier != null) {
                        newSupplier.addSuppliedItemCode(itemCode);
                    }
                }
            }
        }
        selectedItem.setItemName(newName);
        selectedItem.setDescription(newDescription);
        selectedItem.setQuantity(newQuantity);
        
        selectedItem.setSellingPrice(newSellingPrice);

        // Save both the suppliers and items lists to files
        supplierManager.save(suppliers);
        itemManager.save(items);

        System.out.println("Item modified and associations updated successfully.");
        return true; // Modification successful
    }

    // Find an item by its code
    public static Item findItemByCode(ArrayList<Item> items, String itemCode) {
        for (Item item : items) {
            if (item.getItemCode().equals(itemCode)) {
                return item; // Return the item if a match is found
            }
        }
        return null; // Return null if no item with the given code is found
    }
    public void addSupplierCode(String supplierCode) {
        if (supplierCodes == null) {
            supplierCodes = new ArrayList<>();
        }
        if (!supplierCodes.contains(supplierCode)) {
            supplierCodes.add(supplierCode);
        }
    }
    
    public void removeSupplierCode(String supplierCode) {
        supplierCodes.remove(supplierCode);
    }

    public static List<String> filterItemsTable(
            String itemCodeInput, 
            String itemNameInput, 
            String categoryInput, 
            String comparisonOperatorInput, 
            String quantityValueInput,  
            boolean viewAllSellingPrice, 
            String minSellingPriceInput, 
            String maxSellingPriceInput, 
            String supplierIDInput) {
        
        List<String> matchingRows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(itemPath))) {
            String line;
            
            while ((line = br.readLine()) != null ) {
                String[] parts = line.split(",");
                String itemCode = parts[0].trim();
                String itemName = parts[1].trim();
                String category = parts[2].trim();
                String quantity = parts[3].trim(); 
                String sellingPrice = parts[4].trim(); 
                String supplierCodes = String.join(";", Arrays.asList(parts).subList(5, parts.length));
                
                boolean matches = true;
                               
                
                if(!itemCodeInput.isEmpty() && !itemCode.equalsIgnoreCase(itemCodeInput)&& !itemCode.contains(itemCodeInput)) matches = false;
                if(!itemNameInput.equals("ALL") && !itemName.contains(itemNameInput)) matches = false;
                if(!categoryInput.equals("ALL") && !category.contains(categoryInput)) matches = false;
                if(!supplierIDInput.isEmpty() && !supplierCodes.contains(supplierIDInput)) matches = false;

                
                // Quantity filter with comparison operator
                if (!quantityValueInput.isEmpty() && !comparisonOperatorInput.equals("ALL")) {
                    try {
                        int itemQuantity = Integer.parseInt(quantity.trim()); // Parse quantity from the data file
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
                // Selling price filter
                if (!viewAllSellingPrice) {
                    double itemSellingPrice = Double.parseDouble(sellingPrice.trim());
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
