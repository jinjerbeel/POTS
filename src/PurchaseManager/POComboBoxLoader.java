package PurchaseManager;

import Main.Config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class POComboBoxLoader {
    private static final String PO_FILE_PATH = Config.getPurchaseOrderPath();
    private static final String INVENTORY_FILE_PATH = Config.getInventoryPath();
    private static final String SUPPLIER_FILE_PATH = Config.getSupplierPath();


    // Constructor
    public POComboBoxLoader() {}


    // Method to return unique calues from a specific column in file
    private List<String> getUniqueValuesFromFile(int columnIndex) {
        // Set to store unique values 
        Set<String> uniqueValues = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PO_FILE_PATH))) {
            String line;

            // Read each line in the file
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > columnIndex) {
                    uniqueValues.add(columns[columnIndex].trim());
                }
            }

        } catch(IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }

        // Sort unique values and return as a List
        List<String> sortedValue = new ArrayList<>(uniqueValues);
        Collections.sort(sortedValue);
        return sortedValue;

    }

        
        
    public void populatePOIDComboBox(JComboBox<String> comboBox) {
        
        comboBox.removeAllItems();
        comboBox.addItem("");
        
        List<String> PO_IDs = getUniqueValuesFromFile(0);
        
        for (String PO_ID : PO_IDs) {
            comboBox.addItem(PO_ID);
        }
    }
    

    public void calculateTotalPrice(JTextField txtNewQuantity, JTextField txtPOUnitPrice, JTextField txtPOTotalPrice) {
        try {
            String quantityText = txtNewQuantity.getText().trim();
            String unitPriceText = txtPOUnitPrice.getText().trim();

            if (quantityText.isEmpty() || unitPriceText.isEmpty()) {
                txtPOTotalPrice.setText("0.00");
                return;
            }

            int newQuantity = Integer.parseInt(quantityText);
            double unitPrice = Double.parseDouble(unitPriceText);


            double totalPrice = newQuantity * unitPrice;

            txtPOTotalPrice.setText(String.format("%.2f", totalPrice));
            
        } catch(NumberFormatException e) {
            System.out.println("Error: Please ensure that quantity and unit price are valid numbers.");
        }
       

        
    }

    
 
        
    public void loadSuppliers(String itemCode, JComboBox<String> comboBox) {
        comboBox.removeAllItems();

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 6 && columns[0].trim().equalsIgnoreCase(itemCode.trim())) {
                    String[] supplierIDs = columns[5].split(";");
                    for (String supplierID : supplierIDs) {
                        comboBox.addItem(supplierID.trim());
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory file: " + e.getMessage());
        }
    }
    
    
    // Method to update Supplier Name based on selected SupplierID
    public void updateSupplierName(String supplierID, JTextField txtPOSupplierName) {
        if (supplierID == null || supplierID.trim().isEmpty()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(SUPPLIER_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 2 && columns[0].trim().equals(supplierID.trim())) {
                    // If the SupplierID matches, set the Supplier Name
                    txtPOSupplierName.setText(columns[1].trim());  
                    break;  
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Supplier file: " + e.getMessage());
        }
    }
    

}