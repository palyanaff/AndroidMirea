package ru.palyanaff.mireapr_1.data.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import ru.palyanaff.mireapr_1.data.datasource.MenuSource;
import ru.palyanaff.mireapr_1.data.model.OrderItem;

public class OrderRepository {
    private LiveData<List<OrderItem>> order;

    public OrderRepository() {
        order = MenuSource.initMenu();
    }

    public LiveData<List<OrderItem>> getOrders() {
        return order;
    }
}
