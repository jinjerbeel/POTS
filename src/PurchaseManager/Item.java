/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;


public class Item {
    private String itemCode;
    private String itemName;
    private String category;
    private int quantity;
    private double unitPrice;
    private String supplierID;
   

    public Item(String itemCode, String itemName, double unitPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }

    public Item(String itemCode, String itemName, String category, int quantity, double unitPrice, String supplierID) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.supplierID = supplierID;
    }

    
    // Getter
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }

    public String getSupplierID() {
        return supplierID;
    }

    
    
    // Setter
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
    
    
    

    
}
