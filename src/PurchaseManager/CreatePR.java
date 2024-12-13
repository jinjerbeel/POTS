/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PurchaseManager;

import Main.Config;
import PurchaseManager.Supplier;
import PurchaseManager.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class CreatePR {
       
    private static final String INVENTORY_FILE_PATH = Config.getInventoryPath();
    private static final String SUPPLIER_FILE_PATH = Config.getSupplierPath();
    private static final String PR_FILE_PATH = Config.getPurchaseRequisitionPath();


    private String requisitionID;
    private String currentDate;

    private Item item;
    
    private Supplier supplier;
    
    private int quantity;
    private double totalPrice;
    private String requestedBy;
    private String status;

    public CreatePR(String requisitionID, String currentDate, Item item, Supplier supplier, int quantity, double totalPrice, String requestedBy, String status) {
        this.requisitionID = requisitionID;
        this.currentDate = currentDate;
        this.item = item;
        this.supplier = supplier;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.requestedBy = requestedBy;
        this.status = status;
    }

    public CreatePR() {
    }
    
    public double calculateTotalPrice() {
        return item.getUnitPrice() * quantity;
    }
    
   

    // Method to set item details and return the list of suppliers for the selected item
    public List<String> setItemDetails(String selectedItemName) {
        List<String> supplierList = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE_PATH))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns[1].trim().equalsIgnoreCase(selectedItemName.trim())) {
                    // Initialize item object
                    item = new Item(columns[0].trim(), columns[1].trim(), Double.parseDouble(columns[4].trim()));


                    // Process supplier IDs
                    String[] supplierIDs = columns[5].split(";");
                    for (String supplierID : supplierIDs) {
                        if (!supplierID.trim().isEmpty()) {
                            supplierList.add(supplierID.trim());
                        }
                    }
                    
                    
                    break; // Exit after finding the item
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory file: " + e.getMessage());
        }

        return supplierList;
    }



    // Method to set supplier details based on the selected supplier ID
    public void setSupplierDetails(String selectedSupplierID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(SUPPLIER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > 1 && columns[0].equalsIgnoreCase(selectedSupplierID)) {
                    supplier = new Supplier(columns[0].trim(), columns[1].trim());
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading supplier file: " + e.getMessage());
        }
    }

        
    

    
    // Save requisition to the file
    public void saveRequisitionToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PR_FILE_PATH, true))) {
            writer.write(requisitionID + "," + currentDate + "," +
                    supplier.getSupplierID() + "," + supplier.getSupplierName() + "," +
                    item.getItemCode() + "," + item.getItemName() + "," +
                    quantity + "," + item.getUnitPrice() + "," +
                    String.format("%.2f", totalPrice) + "," +
                    requestedBy + "," + status);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    
    // Method to format the date
    public static String getFormattedDate() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(currentDate);
    }

    public static String getINVENTORY_FILE_PATH() {
        return INVENTORY_FILE_PATH;
    }

    public static String getSUPPLIER_FILE_PATH() {
        return SUPPLIER_FILE_PATH;
    }

    public static String getPR_FILE_PATH() {
        return PR_FILE_PATH;
    }

    public String getRequisitionID() {
        return requisitionID;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public Item getItem() {
        return item;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setRequisitionID(String requisitionID) {
        this.requisitionID = requisitionID;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Purchase Requisition [ID: " + requisitionID + ", Date: " + currentDate +
                ", Item: " + item + ", Supplier: " + supplier +
                ", Quantity: " + quantity + ", Total Price: " + totalPrice +
                ", Requested By: " + requestedBy + ", Status: " + status + "]";
    }
    
}
