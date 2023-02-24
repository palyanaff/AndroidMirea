package ru.palyanaff.mireapr_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.palyanaff.mireapr_1.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private ActivitySecondBinding binding;
    Bundle arguments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle arguments = getIntent().getExtras();

        binding.text.setText("Your order: " + arguments.get("Order").toString());
    }
}