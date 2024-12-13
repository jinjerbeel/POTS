package FinanceManager;

import javax.swing.SwingUtilities;




public class PurchaseOrderClass {
    private String poNumber;
    private String requisitionID;
    private String date;
    private String supplierID;
    private String supplierName;
    private String itemCode;
    private String itemName;
    private String quantity;
    private String unitPrice;
    private String totalPrice;
    private String approvedBy;
    private String status;

    // Constructor
    public PurchaseOrderClass(String poNumber, String requisitionID, String date, String supplierID,
                              String supplierName, String itemCode, String itemName, String quantity,
                              String unitPrice, String totalPrice, String approvedBy, String status) {
        this.poNumber = poNumber;
        this.requisitionID = requisitionID;
        this.date = date;
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.approvedBy = approvedBy;
        this.status = status;
    }

    // Getters for all fields
    public String getPoNumber() {
        return poNumber;
    }

    public String getRequisitionID() {
        return requisitionID;
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

    public String getQuantity() {
        return quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public String getStatus() {
        return status;
    }
}
