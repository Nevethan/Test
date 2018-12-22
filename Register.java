package com.example.bruger.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    EditText registerUsername, registerPassword;

    DataManager dataManager = DataManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsername = (EditText) findViewById(R.id.editTextUsernameRegister);
        registerPassword = (EditText) findViewById(R.id.editTextPasswordRegister);


    }

    public void registerNewUsername(View view){
        String username = registerUsername.getText().toString();
        String password = registerPassword.getText().toString();

        boolean checkIfUserExits = dataManager.checkRegisterCredentials(username, password);

        if(checkIfUserExits){
            Toast.makeText(this, "Username already exists. Please try again", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this,Board.class);
            intent.putExtra("category", "All");
            startActivity(intent);
        }
    }
}
