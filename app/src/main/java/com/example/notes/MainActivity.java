package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    public void clickFunction(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username);
        String username = usernameField.getText().toString();

        EditText passwordField = (EditText) findViewById(R.id.password);
        String password = passwordField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes",
                Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();

        goToWelcomeScreen(username);
    }

    public void goToWelcomeScreen(String username) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        intent.putExtra("message" ,"Welcome " + username);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            String username = sharedPreferences.getString(usernameKey, "");

            goToWelcomeScreen(username);
        }

        else {
            setContentView(R.layout.activity_main);
        }
    }
}