package kiosk;

public class Item extends Menu {
    Double price;

    Item(String name, String description, Double price) {
        super(name, description);
        this.price = price;
    }
}
