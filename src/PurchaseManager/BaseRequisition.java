/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;


public abstract class BaseRequisition {

    private String REQ_ID;
    private String date;
    private String supplierID;
    private String supplierName;
    private String itemCode;
    private String itemName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String requestedBy;
    private String status;

    
    // Abstract methods
    public abstract void loadData(String REQ_ID);

    public boolean validate() {
        return REQ_ID != null && !REQ_ID.isEmpty() && 
                supplierID != null && !supplierID.isEmpty();
    }

    // Getters and Setters (Controlled Access)

    public String getREQ_ID() {
        return REQ_ID;
    }

    public String getDate() {
        return date;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
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

    public void setREQ_ID(String REQ_ID) {
        this.REQ_ID = REQ_ID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
    
    
    
}
