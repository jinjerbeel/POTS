
package PurchaseManager;

import Main.Config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SupplierFilter {

    public static List<String> filterSuppliersTable (
        String supplierCodeInput,
        String supplierNameInput,
        String headquartersInput,
        String contactNumInput,
        String emailAddressInput,
        String itemIDInput){
        
        List<String> matchingRows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(Config.getSupplierPath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String supplierCode = parts[0].trim();
                String supplierName = parts[1].trim();
                String headquarters = parts[2].trim();
                String contactNum = parts[3].trim();
                String emailAddress = parts[4].trim();

                // Get the list of supplied item codes from the line
                List<String> suppliedItemCodes = Arrays.asList(parts).subList(5, parts.length);
                


                // Filter conditions
                boolean matchesSupplierCode = supplierCodeInput.isEmpty() || supplierCode.equalsIgnoreCase(supplierCodeInput);
                boolean matchesSupplierName = supplierNameInput.isEmpty() || supplierName.equalsIgnoreCase(supplierNameInput) || supplierNameInput.equalsIgnoreCase("ALL");
                boolean matchesHeadquarters = headquartersInput.isEmpty() || headquarters.equalsIgnoreCase(headquartersInput) || headquartersInput.equalsIgnoreCase("ALL");
                boolean matchesContactNum = contactNumInput.isEmpty() || contactNum.equalsIgnoreCase(contactNumInput);
                boolean matchesEmailAddress = emailAddressInput.isEmpty() || emailAddress.equalsIgnoreCase(emailAddressInput);  
                boolean matchesItemID = itemIDInput.isEmpty() || suppliedItemCodes.contains(itemIDInput);

                
                // Add to matchingRows if all conditions match
                if (matchesSupplierCode && matchesSupplierName && matchesHeadquarters && matchesContactNum && matchesEmailAddress && matchesItemID) {
                    matchingRows.add(line);  
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading suppliers file: " + e.getMessage());
        }

        return matchingRows;
    }
}
    
  
