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

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, BlankFragment.class, null)
                    .commit();
        }

        /**/

    }

   /* public void goToBasket(View view) {
        Log.i(TAG, "Button click");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Order", orderList.toString());
        intent.putExtra("Address", binding.editTextAddress.getText().toString());
        startActivity(intent);
    }*/

}