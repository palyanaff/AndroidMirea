package ru.palyanaff.mireapr_1.ui.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.data.datasource.MenuSource;
import ru.palyanaff.mireapr_1.data.model.OrderItem;
import ru.palyanaff.mireapr_1.ui.view_model.OrderViewModel;
import ru.palyanaff.mireapr_1.R;
import ru.palyanaff.mireapr_1.databinding.FragmentMenuBinding;
import ru.palyanaff.mireapr_1.ui.adapter.MenuRecyclerAdapter;


public class MenuFragment extends Fragment {
    private static final String TAG = "MenuFragment";
    private static String CHANNEL_ID = "Pizza order";
    private static final int NOTIFY_ID = 101;
    private FragmentMenuBinding binding;
    OrderViewModel orderViewModel;
    List orderList;

    public MenuFragment() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMenuBinding.inflate(getLayoutInflater());
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        orderList = new ArrayList<OrderItem>();

        RecyclerView recyclerView = view.findViewById(R.id.menu_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        MenuRecyclerAdapter adapter = new MenuRecyclerAdapter(getActivity(), MenuSource.initMenu().getValue());
        recyclerView.setAdapter(adapter);

        Button makeOrderButton = view.findViewById(R.id.make_order_button);
        EditText editText = view.findViewById(R.id.editText_address);


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
            bundle.putString("Address", editText.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_blankFragment2, bundle);
        });

        return view;
    }

}