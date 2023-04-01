package ru.palyanaff.mireapr_1;

import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.databinding.FragmentBlank2Binding;
import ru.palyanaff.mireapr_1.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";
    private static String CHANNEL_ID = "Pizza order";
    private static final int NOTIFY_ID = 101;
    private FragmentBlankBinding binding;
    List orderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentBlankBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        orderList = new ArrayList<String>();

        Button makeOrderButton = view.findViewById(R.id.make_order_button);
        Button pizzaButton = view.findViewById(R.id.pizza_button);
        Button coffeeButton = view.findViewById(R.id.coffee_button);

        coffeeButton.setOnClickListener(v -> {
            orderList.add(binding.coffeeName.getText().toString());
        });

        pizzaButton.setOnClickListener(v -> {
            orderList.add(binding.pizzaName.getText().toString());
        });

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
            Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment2, bundle);
        });

        return view;
    }

}