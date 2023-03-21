package ru.palyanaff.mireapr_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";
    FragmentBlankBinding binding;
    List orderList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        orderList = new ArrayList<String>();

        binding.pizzaButton.setOnClickListener(v-> {
            Log.i(TAG, "Add pizza to basket");
            orderList.add(binding.pizzaName.getText().toString());
        });

        binding.coffeeButton.setOnClickListener(v -> {
            Log.i(TAG, "Add coffee to basket");
            orderList.add(binding.coffeeName.getText().toString());
        });

        binding.makeOrderButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("Order", orderList.toString());
            bundle.putString("Address", binding.editTextAddress.getText().toString());
            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, BlankFragment2.class, bundle).commit();
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreateView");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSaveInstanceState");
    }
}