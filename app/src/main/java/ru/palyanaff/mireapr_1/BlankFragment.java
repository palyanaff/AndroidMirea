package ru.palyanaff.mireapr_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import ru.palyanaff.mireapr_1.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";
    private FragmentBlankBinding binding;
    List orderList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        orderList = new ArrayList<String>();
        Button orderButton = view.findViewById(R.id.make_order_button);


        orderButton.setOnClickListener(v -> {
            Log.i(TAG, "BUTTON");
            Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment2);
        });

        return view;
    }

}