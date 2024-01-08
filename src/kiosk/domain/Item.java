package kiosk.domain;

public class Item extends Menu{
    private double price;

    public Item(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
