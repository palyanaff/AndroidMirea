package ru.palyanaff.mireapr_1.data.model;

import java.util.List;

public class Order {
    private List<OrderItem> list;
    private String address;
    private int cost;

    public Order(List<OrderItem> list, String address){
        this.list = list;
        this.address = address;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrderItem(OrderItem orderItem){
        list.add(orderItem);
    }

    public int getCost() {
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).getCost();
        }
        return res;
    }

    public void removeOrderItem(int index){
        list.remove(index);
    }

    public void clearOrder(){
        list.clear();
    }
}
