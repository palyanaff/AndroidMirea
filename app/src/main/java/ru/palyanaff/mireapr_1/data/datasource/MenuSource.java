package ru.palyanaff.mireapr_1.data.datasource;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.R;
import ru.palyanaff.mireapr_1.data.model.OrderItem;

public class MenuSource {
    public static MutableLiveData<List<OrderItem>> initMenu(){
        MutableLiveData<List<OrderItem>> list = new MutableLiveData<>();
        ArrayList<OrderItem> orderList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            orderList.add(new OrderItem(R.drawable.coffee_latte, R.string.latte,
                    R.string.latte_description, 10));
            orderList.add(new OrderItem(R.drawable.pizza_pepperoni, R.string.pepperoni,
                    R.string.pizza_description, 300));
            orderList.add(new OrderItem(R.drawable.sushi, R.string.sushi_name,
                    R.string.sushi_description, 50));
        }
        list.setValue(orderList);
        return list;
    }
}
