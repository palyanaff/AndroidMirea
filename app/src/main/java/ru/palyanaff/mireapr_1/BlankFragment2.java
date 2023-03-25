package ru.palyanaff.mireapr_1;

import android.annotation.SuppressLint;
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
import ru.palyanaff.mireapr_1.databinding.FragmentBlankBinding;

public class BlankFragment2 extends Fragment {

    private static final String TAG = "BlankFragment2";
    FragmentBlank2Binding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentBlank2Binding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        Button deliverButton = view.findViewById(R.id.deliver_button);

        deliverButton.setOnClickListener(v-> {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment);
        });
        return view;
    }
}