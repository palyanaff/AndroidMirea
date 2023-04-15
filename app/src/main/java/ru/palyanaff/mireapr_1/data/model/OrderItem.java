package ru.palyanaff.mireapr_1.data.model;

public class OrderItem {
    private final int image;
    private final int header;
    private final int description;
    //TODO: refactor cost to Integer
    private final int cost;

    public OrderItem(int image, int header, int description, int cost) {
        this.image = image;
        this.header = header;
        this.description = description;
        this.cost = cost;
    }

    public int getImageResource() {
        return image;
    }

    public int getHeaderResource() {
        return header;
    }

    public int getDescriptionResource() {
        return description;
    }

    public int getCost() {
        return cost;
    }
}
