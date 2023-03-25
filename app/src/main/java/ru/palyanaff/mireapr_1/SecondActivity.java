package ru.palyanaff.mireapr_1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private ActivitySecondBinding binding;
    Bundle arguments;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle arguments = getIntent().getExtras();
        binding.text.setText("Address: " + arguments.get("Address").toString() + "\n" +
                "Order: " + arguments.get("Order").toString());




        binding.deliverButton.setOnClickListener(v-> {
            Intent intent = new Intent();
            intent.putExtra("Order", arguments.get("Order").toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }


}