package ru.palyanaff.mireapr_1;

public class OrderItem {
    private final int image;
    private final String header;
    private final String description;
    //TODO: refactor cost to String
    private final String cost;

    public OrderItem(int image, String header, String description, String cost) {
        this.image = image;
        this.header = header;
        this.description = description;
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public String getCost() {
        return cost;
    }
}
