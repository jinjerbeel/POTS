/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import Main.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GenerateRequisitionID {
    private static final String PR_FILE_PATH = Config.getPurchaseRequisitionPath();
    
    // Get the last requisition ID from the file
    private int getLastRequisitionID() {
        int maxID = 0;
        
     
        try(BufferedReader reader = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length > 0 && columns[0].startsWith("REQ")) {
                    try {
                        int id = Integer.parseInt(columns[0].substring(3));  // Get ID part and parse it
                        maxID = Math.max(maxID, id);  // Update max ID if a higher one is found
                    
                    } catch (NumberFormatException e) {
                        // Handle invalid ID formatsr 
                        System.err.println("Invalid ID format in line: " + line);
                    }
                }   
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return maxID;              
    }

    // Generate the next requisition ID
    public String generateNextRequisitionID() {
        int nextID = getLastRequisitionID() + 1;  // Increment last ID by 1
        return "REQ" + String.format("%03d", nextID);  // Ensure 4-digit format
    }
}


