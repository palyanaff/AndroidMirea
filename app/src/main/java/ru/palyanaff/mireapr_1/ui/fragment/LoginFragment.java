package ru.palyanaff.mireapr_1.ui.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.palyanaff.mireapr_1.R;
import ru.palyanaff.mireapr_1.data.entity.UserEntity;
import ru.palyanaff.mireapr_1.data.repository.UserRepository;
import ru.palyanaff.mireapr_1.ui.view_model.LoginViewModel;

public class LoginFragment extends Fragment {
    private LoginViewModel loginViewModel;
    private UserRepository userRepository;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new LoginViewModel();
        userRepository = new UserRepository(getContext());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button loginButton = view.findViewById(R.id.login_button);
        EditText loginEditText = view.findViewById(R.id.login_edit_text);
        EditText addressEditText = view.findViewById(R.id.address_edit_text);

        loginButton.setOnClickListener(v -> {
            String login = loginEditText.getText().toString();
            String address = addressEditText.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("Login", login);
            bundle.putString("Address", address);
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_orderFragment, bundle);

            loginViewModel.setAddress(getContext(), "UserEntity", address);
            loginViewModel.setAddressToDb(login, address);
        });

        return view;
    }
}