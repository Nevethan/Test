package com.example.bruger.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    FirebaseManager firebaseManager = new FirebaseManager();

    EditText mEditUsername, mEditPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditUsername = (EditText) findViewById(R.id.editUsername);
        mEditPassword = (EditText) findViewById(R.id.editPassword);
    }

    public void logIn(View view){

        String tempUsername = mEditUsername.getText().toString();
        String temPassword = mEditPassword.getText().toString();
        System.out.print("Hello");
        //System.out.print(tempUsername + temPassword);

        //System.out.print("Logged in");
        //firebaseManager.checkUserCredentials(tempUsername,temPassword);
        Intent intent = new Intent(this,Board.class);
        startActivity(intent);
    }
}
