package ru.palyanaff.mireapr_1;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.palyanaff.mireapr_1.databinding.FragmentBlank2Binding;

public class BlankFragment2 extends Fragment {

    private static final String TAG = "BlankFragment2";
    private static String CHANNEL_ID = "Pizza order";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharSequence name = "Channel 2";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        Button deliverButton = view.findViewById(R.id.deliver_button);
        TextView textView = view.findViewById(R.id.text);

        textView.setText(getArguments().get("Order").toString());
        deliverButton.setOnClickListener(v-> {
            Intent intent = new Intent(view.getContext(), MyService.class);
            getContext().startService(intent);
            Bundle bundle = new Bundle();
            bundle.putString("Address", "New address");
            Navigation.findNavController(v).navigate(R.id.action_blankFragment2_to_menuFragment);
        });
        return view;
    }
}