package Sales_Manager;

import Main.Config;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class Sales {
    private JTable tblDailySales;

    public JTable getTblDailySales() {
        return tblDailySales;
    }

    public void setTblDailySales(JTable tblDailySales) {
        this.tblDailySales = tblDailySales;
    }

    public Sales(JTable tblDailySales) {
        this.tblDailySales = tblDailySales;
    }

    // Load data from Sales.txt into the JTable, skipping the first line (header)
    public void loadDailySales() {
        DefaultTableModel model = (DefaultTableModel) tblDailySales.getModel();
        model.setRowCount(0); // Clear existing data in the table

        try (BufferedReader reader = new BufferedReader(new FileReader(Config.getSalesPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip any empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] salesData = line.split(",");
                model.addRow(salesData); // Add the sales data as a new row in the table
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }


    // Method to validate the quantity input
    private boolean isValidQuantity(String quantity) {
        try {
            int qty = Integer.parseInt(quantity);
            return qty > 0; // Quantity must be a positive number
        } catch (NumberFormatException e) {
            return false; // Invalid input if it's not a number
        }
    }

    // Method to add a new sale
    // Method to add a new sale
    public void addSale(String date, String itemName, String quantity) {
        if (!isValidQuantity(quantity)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid positive number for Quantity.");
            return; // Stop execution if the quantity is invalid
        }

        DefaultTableModel model = (DefaultTableModel) tblDailySales.getModel();

        // Check if the sale already exists (to avoid duplicate entries)
        boolean alreadyExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String existingDate = (String) model.getValueAt(i, 0);
            String existingItem = (String) model.getValueAt(i, 1);
            String existingQuantity = (String) model.getValueAt(i, 2);

            if (existingDate.equals(date) && existingItem.equals(itemName) && existingQuantity.equals(quantity)) {
                alreadyExists = true;
                break;
            }
        }

        // If sale doesn't exist, add to table and file
        if (!alreadyExists) {
            model.addRow(new Object[]{date, itemName, quantity}); // Add new row to the table

            // Try to append the new sale to the Sales.txt file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getSalesPath(), true))) {
                System.out.println("Appending sale to file...");
                writer.write(date + "," + itemName + "," + quantity);
                writer.newLine(); // Move to the next line
                writer.flush(); // Ensure the writer is flushed and data is written
                System.out.println("Sale added to Sales.txt");

            } catch (IOException ex) {
                System.out.println("Error writing to file: " + ex.getMessage());
            }

            // Update the sales report after adding a sale
            updateSalesReport();

        } else {
            JOptionPane.showMessageDialog(null, "Sale already exists for this date, item, and quantity.");
        }
    }



    // Method to edit a sale
    public void editSale(int rowIndex, String date, String itemName, String quantity) {
        if (!isValidQuantity(quantity)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid positive number for Quantity.");
            return; // Stop execution if the quantity is invalid
        }

        DefaultTableModel model = (DefaultTableModel) tblDailySales.getModel();
        model.setValueAt(date, rowIndex, 0); // Update the date in the selected row
        model.setValueAt(itemName, rowIndex, 1); // Update the item name in the selected row
        model.setValueAt(quantity, rowIndex, 2); // Update the quantity in the selected row

        // Rewrite the entire Sales.txt file with updated data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getSalesPath()))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String rowData = model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2);
                writer.write(rowData);
                writer.newLine(); // Move to the next line
            }
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }

        // Update the sales report after editing a sale
        updateSalesReport();
    }

    // Method to delete a sale
    public void deleteSale(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) tblDailySales.getModel();

        // Remove the selected row from the table
        model.removeRow(rowIndex);

        // Rewrite the entire Sales.txt file without the deleted row
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getSalesPath()))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String rowData = model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2);
                writer.write(rowData);
                writer.newLine(); // Move to the next line
            }
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }

        // Update the sales report after deleting a sale (ensure this is using the latest Sales.txt data)
        updateSalesReport();
}



    // Method to update the sales report
    private void updateSalesReport() {
        DefaultTableModel model = (DefaultTableModel) tblDailySales.getModel();
        double grandTotal = 0.0;

        // Prepare a temporary buffer to write the report
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.getSalesReportPath()))) {
            writer.write("Sales Report:\n");
            writer.write("Date        Item        Quantity    Unit Price    Total Price\n");

            // Process each row in the table and calculate the total price
            for (int i = 0; i < model.getRowCount(); i++) {
                String date = (String) model.getValueAt(i, 0);
                String item = (String) model.getValueAt(i, 1);
                int quantity = Integer.parseInt((String) model.getValueAt(i, 2)); // Assuming quantity is stored as a String
                double unitPrice = 10.0; // Set a default unit price, or retrieve it based on your application logic
                double totalPrice = quantity * unitPrice;

                // Update the grand total
                grandTotal += totalPrice;

                writer.write(String.format("%-12s %-12s %-10d %-12.2f %-12.2f\n", date, item, quantity, unitPrice, totalPrice));
            }

            // Write the Grand Total
            writer.write("\nGrand Total: " + grandTotal);

        } catch (IOException ex) {
            System.out.println("Error writing to report file: " + ex.getMessage());
        }
    }
}
