package kiosk.domain;

public class Product extends Menu{
    private double price;

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
