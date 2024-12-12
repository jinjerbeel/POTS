/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Jinan
 */

public class Config {
    // Base directory for all data files
    private static final String DATA_DIR = "./src/Data";
    
    // File names as constants
    private static final String USERS_FILE = "Users.txt";
    private static final String INVENTORY_FILE = "Inventory.txt";
    private static final String SUPPLIER_FILE = "Supplier.txt";
    private static final String SUPPLIED_ITEMS_FILE = "SuppliedItems.txt";
    private static final String ADD_STOCK_FILE = "AddStock.txt";
    private static final String PURCHASE_ORDER_FILE = "PurchaseOrder.txt";
    
    // getter
    public static String getUserPath() {
        return DATA_DIR + "/" + USERS_FILE;
    }
    
    public static String getInventoryPath() {
        return DATA_DIR + "/" + INVENTORY_FILE;
    }
    
    public static String getSupplierPath() {
        return DATA_DIR + "/" + SUPPLIER_FILE;
    }
    
    public static String getSuppliedItemsPath() {
        return DATA_DIR + "/" + SUPPLIED_ITEMS_FILE;
    }
    
    public static String getAddStockPath() {
        return DATA_DIR + "/" + ADD_STOCK_FILE;
    }
    
    public static String getPurchaseOrderPath() {
        return DATA_DIR + "/" + PURCHASE_ORDER_FILE;
    }
}