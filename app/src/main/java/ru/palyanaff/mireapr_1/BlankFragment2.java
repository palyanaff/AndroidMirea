package ru.palyanaff.mireapr_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        binding.text.setText("Address: " + address + "\n" +
                "Order: " + order);

        binding.deliverButton.setOnClickListener(v-> {
            Bundle bundle = new Bundle();
            bundle.putString("Address", address);
            bundle.putString("Order", order);
            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, BlankFragment.class, bundle);});
        return view;
    }
}