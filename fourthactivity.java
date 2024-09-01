package com.example.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class fourthactivity extends AppCompatActivity {

private TextView Name,Email,password,showdate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourthactivity);
        Name = findViewById(R.id.showname);
        Email = findViewById(R.id.showemail);
        password = findViewById(R.id.showpassword);
        showdate = findViewById(R.id.showdate);
        String username = getIntent().getStringExtra("Keyname");
        String useremail = getIntent().getStringExtra("Keyemail");
        String userpass = getIntent().getStringExtra("Keypass");
        String userdate = getIntent().getStringExtra("Keydate");

        Name.setText("Your Name is: "+username);
        Email.setText("Your Email is: "+useremail);
        password.setText("Your Password is: "+userpass);
        showdate.setText("Your DateOfBirth is: "+userdate);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}