/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.manager;
import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */
public class SuppliedItems {
    private Supplier supplier; // Aggregation
    private Item item;   
    private Double cost; // Nullable to represent missing cost values
    private static ArrayList<Supplier> supplierList = new ArrayList<>();
    private static ArrayList<Item> itemList = new ArrayList<>();
    private static ArrayList <SuppliedItems> suppliedItemsList = new ArrayList<>();
    private static FileManager<Supplier> supplierManager = new FileManager<>("./Supplier.txt");
    private static FileManager<SuppliedItems> suppliedItemsManager = new FileManager<>("./SuppliedItems.txt");
    private static FileManager<Item> itemManager = new FileManager<>("./Inventory.txt");
    private static String suppliedItemsPath = "./SuppliedItems.txt";


    public SuppliedItems(){}

    public SuppliedItems(Supplier supplier, Item item,Double cost) {
        this.supplier = supplier; // Aggregation: Supplier passed in and managed independently
        this.item = item;
        this.cost = cost;
    }

    // Getters and Setters
    public Supplier getSupplier() {
        return supplier;
    }

    public Item getItem() {
        return item;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return supplier.getSupplierCode() + "," + item.getItemCode() + "," + (cost != null ? cost : "");
    }

    public static void rebuildSuppliedItems() {
        // Read suppliers from Supplier.txt
        supplierList.clear();
        supplierManager.read(supplierList, Supplier.class);
        
        itemList.clear();
        itemManager.read(itemList, Item.class);
        // Read existing SupplierItems.txt for cost data
        suppliedItemsList.clear();
        suppliedItemsManager.read(suppliedItemsList, SuppliedItems.class);
        
        Map<String, Item> itemMap = new HashMap<>();
        for(Item item: itemList){
            itemMap.put(item.getItemCode(), item);
        }

        // Create a map for quick cost lookup by (supplierID + itemCode)
        Map<String, Double> costMap = new HashMap<>();
        for (SuppliedItems suppliedItem : suppliedItemsList) {
            String key = suppliedItem.getSupplier().getSupplierCode() + ":" + suppliedItem.getItem().getItemCode();
            costMap.put(key, suppliedItem.getCost());
        }

        // Rebuild the supplied items list
        ArrayList<SuppliedItems> newSuppliedItems = new ArrayList<>();

        for (Supplier supplier : supplierList) {
            if (supplier.getSuppliedItemCodes() != null) {
                for (String itemCode : supplier.getSuppliedItemCodes()) {
                    Item item = itemMap.get(itemCode);
                    if(item!= null){
                        String key = supplier.getSupplierCode() + ":" + itemCode;
                        Double cost = costMap.getOrDefault(key, null);
                        newSuppliedItems.add(new SuppliedItems(supplier,item , cost));
                    }
                    
                 }
            }
        }
        // Save the rebuilt list to SuppliedItems.txt
        suppliedItemsManager.save(newSuppliedItems);
    }

    public static boolean updateCost(ArrayList<SuppliedItems> suppliedItemsList, String supplierID, String itemID, Double newCost) {
        SuppliedItems selectedItem = findSuppliedItem(suppliedItemsList, supplierID, itemID);
        if (selectedItem == null) {
            return false;
        }

        selectedItem.setCost(newCost != null ? newCost : 0.0);

        // Save the updated list to the file
        suppliedItemsManager.save(suppliedItemsList);

        return true;
    }

    public static SuppliedItems findSuppliedItem(ArrayList<SuppliedItems> suppliedItemsList, 
            String supplierID, String itemID) {
        
        Map<String, Item> itemMap = new HashMap<>();
        for(Item item: itemList){
            itemMap.put(item.getItemCode(), item);
        }
    
        for (Supplier supplier : supplierList) {
            if (supplier.getSuppliedItemCodes() != null) {
                for (String itemCode : supplier.getSuppliedItemCodes()) {
                    Item item = itemMap.get(itemCode);
                    if(item!= null && item.getItemCode().equals(itemID) && supplier.getSupplierCode().equals(supplierID)){
                       for (SuppliedItems suppliedItem : suppliedItemsList) {
                            if (suppliedItem.getSupplier().equals(supplier) && 
                                suppliedItem.getItem().equals(item)) {
                                return suppliedItem; // Return the matched SuppliedItems object
                            }
                       }
                    }
                }
            }    
        }
        return null; // Return null if no match is found
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



