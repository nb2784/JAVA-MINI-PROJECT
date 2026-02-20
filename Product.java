public class Product {
    // Private variables for Encapsulation
    private int id;
    private String name;
    private int quantity;
    private double price;

    // Default Constructor
    public Product() {
        this.id = 0;
        this.name = "No Name";
        this.quantity = 0;
        this.price = 0.0;
    }

    // Parameterized Constructor
    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters so other classes can read the data safely
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Method Overloading 1: Just show basic details
    public void showProduct() {
        System.out.println("ID: " + id + " | Name: " + name + " | Qty: " + quantity + " | Price: Rs." + price);
    }

    // Method Overloading 2: Show details AND calculate the total value for this specific item
    public void showProduct(boolean showValue) {
        showProduct(); // calls the first method
        if (showValue) {
            System.out.println("   -> Total Value: Rs." + (quantity * price));
        }
    }
}