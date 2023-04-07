package ru.palyanaff.mireapr_1;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.databinding.FragmentMenuBinding;


public class MenuFragment extends Fragment {
    private static final String TAG = "MenuFragment";
    private static String CHANNEL_ID = "Pizza order";
    private static final int NOTIFY_ID = 101;
    private FragmentMenuBinding binding;
    List orderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMenuBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        orderList = new ArrayList<String>();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        ArrayList<OrderItem> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            list.add(new OrderItem(R.drawable.coffee_latte, getString(R.string.latte),
                    getString(R.string.latte_description), getString(R.string.latte_price)));
            list.add(new OrderItem(R.drawable.pizza_pepperoni, getString(R.string.pepperoni),
                    getString(R.string.pizza_description), getString(R.string.price)));
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        MenuRecyclerAdapter adapter = new MenuRecyclerAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        Button makeOrderButton = view.findViewById(R.id.make_order_button);

        makeOrderButton.setOnClickListener(v -> {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Pizza Rest")
                    .setContentText("Make an Order")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
            if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                notificationManager.notify(NOTIFY_ID, builder.build());
            }


            Bundle bundle = new Bundle();
            bundle.putString("Order", orderList.toString());
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_blankFragment2, bundle);
        });

        return view;
    }

}