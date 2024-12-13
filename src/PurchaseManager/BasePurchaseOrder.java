/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import PurchaseManager.BaseRequisition;


public abstract class BasePurchaseOrder extends BaseRequisition {
    protected String PO_ID;
    protected String date;
    protected String approvedBy;
    protected String status;

    public String getPO_ID() {
        return PO_ID;
    }

    public String getDate() {
        return date;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setPO_ID(String PO_ID) {
        this.PO_ID = PO_ID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    public abstract boolean saveChanges(String PO_ID, String newSupplierID, String newQuantity);

}
