package inventory.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Supplier {
    private String supplierCode;
    private String supplierName;
    private String hqLocation;
    private  ArrayList<String> suppliedItemCodes = new ArrayList<>();
    private  ArrayList<Supplier> supplierList = new ArrayList<>();
    private  ArrayList<Item> itemList = new ArrayList<>();
    private static FileManager<Item> itemManager = new FileManager<>("C:\\Users\\User\\OneDrive\\Documents\\APU\\Java Y2\\NetBeansProjects\\Inventory Manager\\src\\inventory\\manager\\Inventory.txt");
    private static FileManager<Supplier> supplierManager = new FileManager<>("C:\\Users\\User\\OneDrive\\Documents\\APU\\Java Y2\\NetBeansProjects\\Inventory Manager\\src\\inventory\\manager\\Supplier.txt");
    private static String supplierPath = "C:\\Users\\User\\OneDrive\\Documents\\APU\\Java Y2\\NetBeansProjects\\Inventory Manager\\src\\inventory\\manager\\Supplier.txt";

    public Supplier(){};
    public Supplier(String supplierCode, String supplierName, String hqLocation, ArrayList<String> suppliedItemCodes) {
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.hqLocation = hqLocation;
        this.suppliedItemCodes = suppliedItemCodes;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getHqLocation() {
        return hqLocation;
    }

    public ArrayList<String> getSuppliedItemCodes() {
        return suppliedItemCodes;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setHqLocation(String hqLocation) {
        this.hqLocation = hqLocation;
    }

    public void setSuppliedItemCodes(ArrayList<String> suppliedItemCodes) {
        this.suppliedItemCodes = suppliedItemCodes;
    }

    @Override
    public String toString() {
        // Join suppliedItemCodes with semicolons for CSV format
        String suppliedItemCodesStr = (suppliedItemCodes == null || suppliedItemCodes.isEmpty()) ? "" : String.join(";", suppliedItemCodes);
        
        // Return a CSV representation of the Supplier object
        return supplierCode + "," + supplierName + "," + hqLocation + "," + suppliedItemCodesStr;
    }
    
    public static boolean addSupplier(ArrayList<Supplier> suppliers, ArrayList<Item> items, Supplier newSupplier) {
        // Add the new supplier to the in-memory list
        suppliers.add(newSupplier);

        // Associate the supplier with each item in newSupplier's suppliedItemCodes list
        for (String itemCode : newSupplier.getSuppliedItemCodes()) {
            Item item = Item.findItemByCode(items, itemCode);
            if (item != null) {
                item.addSupplierCode(newSupplier.getSupplierCode());
            }
        }

        // Save both the suppliers and items lists to files
        supplierManager.save(suppliers);
        itemManager.save(items);

        System.out.println("Supplier added and saved successfully, with item codes updated.");
        return true;
    }


    
    public static boolean modifySupplier(ArrayList<Supplier> suppliers, ArrayList<Item> items, String supplierCode, String newName,
            String newHQ, ArrayList<String> newSuppliedItemCodes) {
       // Find the supplier in the list and update the details
        if(newSuppliedItemCodes != null && newSuppliedItemCodes.stream().noneMatch(String::isBlank)){
            for (String newItemCode : newSuppliedItemCodes) {
                if (Item.findItemByCode(items, newItemCode) == null) {  // If item code does not exist in items
                    System.out.println("Invalid item code: " + newItemCode);
                    return false;  // Exit if any invalid code is found
                }
            }
        }
       
        Supplier selectedSupplier = Supplier.findSupplierByCode(suppliers, supplierCode);
        ArrayList<String> oldSuppliedItemCodes = selectedSupplier.getSuppliedItemCodes() != null ? new ArrayList<>(selectedSupplier.getSuppliedItemCodes()) : new ArrayList<>();

        if (!oldSuppliedItemCodes.isEmpty()&& oldSuppliedItemCodes.stream().noneMatch(String::isBlank)){
            for (String oldItemCode : oldSuppliedItemCodes) {
                if (newSuppliedItemCodes == null || !newSuppliedItemCodes.contains(oldItemCode)) {
                    selectedSupplier.removeSuppliedItemCode(oldItemCode);
                    Item oldItem = Item.findItemByCode(items, oldItemCode);
                    if (oldItem != null) {
                        oldItem.removeSupplierCode(supplierCode);
                    }
                }
            }
        }

        // Loop through the new item codes and add associations that are newly added
        if (newSuppliedItemCodes != null&& !newSuppliedItemCodes.isEmpty()&& newSuppliedItemCodes.stream().noneMatch(String::isBlank)){
            for (String newItemCode : newSuppliedItemCodes) {
                if (!oldSuppliedItemCodes.contains(newItemCode)) {
                    selectedSupplier.addSuppliedItemCode(newItemCode);
                    Item newItem = Item.findItemByCode(items, newItemCode);
                    if (newItem != null) {
                        newItem.addSupplierCode(supplierCode);
                    }
                }
            }
        }

        selectedSupplier.setSupplierName(newName);
        selectedSupplier.setHqLocation(newHQ);

        // Save both the suppliers and items lists to files
        supplierManager.save(suppliers);
        itemManager.save(items);
        
        System.out.println("Supplier modified and associations updated successfully.");
        return true; // Modification successful
    }
    
    public static boolean deleteSupplier(ArrayList<Supplier> suppliers, ArrayList<Item> items, String supplierCode) {
        Supplier supplierToDelete = findSupplierByCode(suppliers, supplierCode);

        suppliers.remove(supplierToDelete);

        // Remove the supplier code from all associated items
        if(supplierToDelete.getSuppliedItemCodes() != null){
            for (String itemCode : supplierToDelete.getSuppliedItemCodes()) {
                Item item = Item.findItemByCode(items, itemCode);
                if (item != null) {
                    item.removeSupplierCode(supplierToDelete.getSupplierCode());
                }
            }
        }

        // Save both the suppliers and items lists to files
        supplierManager.save(suppliers);
        itemManager.save(items);
        
        System.out.println("Supplier deleted and items' supplier codes updated.");
        return true;
    }

    public static Supplier findSupplierByCode(ArrayList<Supplier> suppliers, String supplierCode) {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierCode().equals(supplierCode)) {
                return supplier;
            }
        }
        return null; // Return null if no matching supplier is found
    }

    
    public void addSuppliedItemCode(String itemCode) {
        if (suppliedItemCodes == null) {
            suppliedItemCodes = new ArrayList<>();
        }
        if (!suppliedItemCodes.contains(itemCode)) {
            suppliedItemCodes.add(itemCode); // Avoid duplicates
        }
    }
    public void removeSuppliedItemCode(String itemCode) {
        suppliedItemCodes.remove(itemCode);
    }
    
    public static List<String> filterSuppliersTable(String supplierCodeInput, String supplierNameInput, 
            String headquartersInput, String itemIDInput) {
        List<String> matchingRows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(supplierPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String supplierCode = parts[0].trim();
                String supplierName = parts[1].trim();
                String headquarters = parts[2].trim();
                String suppliedItemCodes = String.join(",", Arrays.asList(parts).subList(3, parts.length));

                // Filter conditions
                boolean matches = true;
                               
                if(!supplierCodeInput.isEmpty() && !supplierCode.equalsIgnoreCase(supplierCodeInput)&& !supplierCode.contains(supplierCodeInput)) matches = false;
                if(!supplierNameInput.equals("ALL") && !supplierName.contains(supplierNameInput)) matches = false;
                if(!headquartersInput.equals("ALL") && !headquarters.contains(headquartersInput)) matches = false;
                if(!itemIDInput.isEmpty() && !suppliedItemCodes.contains(itemIDInput)) matches = false;

                // Add to matchingRows if all conditions match
                if (matches) {
                    matchingRows.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading suppliers file: " + e.getMessage());
        }

        return matchingRows;
    }

}




