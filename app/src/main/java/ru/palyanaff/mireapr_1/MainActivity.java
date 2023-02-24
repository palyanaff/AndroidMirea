package ru.palyanaff.mireapr_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.palyanaff.mireapr_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private List orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        orderList = new ArrayList<String>();

        binding.pizzaButton.setOnClickListener(view -> {
            Log.i(TAG, "Add pizza to basket");
            orderList.add(binding.pizzaName.getText().toString());
        });

        binding.coffeeButton.setOnClickListener(view -> {
            Log.i(TAG, "Add coffee to basket");
            orderList.add(binding.coffeeName.getText().toString());
        });

        Log.i(TAG, "Create");
        Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();
    }

    public void addToBasket(View view) {
        Log.i(TAG, "Button click");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Order", orderList.toString());
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Start");
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Pause");
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stop");
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Resume");
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroy");
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Restart");
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();
    }
}