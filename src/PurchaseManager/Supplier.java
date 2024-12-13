/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import java.util.List;


public class Supplier {
    private String supplierID;
    private String supplierName;
    private String headquaters;
    private List<String> suppliedItems;
   

    public Supplier(String supplierID, String supplierName) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
    }

    
    public Supplier(String supplierID, String supplierName, String headquaters, List<String> suppliedItems) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.headquaters = headquaters;
        this.suppliedItems = suppliedItems;
    }

    
    // Getter
    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getHeadquaters() {
        return headquaters;
    }

    public List<String> getSuppliedItems() {
        return suppliedItems;
    }

    
    // Setter
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setHeadquaters(String headquaters) {
        this.headquaters = headquaters;
    }

    public void setSuppliedItems(List<String> suppliedItems) {
        this.suppliedItems = suppliedItems;
    }

   
}
