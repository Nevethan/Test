package com.example.bruger.test;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //FirebaseManager firebaseManager = new FirebaseManager();
    DataManager dataManager = DataManager.getInstance();

    EditText mEditUsername, mEditPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditUsername = (EditText) findViewById(R.id.editUsername);
        mEditPassword = (EditText) findViewById(R.id.editPassword);

        initiateData();
    }

    public void logIn(View view){

        String tempUsername = mEditUsername.getText().toString();
        String tempPassword = mEditPassword.getText().toString();

        boolean checkUsername = dataManager.checkUserCredentials(tempUsername, tempPassword);

        if(checkUsername){
            Intent intent = new Intent(this,Board.class);

            startActivity(intent);
        }else{
            Toast.makeText(this,"The user credentials are wrong. Please try again", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    private void initiateData(){
        dataManager.getEstablishments();
        dataManager.getPosts();
    }

}
