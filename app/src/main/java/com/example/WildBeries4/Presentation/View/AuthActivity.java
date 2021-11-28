package com.example.WildBeries4.Presentation.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.WildBeries4.Domain.Model.UsersDTO;
import com.example.WildBeries4.Presentation.ViewModel.AuthActivityViewModel;
import com.example.WildBeries4.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class AuthActivity extends AppCompatActivity {

    private AuthActivityViewModel mAuthActivityViewModel;

    EditText etEmailLogin;
    EditText etPasswordLogin;
    ImageButton ibGoogleAuthorization;
    TextView tvRegistration;
    ImageButton ibtnLogin;

    UsersDTO usersDTO;

    LiveData<UsersDTO> userExist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etEmailLogin = findViewById(R.id.etEmailLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        ibGoogleAuthorization = findViewById(R.id.ibGoogleAuthorization);
        tvRegistration = findViewById(R.id.tvRegistration);
        ibtnLogin = findViewById(R.id.ibtnLogin);

        mAuthActivityViewModel = new AuthActivityViewModel(getApplication());

        ibtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailLogin.getText().toString();
                String password = etPasswordLogin.getText().toString();

                usersDTO = new UsersDTO();
                UsersDTO usersDTOFromDB = new UsersDTO();
                usersDTO.setEmail(email);
                usersDTO.setPassword(password);
                if (!email.isEmpty() && !password.isEmpty()) {
                    userExist = mAuthActivityViewModel.getUserByEmailAndPassword(email, password);
                    userExist.observe(AuthActivity.this, new Observer<UsersDTO>() {
                        @Override
                        public void onChanged(UsersDTO usersDTOs) {
                            if (usersDTOs != null){
                            usersDTOFromDB.email = usersDTOs.email;
                            usersDTOFromDB.password = usersDTOs.password;
                            usersDTOFromDB.role = usersDTOs.role;
                            if (!(usersDTOFromDB == null)) {
                                if (usersDTOFromDB.role.equals("User")) {
                                    Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                                    intent.putExtra("role", "User");
                                    startActivity(intent);
                                }
                                if (usersDTOFromDB.role.equals("Admin")) {
                                    Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                                    intent.putExtra("role", "Admin");
                                    startActivity(intent);
                                }
                                if (usersDTOFromDB.role.equals("GoogleUser")) {
                                    Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                                    intent.putExtra("role", "GoogleUser");
                                    startActivity(intent);
                                }
                            }
                            }
                            else {
                                Toast.makeText(AuthActivity.this, "Пароль или логин неправилен",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(AuthActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();

                }
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        ibGoogleAuthorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 200);
            }
        });

        tvRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            UsersDTO usersDTO1 = new UsersDTO("GoogleUser",account.getEmail(),account.getId(),account.getDisplayName(),account.getFamilyName());
            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            mAuthActivityViewModel.getUserByEmailAndRole(usersDTO1.email,usersDTO1.role).observe(AuthActivity.this, usersDTOs-> {
                    if (usersDTOs == null){
                        mAuthActivityViewModel.addUser(usersDTO1);
                    }
            });
            intent.putExtra("role", "GoogleUser");
            startActivity(intent);
        } catch (ApiException e) {
            Log.w("handleSignInResult", "signInResult:failed code=" + e);
            Toast.makeText(AuthActivity.this, "Регистрация не прошла", Toast.LENGTH_SHORT).show();
        }
    }

}