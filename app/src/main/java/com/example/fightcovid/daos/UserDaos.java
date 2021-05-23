package com.example.fightcovid.daos;

import com.example.fightcovid.models.Users;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.Collection;

public class UserDaos {
    private FirebaseFirestore firestore=FirebaseFirestore.getInstance();
    private CollectionReference collection = firestore.collection("user");

    public void addUser(Users users){
        collection.document(users.getUid()).set(users);

    }
}
