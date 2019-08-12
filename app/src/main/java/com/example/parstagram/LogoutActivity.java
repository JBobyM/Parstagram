package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class LogoutActivity extends AppCompatActivity {
    private ImageView ivHome;
    private ImageView ivNewPost;
    private ImageView ivUserLogout;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        ivHome= findViewById(R.id.ivHome);
        ivNewPost = findViewById(R.id.ivNewPost);
        ivUserLogout = findViewById(R.id.ivUserLogout);
        btnLogout=findViewById(R.id.btnLogout);



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                goLoginActivity(currentUser);
            }
        });

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        ivUserLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LogoutActivity.class);
                startActivity(i);
            }
        });

        ivNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewPostActivity.class);
                startActivity(i);
            }
        });

    }

    private void goLoginActivity(ParseUser currentUser) {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
