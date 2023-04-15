package ru.palyanaff.mireapr_1.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.palyanaff.mireapr_1.MyService;
import ru.palyanaff.mireapr_1.R;
import ru.palyanaff.mireapr_1.data.datasource.MenuSource;
import ru.palyanaff.mireapr_1.ui.adapter.MenuRecyclerAdapter;
import ru.palyanaff.mireapr_1.ui.adapter.OrderRecyclerAdapter;
import ru.palyanaff.mireapr_1.ui.view_model.OrderViewModel;

public class OrderFragment extends Fragment {
    OrderViewModel orderViewModel;
    private static final String TAG = "OrderFragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        Button deliverButton = view.findViewById(R.id.deliver_button);
        TextView addressText = view.findViewById(R.id.order_address);

        RecyclerView recyclerView = view.findViewById(R.id.order_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        OrderRecyclerAdapter adapter = new OrderRecyclerAdapter(getActivity(), orderViewModel.orderList.getValue());
        recyclerView.setAdapter(adapter);

        addressText.setText(getArguments().get("Address").toString());

        deliverButton.setOnClickListener(v-> {
            Intent intent = new Intent(view.getContext(), MyService.class);
            getContext().startService(intent);
            Bundle bundle = new Bundle();
            Navigation.findNavController(v).navigate(R.id.action_blankFragment2_to_menuFragment);
        });
        orderViewModel.orderList.observe(getViewLifecycleOwner(), orderItems -> adapter.updateOrderList(orderItems));
        return view;
    }
}