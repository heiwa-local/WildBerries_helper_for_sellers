package com.example.WildBeries4.Presentation.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.WildBeries4.Domain.Model.UsersDTO;
import com.example.WildBeries4.Presentation.ViewModel.RegisterActivityViewModel;
import com.example.WildBeries4.R;

public class RegisterActivity extends AppCompatActivity {

    EditText etFirstNameRegister;
    EditText etSecondNameRegister;
    EditText etEmailRegister;
    EditText etPasswordRegister;
    ImageButton ibRegistartion;

    UsersDTO usersDTO;

    RegisterActivityViewModel mRegisterActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstNameRegister = findViewById(R.id.etFirstNameRegister);
        etSecondNameRegister = findViewById(R.id.etSecondNameRegister);
        etEmailRegister = findViewById(R.id.etEmailRegister);
        etPasswordRegister = findViewById(R.id.etPasswordRegister);

        ibRegistartion = findViewById(R.id.ibRegistartion);


        ibRegistartion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRegisterActivityViewModel = new RegisterActivityViewModel(getApplication());
//                usersDTO = new UsersDTO(etFirstNameRegister.getText().toString(),etSecondNameRegister.getText().toString(),etSecondNameRegister.getText().toString(),etPasswordRegister.getText().toString());
                String firstName = etFirstNameRegister.getText().toString();
                String secondName = etSecondNameRegister.getText().toString();
                String email = etEmailRegister.getText().toString();
                String password = etPasswordRegister.getText().toString();
//
//                usersDTO.firstName = firstName;
//                usersDTO.setSecondName(secondName);
//                usersDTO.setEmail(email);
//                usersDTO.setPassword(password);
                UsersDTO usersDTO = new UsersDTO("User",email,password,firstName,secondName);
                mRegisterActivityViewModel.addUser(usersDTO);
                Intent intent = new Intent(RegisterActivity.this,AuthActivity.class);
                startActivity(intent);
            }
        });

    }
}