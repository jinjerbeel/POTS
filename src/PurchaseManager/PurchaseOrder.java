/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import PurchaseManager.BasePurchaseOrder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PurchaseOrder extends BasePurchaseOrder {
    
    private static final String PO_FILE_PATH = Config.getPurchaseOrderPath();

    @Override
    public void loadData(String PO_ID) {
        try (BufferedReader br = new BufferedReader(new FileReader(PO_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].trim().equals(PO_ID)) { // Match PO_ID
                    // Use setters to assign values
                    setPO_ID(columns[0].trim());
                    setREQ_ID(columns[1].trim());
                    setDate(columns[2].trim());
                    setSupplierID(columns[3].trim());
                    setSupplierName(columns[4].trim());
                    setItemCode(columns[5].trim());
                    setItemName(columns[6].trim());
                    setQuantity(Integer.parseInt(columns[7].trim()));
                    setUnitPrice(Double.parseDouble(columns[8].trim()));
                    setTotalPrice(Double.parseDouble(columns[9].trim()));
                    setApprovedBy(columns[10].trim());
                    setStatus(columns[11].trim());
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading PO data: " + e.getMessage());
        }
    }

    @Override
    public boolean saveChanges(String PO_ID, String newSupplierID, String newQuantity) {
        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(PO_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].trim().equals(PO_ID)) {
                    columns[3] = newSupplierID; // Update supplier ID
                    columns[7] = newQuantity;  // Update quantity
                    line = String.join(",", columns);
                    
                    updated = true; 
                }
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading purchase order file: " + e.getMessage());
            return false;
        }

        
        // Write updated PO file 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PO_FILE_PATH))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to purchase order file: " + e.getMessage());
            return false;
        }

        return updated;
    }
    

   
    
    public boolean deletePOData(String PO_ID, JTable tblPOTable) {
        List<String> lines = new ArrayList<>(); // To store the file's content
        boolean deleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(PO_FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (!columns[0].trim().equals(PO_ID)) {
                    lines.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return false;
        }

        
        // Write the updated content back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PO_FILE_PATH))) {
            for (String updatedLine : lines) {
                bw.write(updatedLine);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(null, "PO deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Re-load and refresh the table after saving the updated data
        refreshPOTable(tblPOTable);
        
        return deleted;
    }
    
    
    
    
    public static void refreshPOTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        try (BufferedReader br = new BufferedReader(new FileReader(PO_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 12) { // Ensure valid data
                    model.addRow(new Object[]{
                        columns[0].trim(), // REQ_ID
                        columns[1].trim(), // Date
                        columns[2].trim(), // Supplier ID
                        columns[3].trim(), // Supplier Name
                        columns[4].trim(), // Item Code
                        columns[5].trim(), // Item Name
                        columns[6].trim(), // Quantity
                        columns[7].trim(), // Unit Price
                        columns[8].trim(), // Total Price
                        columns[9].trim(), // Requested By
                        columns[10].trim(), // Status
                        columns[11].trim()
                    });
                }
            }
        } catch (IOException e) {
            System.out.println("Error refreshing PR table: " + e.getMessage());
        }
    }


}


