package com.example.login;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Date;

public class thirdactivity extends AppCompatActivity {
EditText name,emailadd,password,DateofBirth;
private Button Sigup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thirdactivity);
        name = findViewById(R.id.name);
        emailadd = findViewById(R.id.emailadd);
        password = findViewById(R.id.password);
        DateofBirth = findViewById(R.id.DateofBirth);
        Sigup = findViewById(R.id.button);
        final Calendar calendar = Calendar.getInstance();
        final int[] year = {calendar.get(Calendar.YEAR)};
        final int[] month = {calendar.get(Calendar.MONTH)};
        final int[] day = {calendar.get(Calendar.DAY_OF_MONTH)};
        Sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nametext = name.getText().toString();
                String Emailtext = emailadd.getText().toString();
                String passtext = password.getText().toString();
                String datetext = DateofBirth.getText().toString();
                Intent intent = new Intent(thirdactivity.this,fourthactivity.class);
                intent.putExtra("Keyname",Nametext);
                intent.putExtra("Keyemail", Emailtext);
                intent.putExtra("Keypass", passtext);
                intent.putExtra("Keydate", datetext);
                startActivity(intent);
            }
        });
        DateofBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(thirdactivity.this, "again click on this ", Toast.LENGTH_SHORT).show();
                DatePickerDialog dialog = new DatePickerDialog(thirdactivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    month[0]++;
                    String date = day[0] +"/"+ month[0] +"/"+ year[0];
                    DateofBirth.setText(date);
                    }
                }, year[0], month[0], day[0]);
                dialog.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}