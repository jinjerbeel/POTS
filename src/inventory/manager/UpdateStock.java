/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.manager;
import java.util.*;
/**
 *
 * @author User
 */
public class UpdateStock {
    private String purchaseOrder;
    private String itemCode;
    private int quantity; 
    private static ArrayList<Item> itemList = new ArrayList<>();
    private static ArrayList<UpdateStock> stockList = new ArrayList<>();
    private static FileManager<Item> itemManager = new FileManager<>("./Inventory.txt");
    private static FileManager<UpdateStock> stockManager = new FileManager<>("./AddStock.txt");

    public UpdateStock(){}

    public UpdateStock(String purchaseOrder, String itemCode, int quantity) {
        this.purchaseOrder = purchaseOrder;
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static boolean updateStockQuantity(ArrayList<Item> itemList,String itemCode, int quantity) {
        itemList.clear();
        itemManager.read(itemList,Item.class);

        // Find the specific item in the list
        Item selectedItem = Item.findItemByCode(itemList, itemCode);
        int existingQuantity = selectedItem.getQuantity();
        int newQuantity = quantity + existingQuantity;
        selectedItem.setQuantity(newQuantity);
        
        itemManager.save(itemList);
        
        return true;
    }
    
    public static UpdateStock findPurchaseOrder(ArrayList<UpdateStock> stocks, String purchaseOrder) {
        for (UpdateStock stock : stocks) {
            if (stock.getPurchaseOrder().equals(purchaseOrder)) {
                return stock; // Return the item if a match is found
            }
        }
        return null; // Return null if no item with the given code is found
    }
    
    public static boolean deleteOrder(ArrayList<UpdateStock> stocks, String purchaseOrder) {
        // Remove the item from the in-memory list
        UpdateStock completeOrder = findPurchaseOrder(stocks, purchaseOrder);
        stocks.remove(completeOrder);

        stockManager.save(stockList);

        System.out.println("Stock has been updated");
        return true;
    }
    @Override
    public String toString() {
        return purchaseOrder + "," + itemCode + "," + quantity;
    }
}



