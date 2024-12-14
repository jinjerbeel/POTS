package SalesManager;

import Main.Config;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;
import java.util.HashMap;
import java.util.Map;

public class ReorderLevel {
    private JTable tblCheckReorderLevel;

    public JTable getTblCheckReorderLevel() {
        return tblCheckReorderLevel;
    }

    public void setTblCheckReorderLevel(JTable tblCheckReorderLevel) {
        this.tblCheckReorderLevel = tblCheckReorderLevel;
    }

    public ReorderLevel(JTable tblCheckReorderLevel) {
        this.tblCheckReorderLevel = tblCheckReorderLevel;
    }

    // Method to load reorder level data and calculate reorder quantities
    public void loadReorderLevelList() {
        DefaultTableModel model = (DefaultTableModel) tblCheckReorderLevel.getModel();
        model.setRowCount(0); // Clear existing data in the table

        Map<String, Integer> salesData = loadSalesData(); // Load sales data

        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getInventoryPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] inventoryData = line.split(",");

                if (inventoryData.length < 6) { // Ensure the line has at least 6 fields (adjust if Inventory.txt structure changes)
                    continue; // Skip invalid lines
                }

                String stockCode = inventoryData[0].trim();
                String stockName = inventoryData[1].trim();
                int inventoryQuantity = Integer.parseInt(inventoryData[3].trim());
                String supplierId = inventoryData[5].trim(); // Supplier ID (assuming it's in column 5)

                // Get the total quantity sold from sales data based on item name (not stock code)
                int salesQuantity = salesData.getOrDefault(stockName, 0);

                // Calculate current stock
                int currentStock = inventoryQuantity - salesQuantity;

                // Debugging print statement
                System.out.println("Inventory: " + stockName + " - Sales Quantity: " + salesQuantity + " - Current Stock: " + currentStock);

                // Determine reorder level
                String status = (currentStock < 30) ? "Low Stock" : "In Stock";
                int reorderQuantity = (currentStock < 30) ? 30 - currentStock : 0;

                // Add data to the table model
                model.addRow(new Object[]{stockCode, stockName, currentStock, status, reorderQuantity, supplierId});
            }

            writeUpdatedStockData(salesData); // Optional: Write updated stock data

        } catch (IOException ex) {
            System.out.println("Error reading inventory file: " + ex.getMessage());
        }
    }


    private Map<String, Integer> loadSalesData() {
        Map<String, Integer> salesData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getSalesPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] salesInfo = line.split(",");

                if (salesInfo.length < 3) {
                    continue; // Skip invalid lines
                }

                String itemName = salesInfo[1].trim(); // Use item name from sales file
                int quantitySold = Integer.parseInt(salesInfo[2].trim());

                salesData.put(itemName, salesData.getOrDefault(itemName, 0) + quantitySold);

                // Debugging print statement
                System.out.println("Sales Data: " + itemName + " - Quantity Sold: " + quantitySold);
            }
        } catch (IOException ex) {
            System.out.println("Error reading sales file: " + ex.getMessage());
        }

        return salesData;
    }

    // Method to write the updated stock data back to the current stock file
    private void writeUpdatedStockData(Map<String, Integer> salesData) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getInventoryPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getCurrentStockPath()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] inventoryData = line.split(",");
                String stockCode = inventoryData[0].trim();
                String stockName = inventoryData[1].trim();
                int inventoryQuantity = Integer.parseInt(inventoryData[3].trim());

                // Get the total quantity sold from sales data (or 0 if not found)
                int salesQuantity = salesData.getOrDefault(stockName, 0);

                // Calculate the current stock (inventory - sales)
                int currentStock = inventoryQuantity - salesQuantity;

                // Determine status and reorder quantity
                String status = (currentStock < 30) ? "Low Stock" : "In Stock";
                int reorderQuantity = (currentStock < 30) ? 30 - currentStock : 0;

                // Write the updated data to current_stock.txt with commas
                writer.write(stockCode + "," + stockName + "," + currentStock + "," + status + "," + reorderQuantity + "\n");

                // Debugging print statement
                System.out.println("Writing to Current_Stock.txt: " + stockName + " - Current Stock: " + currentStock + " - Status: " + status);
            }

            System.out.println("Updated stock data written to current_stock.txt.");
        } catch (IOException ex) {
            System.out.println("Error writing updated stock data: " + ex.getMessage());
        }
    }
}
