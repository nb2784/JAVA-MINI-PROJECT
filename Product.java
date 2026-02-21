public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product() {
        this.id = 0;
        this.name = "No Name";
        this.quantity = 0;
        this.price = 0.0;
    }

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Updated to perfectly match the vertical format in the screenshot
    public void showProduct() {
        System.out.println("-------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Stock Value: " + (quantity * price));
    }

    // Overloaded method for the search function
    public void showProduct(boolean isSearch) {
        if (isSearch) {
            System.out.println("Product found:");
        }
        showProduct(); 
    }
}