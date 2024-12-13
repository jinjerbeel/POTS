/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import PurchaseManager.BaseRequisition;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PurchaseRequisition extends BaseRequisition {
    private static final String PR_FILE_PATH = Config.getPurchaseRequisitionPath();
    private static final String PO_FILE_PATH = Config.getPurchaseOrderPath();

    @Override
    public void loadData(String REQ_ID) {
        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].trim().equals(REQ_ID.trim())) { // Match REQ_ID with the chosen ID
                    // Use setters to update fields
                    setREQ_ID(columns[0].trim());
                    setDate(columns[1].trim());
                    setSupplierID(columns[2].trim());
                    setSupplierName(columns[3].trim());
                    setItemCode(columns[4].trim());
                    setItemName(columns[5].trim());
                    setQuantity(Integer.parseInt(columns[6].trim()));
                    setUnitPrice(Double.parseDouble(columns[7].trim()));
                    setTotalPrice(Double.parseDouble(columns[8].trim()));
                    setRequestedBy(columns[9].trim());
                    setStatus(columns[10].trim());
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric value: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error loading requisition data: " + e.getMessage());
        }
    }

    @Override
    public boolean validate() {
        // Use getters for validation
        return getREQ_ID() != null && !getREQ_ID().isEmpty() &&
                getSupplierID() != null && !getSupplierID().isEmpty();
    }

    
    public void approve(String approvedBy) {
        StringBuilder updatedPRFileContent = new StringBuilder();
        String approvedData = null;

        // Generate current date
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Generate new PO_ID
        String newPO_ID = generateNewPO_ID();

        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].trim().equals(getREQ_ID())) {
                    // Update data for PO
                    approvedData = newPO_ID + "," + getREQ_ID() + "," + currentDate + "," +
                            columns[2].trim() + "," + columns[3].trim() + "," +
                            columns[4].trim() + "," + columns[5].trim() + "," +
                            columns[6].trim() + "," + columns[7].trim() + "," +
                            columns[8].trim() + "," + approvedBy + ",Approved";
                } else {
                    updatedPRFileContent.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading PR file: " + e.getMessage());
        }

        // Write updated PR file without the approved PR
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PR_FILE_PATH))) {
            bw.write(updatedPRFileContent.toString());
        } catch (IOException e) {
            System.out.println("Error writing to PR file: " + e.getMessage());
        }

        // Append approved PR data to the PO file
        if (approvedData != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(PO_FILE_PATH, true))) {
                bw.write(approvedData + System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Error writing to PO file: " + e.getMessage());
            }
        } else {
            System.out.println("No data found for approval.");
        }
    }

    
    public static void refreshPRTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 11) { // Ensure valid data 
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
                        columns[10].trim() // Status
                    });
                }
            }
        } catch (IOException e) {
            System.out.println("Error refreshing PR table: " + e.getMessage());
        }
    }

    
    
    public static void refreshComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem(""); 

        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 11) { 
                    comboBox.addItem(columns[0].trim()); // Add REQ_ID to combo box
                }
            }
        } catch (IOException e) {
            System.out.println("Error refreshing combo box: " + e.getMessage());
        }
    }
    
    
    private String generateNewPO_ID() {
        String lastPOID = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(PO_FILE_PATH))) {
            String line;
            while((line = br.readLine()) != null) {
                lastPOID = line.split(",")[0];
            }
        } catch (IOException e) {
                System.out.println("Error occurred while reading the file: " + e.getMessage());
        }
        
        if (lastPOID != null && lastPOID.startsWith("PO")) {
            int lastNumber = Integer.parseInt(lastPOID.substring(2));
            return String.format("PO%03d", lastNumber + 1);
        } else {
            return "PO001";
        }
        
    }




}
