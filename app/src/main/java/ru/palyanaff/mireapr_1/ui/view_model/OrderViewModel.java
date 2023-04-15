package ru.palyanaff.mireapr_1.ui.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.palyanaff.mireapr_1.data.model.OrderItem;
import ru.palyanaff.mireapr_1.data.repository.OrderRepository;

public class OrderViewModel extends ViewModel {
    public LiveData<List<OrderItem>> orderList;
    private OrderRepository repository = new OrderRepository();

    public OrderViewModel() {
        initIt();
    }

    public void initIt(){
        orderList = repository.getOrders();
    }
}
