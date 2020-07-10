package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etSignUpUsername;
    private EditText etSignUpPassword;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etSignUpUsername = findViewById(R.id.etSignUpUsername);
        etSignUpPassword = findViewById(R.id.etSignUpPassword);
        btnSignUp = findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick sign up button");
                String username = etSignUpUsername.getText().toString();
                String password = etSignUpPassword.getText().toString();
                SigninUser(username, password);
            }
        });

    }

    private void SigninUser(String username, String password) {
        Log.i(TAG, "attempting to sign up user " + username);

        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    goMainActivity1();
                } else {
                    Log.e(TAG, "issue with sign up", e);
                    e.printStackTrace();
                    return;
                }
            }
        });

    }

    private void goMainActivity1() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}