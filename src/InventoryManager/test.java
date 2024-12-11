/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;
import assignmentdecsix.Config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class test {
    private static final String[] TEST_FILES = {
        Config.getInventoryPath(),
        Config.getSupplierPath(),
        Config.getSuppliedItemsPath(),
        Config.getAddStockPath()
    };
    
    public static void main(String[] args) {
        System.out.println("=== File Path Testing ===\n");
        
        // Print working directory
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        
        // Test each file
        for (String fileName : TEST_FILES) {
            testFile(fileName);
            testFile("./" + fileName);
            testFile("../" + fileName);
            System.out.println();
        }
        
        // Test creating and writing to a file
        testFileOperations("test_file.txt");
    }
    
    private static void testFile(String filePath) {
        File file = new File(filePath);
        System.out.println("\nTesting path: " + filePath);
        System.out.println("Absolute path: " + file.getAbsolutePath());
        try {
            System.out.println("Canonical path: " + file.getCanonicalPath());
        } catch (IOException e) {
            System.out.println("Error getting canonical path: " + e.getMessage());
        }
        System.out.println("File exists: " + file.exists());
        if (file.exists()) {
            System.out.println("Is readable: " + file.canRead());
            System.out.println("Is writable: " + file.canWrite());
            System.out.println("File size: " + file.length() + " bytes");
        }
    }
    
    private static void testFileOperations(String fileName) {
        System.out.println("\n=== Testing File Operations ===");
        try {
            // Create test content
            List<String> content = Arrays.asList("Test line 1", "Test line 2");
            
            // Write to file
            Path filePath = Paths.get(fileName);
            Files.write(filePath, content);
            System.out.println("Successfully wrote to test file: " + fileName);
            
            // Read from file
            List<String> readContent = Files.readAllLines(filePath);
            System.out.println("Successfully read from test file:");
            readContent.forEach(line -> System.out.println("> " + line));
            
            // Clean up
            Files.delete(filePath);
            System.out.println("Successfully deleted test file");
            
        } catch (IOException e) {
            System.err.println("Error during file operations: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
