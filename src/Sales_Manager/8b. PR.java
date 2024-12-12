package Sales_Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public class PR {

    // File paths
    private static final String REQUISITION_FILE = "C:\\Users\\jessw\\OneDrive\\Desktop\\Wynns\\APU\\Level 2\\Level 2 Sem 1\\OODJAVA\\Purchase_Requisition.txt";
    private static final String INVENTORY_FILE = "C:\\Users\\jessw\\OneDrive\\Desktop\\Wynns\\APU\\Level 2\\Level 2 Sem 1\\OODJAVA\\Inventory.txt";
    private static final String SUPPLIERS_FILE = "C:\\Users\\jessw\\OneDrive\\Desktop\\Wynns\\APU\\Level 2\\Level 2 Sem 1\\OODJAVA\\Supplier.txt";

    // HashMaps to store item and supplier data for fast lookup
    private static HashMap<String, String> itemCodes = new HashMap<>();  // Item name -> Item code
    private static HashMap<String, Float> itemPrices = new HashMap<>();  // Item code -> Item unit price
    private static HashMap<String, String> supplierNames = new HashMap<>();  // Supplier ID -> Supplier name

    static {
        // Load item and supplier data when the class is first loaded
        loadItemsData();
        loadSuppliersData();
    }

    // Method to load item data from the INVENTORY.TXT file
    private static void loadItemsData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {  // ItemCode, ItemName, Category, Quantity, UnitPrice, SupplierID
                    String itemCode = parts[0];
                    String itemName = parts[1];
                    float unitPrice = Float.parseFloat(parts[4]);
                    itemCodes.put(itemName, itemCode);
                    itemPrices.put(itemCode, unitPrice);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the Inventory file: " + e.getMessage());
        }
    }

    // Method to load supplier data from the SUPPLIERS.TXT file
    private static void loadSuppliersData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SUPPLIERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {  // SupplierID, SupplierName
                    String supplierId = parts[0];
                    String supplierName = parts[1];
                    supplierNames.put(supplierId, supplierName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the Supplier file: " + e.getMessage());
        }
    }

    // Method to get the item code based on item name
    public static String getItemCode(String itemName) {
        return itemCodes.getOrDefault(itemName, null);  // Return null if item not found
    }

    // Method to get the supplier name based on supplier ID
    public static String getSupplierName(String supplierId) {
        return supplierNames.getOrDefault(supplierId, null);  // Return null if supplier not found
    }

    // Method to get the unit price based on item code
    public static float getItemUnitPrice(String itemCode) {
        return itemPrices.getOrDefault(itemCode, 0f);  // Default to 0 if item code not found
    }

    // Method to load purchase requisition list into the JTable
    public static void loadPurchaseRequisitionList(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ReqID");
        model.addColumn("Date");
        model.addColumn("SupplierID");
        model.addColumn("SupplierName");
        model.addColumn("ItemCode");
        model.addColumn("ItemName");
        model.addColumn("Quantity");
        model.addColumn("UnitPrice");
        model.addColumn("TotalPrice");
        model.addColumn("RequestedBy");
        model.addColumn("Status");

        // Read the requisition data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(REQUISITION_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 11) {
                    model.addRow(parts); // Add row to table model
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the requisition file: " + e.getMessage());
        }

        table.setModel(model);
    }

    // Method to get the requisition count
    public static int getReqCount() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(REQUISITION_FILE))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error counting requisitions: " + e.getMessage());
        }
        return count;
    }

    // Method to increment requisition count (update the file after adding new requisition)
    public static void incrementReqCount() {
        // This method could update some counter if needed
    }

    // Method to append new requisition to the PURCHASE_REQUISITION.TXT file
    public static void addNewRequisition(String reqID, String date, String supplierID, String itemName, int quantity, String requestedBy) {
        String itemCode = getItemCode(itemName);
        if (itemCode == null) {
            System.out.println("Error: Item not found.");
            return; // Do not proceed if the item is not found
        }

        String supplierName = getSupplierName(supplierID);
        if (supplierName == null) {
            System.out.println("Error: Supplier not found.");
            return; // Do not proceed if the supplier is not found
        }

        float unitPrice = getItemUnitPrice(itemCode);
        float totalPrice = unitPrice * quantity;
        String status = "Pending"; // Default status

        String requisitionLine = String.join(",", reqID, date, supplierID, supplierName, itemCode, itemName,
                String.valueOf(quantity), String.valueOf(unitPrice), String.valueOf(totalPrice), requestedBy, status);

        try (FileWriter writer = new FileWriter(REQUISITION_FILE, true)) 
        {
            writer.write(requisitionLine + "\n"); // Append new requisition line to the file
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to the requisition file: " + e.getMessage());
        }

        System.out.println("New requisition added successfully.");
    }
}
