package com.example.latihan3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Edit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText editTextNewName = findViewById(R.id.editusername);
        EditText editTextNewPassword = findViewById(R.id.editpassword);

        Button btnSubmitName = findViewById(R.id.btnSubmitName);

        btnSubmitName.setOnClickListener(view -> {
            String newName = editTextNewName.getText().toString();
            String newPassword = editTextNewPassword.getText().toString();

            Intent returnIntent = new Intent();
            returnIntent.putExtra("newName", newName);
            returnIntent.putExtra("newPassword", newPassword);
            setResult(RESULT_OK, returnIntent);
            finish();
        });


    }
}