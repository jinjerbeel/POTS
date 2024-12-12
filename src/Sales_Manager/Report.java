package Sales_Manager;

import Main.Config;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class Report {

    private JTable tblSalesReport; // JTable to display the report

    // Constructor to initialize JTable
    public Report(JTable tblSalesReport) {
        this.tblSalesReport = tblSalesReport;
    }

    // Method to load report data from Sales_Report.txt into JTable
    public void loadReport() {
        DefaultTableModel model = (DefaultTableModel) tblSalesReport.getModel();
        model.setRowCount(0); // Clear existing data in the table

        try {
            // Read sales data and sales dates from sales.txt
            List<SaleEntry> salesList = readSalesData(Config.getSalesPath());

            // Read inventory data from inventory.txt
            Map<String, Double> inventoryData = readInventoryData(Config.getInventoryPath());

            double grandTotal = 0.0;

            // Process the sales data and calculate total price for each item
            for (SaleEntry sale : salesList) {
                String item = sale.item;
                int quantitySold = sale.quantity;
                String saleDate = sale.date;

                // Get item price from inventoryData
                Double unitPrice = inventoryData.get(item);
                if (unitPrice != null) {
                    double totalPrice = unitPrice * quantitySold;
                    grandTotal += totalPrice;

                    // Add the sale data to the table model
                    model.addRow(new Object[]{saleDate, item, quantitySold, unitPrice, String.format("%.2f", totalPrice)});
                }
            }

            // After processing all sales, add the Grand Total row to the table
            model.addRow(new Object[]{"Grand Total", "", "", "", String.format("%.2f", grandTotal)});

            // Save the report to salesreport.txt
            saveSalesReportToFile(salesList, inventoryData, grandTotal);

        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    // Method to read sales data from sales.txt and preserve the order
    private List<SaleEntry> readSalesData(String filePath) throws IOException {
        List<SaleEntry> salesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String date = data[0].trim(); // Get the date from the file
                    String item = data[1].trim();
                    int quantity = Integer.parseInt(data[2].trim());

                    // Add sales entry preserving the order
                    salesList.add(new SaleEntry(date, item, quantity));
                }
            }
        }

        // Sort sales list by date
        salesList.sort(Comparator.comparing(sale -> sale.date));

        return salesList;
    }

    // Method to read inventory data from inventory.txt
    private Map<String, Double> readInventoryData(String filePath) throws IOException {
        Map<String, Double> inventoryData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String itemCode = data[0].trim();
                    String itemName = data[1].trim();
                    double price = Double.parseDouble(data[4].trim());
                    inventoryData.put(itemName, price);
                }
            }
        }

        return inventoryData;
    }

    // Method to save the sales report to a text file
    private void saveSalesReportToFile(List<SaleEntry> salesList, Map<String, Double> inventoryData, double grandTotal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getSalesReportPath()))) {
            writer.write("Sales Report:\n\n");

            // Write column headers
            writer.write("Date, Item, Quantity Sold, Unit Price, Total Price\n");

            // Write the sales data
            for (SaleEntry sale : salesList) {
                String item = sale.item;
                int quantitySold = sale.quantity;
                Double unitPrice = inventoryData.get(item);
                if (unitPrice != null) {
                    double totalPrice = unitPrice * quantitySold;

                    // Write the sale data
                    writer.write(String.format("%s, %s, %d, %.2f, %.2f\n", sale.date, item, quantitySold, unitPrice, totalPrice));
                }
            }

            // Write the Grand Total row
            writer.write("\nGrand Total: " + String.format("%.2f", grandTotal));

        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    // Inner class to represent a sale entry
    private static class SaleEntry {
        String date;
        String item;
        int quantity;

        SaleEntry(String date, String item, int quantity) {
            this.date = date;
            this.item = item;
            this.quantity = quantity;
        }
    }
}
