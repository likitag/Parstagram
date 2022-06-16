package com.example.parstagram;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;
    //private EditText etEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(ParseUser.getCurrentUser()!=null){
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        //etEmail = findViewById(R.id.etEmail);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
                finish();
            }
        });

//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "onClick sign up button");
//                ParseUser user = new ParseUser();
//                user.setUsername(etUsername.getText().toString());
//                user.setPassword(etPassword.getText().toString());
//                user.setEmail(etEmail.getText().toString());
//                user.signUpInBackground(new SignUpCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if (e != null) {
//                            loginUser(etUsername.getText().toString(), etPassword.getText().toString());
//                            // Hooray! Let them use the app now.
//                        } else {
//                            Log.e(TAG, "login didnt work", e);
//                            // Sign up didn't succeed. Look at the ParseException
//                            // to figure out what went wrong
//                        }
//
//
//                    }
//                });
//            }
//        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);

            }
        });
    }

    private void loginUser(String username, String password) {
        //navigate to main activity if user has signed in properly
        Log.i(TAG, "attempting to login user: " +username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Log.e(TAG, "Issue with login", e);
                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}