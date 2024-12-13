/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PurchaseManager;

import Main.Config;
import PurchaseManager.Supplier;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SupplierFilter {
    private static final String SUPPLIER_FILE_PATH = Config.getSupplierPath();

    public static List<String> filterSuppliersTable (
        String supplierCodeInput, String supplierNameInput, String headquartersInput, String itemIDInput){

        // List to hold matching supplier data rows
        List<String> matchingRows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(SUPPLIER_FILE_PATH))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                
                // Get the list of supplied item codes from the line
                List<String> suppliedItemCodes = Arrays.asList(columns[3].trim().split(";"));

 
                Supplier supplier = new Supplier(
                        columns[0].trim(), 
                        columns[1].trim(), 
                        columns[2].trim(), 
                        suppliedItemCodes
                );

                

                // Filter conditions
                boolean matchesSupplierCode = supplierCodeInput.isEmpty() || supplier.getSupplierID().equalsIgnoreCase(supplierCodeInput);
                boolean matchesSupplierName = supplierNameInput.isEmpty() || supplier.getSupplierName().equalsIgnoreCase(supplierNameInput) || supplierNameInput.equalsIgnoreCase("ALL");
                boolean matchesHeadquarters = headquartersInput.isEmpty() || supplier.getHeadquaters().equalsIgnoreCase(headquartersInput) || headquartersInput.equalsIgnoreCase("ALL");

                
                boolean matchesItemID = itemIDInput.isEmpty();  // If itemIDInput is empty, it matches all
                    if (!itemIDInput.isEmpty()) {
                        
                        // Check if the itemIDInput matches any of the supplied item codes
                        for (String item : suppliedItemCodes) {
                            if (item.trim().equals(itemIDInput.trim())) {
                                matchesItemID = true;
                                break;  
                            }
                        }
                    }
                    
                
                // Add to matchingRows if all conditions match
                if (matchesSupplierCode && matchesSupplierName && matchesHeadquarters && matchesItemID) {
                    matchingRows.add(line);  
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading suppliers file: " + e.getMessage());
        }

        return matchingRows;
    }
}
    
  
