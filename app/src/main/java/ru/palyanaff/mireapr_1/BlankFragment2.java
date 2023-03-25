package ru.palyanaff.mireapr_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.palyanaff.mireapr_1.databinding.FragmentBlank2Binding;
import ru.palyanaff.mireapr_1.databinding.FragmentBlankBinding;

public class BlankFragment2 extends Fragment {

    private static final String TAG = "BlankFragment2";
    FragmentBlank2Binding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentBlank2Binding.inflate(getLayoutInflater());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        String address = getArguments().getString("Address");
        String order = getArguments().getString("Order");
        TextView text = view.findViewById(R.id.text);
        Button deliverButton = view.findViewById(R.id.deliver_button);

        text.setText("Address: " + address + "\n" +
                "Order: " + order);

        deliverButton.setOnClickListener(v-> {
            Bundle result = new Bundle();
            result.putString("Order", order);
            getParentFragmentManager().setFragmentResult(
                    "requestKey", result);
        });
        return view;
    }
}