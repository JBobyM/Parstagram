package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private Button btnLog;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLog=findViewById(R.id.btnLogin);
        etUsername=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etpassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= etUsername.getText().toString();
                String password = etPassword.getText().toString();
                sigin(username, password);

            }
        });

    }

    private void sigin(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e!=null){
                    Log.d(TAG, "Sign Up didn't succeed!");
                    e.printStackTrace();

                }
                else {
                    goMainActivity();

                }



            }
        });

    }

    private void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Log.d(TAG, "Issue with login");
                e.printStackTrace();
                return;
                }
                goMainActivity();

            }
        });


    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }
}
