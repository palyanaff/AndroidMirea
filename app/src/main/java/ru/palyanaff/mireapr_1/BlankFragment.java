package ru.palyanaff.mireapr_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";
    private FragmentBlankBinding binding;
    List orderList;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        orderList = new ArrayList<String>();

        Button pizzaButton = view.findViewById(R.id.pizza_button);
        Button coffeeButton = view.findViewById(R.id.coffee_button);
        Button orderButton = view.findViewById(R.id.make_order_button);
        EditText editText = view.findViewById(R.id.editText_address);

        pizzaButton.setOnClickListener(v-> {
            Log.i(TAG, "Add pizza to basket");
            orderList.add(binding.pizzaName.getText().toString());
        });

        coffeeButton.setOnClickListener(v -> {
            Log.i(TAG, "Add coffee to basket");
            orderList.add(binding.coffeeName.getText().toString());
        });

        orderButton.setOnClickListener(v -> {
            Log.i(TAG, "BUTTON");
            Bundle bundle = new Bundle();
            bundle.putString("Order", orderList.toString());
            bundle.putString("Address", editText.getText().toString());
            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, BlankFragment2.class, bundle).commit();
            getParentFragmentManager().setFragmentResultListener("requestKey",
                    this, new FragmentResultListener() {
                        @Override
                        public void onFragmentResult(@NonNull String requestKey,
                                                     @NonNull Bundle bundle) {
                            String result = bundle.getString("bundleKey");
                            binding.orderList.setText(result);
                        }
                    });
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