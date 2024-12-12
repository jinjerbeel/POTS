package Sales_Manager;

import Main.Config;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Create {

    // Method to add new requisition to the purchase_requisition.txt file
    public static void createRequisition(String date, String itemName, String quantity, String supplierId) {
        // Ensure PR class is initialized and item data is loaded
        String itemCode = PR.getItemCode(itemName);  // Get Item Code from PR
        if (itemCode == null || itemCode.isEmpty()) {
            System.out.println("Error: Item not found.");
            return;
        }
        
        String supplierName = PR.getSupplierName(supplierId);  // Get Supplier Name from PR
        if (supplierName == null || supplierName.isEmpty()) {
            System.out.println("Error: Supplier not found.");
            return;
        }
        
        // Get the item unit price from PR
        float unitPrice = PR.getItemUnitPrice(itemCode);
        if (unitPrice == 0f) {
            System.out.println("Error: Invalid unit price for item.");
            return;
        }
        
        // Calculate total price
        float totalPrice = unitPrice * Integer.parseInt(quantity);  // Calculate total price
        
        // Generate a unique Requisition ID
        int reqCount = PR.getReqCount();
        String reqID = "REQ" + String.format("%03d", reqCount + 1);

        // Assuming requestedBy is always "SM001"
        String requestedBy = "SM001";
        String status = "Pending";  // Assuming initial status is "Pending"

        // Create the requisition string in the format: REQID, Date, SupplierID, SupplierName, ItemCode, ItemName, Quantity, UnitPrice, TotalPrice, RequestedBy, Status
        String requisitionData = String.format("%s,%s,%s,%s,%s,%s,%s,%.2f,%.2f,%s,%s\n",
                reqID, date, supplierId, supplierName, itemCode, itemName, quantity, unitPrice, totalPrice, requestedBy, status);

        // Write the new requisition data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getPurchaseRequisitionPath(), true))) {
            writer.write(requisitionData); // Append the new requisition to the file
            System.out.println("Requisition added successfully.");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
}
