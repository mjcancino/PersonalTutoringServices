package com.example.personaltutoringservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private TextView textViewForgotPassword;
    private com.google.android.material.button.MaterialButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        
        // Initialize UI elements
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        textViewForgotPassword = findViewById(R.id.forgotpass);
        buttonLogin = findViewById(R.id.loginbtn);

        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle login button click
                performLogin();

            }
        });
        
        // Set click listener for the "Forgot password?" text
        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle forgot password text click
                showForgotPasswordDialog();
            }
        });

        // Initialize and set click listener for the "Register New User" text
        TextView registerTextView = findViewById(R.id.register);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the RegistrationActivity when the text is clicked
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void performLogin() {
        // Retrieve username and password from EditText fields
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // TODO: Implement your authentication logic here
        // For demo purposes, checking if fields are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            // Successful login, navigate to HomeActivity
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            performLogin();
            finish(); // Optional: Finish the MainActivity so it's not in the back stack
        } else {
            // Display an error message if fields are empty
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
        }
    }

    private void showForgotPasswordDialog() {
        // TODO: Implement your logic for handling forgot password action
        // For demo purposes, showing a toast message
        Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
    }
}
