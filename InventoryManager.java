import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    
    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "inventory.txt";

    public static void main(String[] args) {
        loadData(); // Loads existing data when the program starts
        int choice = 0;
        
        while (choice != 5) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Calculate Total Stock Value");
            System.out.println("5. Save Products to File and Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) addProduct();
                else if (choice == 2) displayAll();
                else if (choice == 3) searchById();
                else if (choice == 4) calculateTotal();
                else if (choice == 5) {
                    saveData();
                    System.out.println("Data saved. Exiting program...");
                }
                else System.out.println("Invalid choice. Please try again.");

            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    static void addProduct() {
        try {
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Quantity: ");
            int qty = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            inventory.add(new Product(id, name, qty, price));
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println("Input error. Please try again.");
        }
    }

    static void displayAll() {
        if (inventory.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product p : inventory) {
            p.showProduct();
        }
        System.out.println("-------------------------"); // Closes the bottom of the list cleanly
    }

    static void searchById() {
        System.out.print("Enter Product ID to Search in the inventory: ");
        try {
            int searchId = Integer.parseInt(sc.nextLine());
            boolean found = false;
            for (Product p : inventory) {
                if (p.getId() == searchId) {
                    p.showProduct(true);
                    System.out.println("-------------------------");
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Product not found.");
        } catch (Exception e) {
            System.out.println("Invalid ID format.");
        }
    }

    static void calculateTotal() {
        double total = 0;
        for (Product p : inventory) {
            total += (p.getQuantity() * p.getPrice());
        }
        System.out.println("Total Stock Value: " + total);
    }

    // --- FILE HANDLING METHODS ---

    static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : inventory) {
                String line = p.getId() + "," + p.getName() + "," + p.getQuantity() + "," + p.getPrice();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    static void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; 

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int qty = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    inventory.add(new Product(id, name, qty, price));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }
}