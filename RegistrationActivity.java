package com.example.personaltutoringservice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextUsername, editTextPassword;
    private CheckBox checkBoxAge;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Find views by their IDs
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        checkBoxAge = findViewById(R.id.checkbox);
        registerButton = findViewById(R.id.Registerbtn);

        // Set click listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle registration logic
                if (validateInputs()) {
                    // Your registration logic goes here
                    // For demonstration purposes, a toast message is shown
                    Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Validate user inputs (you can add more validation as needed)
    private boolean validateInputs() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Additional validation, e.g., check if the user is 18 or older
        if (!checkBoxAge.isChecked()) {
            Toast.makeText(this, "You must be 18 years or older", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Add more validation as needed

        return true;
    }
}