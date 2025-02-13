package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    // SharedPreferences file name
    private static final String PREFS_NAME = "MyPrefsFile";
    Button btnLogin;
    EditText txtUsername, txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get SharedPreferences object
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        txtUsername = findViewById(R.id.txtUsername);
        txtpassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // menyimpan sharedpreference


//                String username = txtUsername.getText().toString();
//                String password = txtpassword.getText().toString();
//                if (username.equals("admin") && password.equals("admin")) {
//                    editor.putString("username", txtUsername.getText().toString());
//                    editor.apply();
//                    Intent intent = new Intent(MainActivity.this, api_pertama.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(MainActivity.this, "Gagal Login", Toast.LENGTH_LONG).show();
//                }

                editor.putString("username", txtUsername.getText().toString());
                editor.apply();

                // intent ke home
                Intent intent = new Intent(MainActivity.this, navigasi_bottom.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
