package com.example.bruger.test;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruger on 29-11-2018.
 */

public class FirebaseManager {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRefEstablishments = database.getReference("Establishments");
    DatabaseReference myRefUsers = database.getReference("Users");
    DatabaseReference myRefPosts = database.getReference("Posts");

    List<Establishment> establishmentsList = new ArrayList<>();
    List<Post> postsList = new ArrayList<>();

    public void checkLogInCredentials(final String username, final String password){
        myRefUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user = ds.getValue(User.class);
                    System.out.println(user);

                    //Think I can invoke this: "String tempUsername = user.getUsername();
                    //These variables will be the username and password from firebase
                    String tempUsername = "";
                    String tempPassword = "";

                    if (doesExist(username, tempUsername)) {
                        checkPassword(password, tempPassword);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void checkRegisterCredentials(final String username, final String password){
        myRefUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    User user = ds.getValue(User.class);
                    System.out.println(user);

                    //Think I can invoke this: "String tempUsername = user.getUsername();
                    //These variables will be the username and password from firebase
                    String tempUsername = "";
                    String tempPassword = "";

                    if (!doesExist(username, tempUsername)) {
                        addNewUser(username,password);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public List<Post> getAllPosts(){
        myRefPosts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Post p = ds.getValue(Post.class);
                    postsList.add(p);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return postsList;
    }

    public List<Establishment> getAllEstablishments(){
        myRefEstablishments.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Establishment e = ds.getValue(Establishment.class);
                    establishmentsList.add(e);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return establishmentsList;
    }

    private void addNewUser(String username, String password){
        User newUser = new User(username,password);

        myRefUsers.setValue(newUser);
    }

    private boolean doesExist(String givenUsername, String firebaseUsername){
        if(givenUsername.equals(firebaseUsername)){
            return true;
        }else
            return false;
    }

    private boolean checkPassword(String givenPassword, String firebasePassword){
        if(givenPassword.equals(firebasePassword)){
            return true;
        }else
            return false;
    }
}
