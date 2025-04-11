package com.aiyu.furniture.core.database.interaction;


import com.aiyu.furniture.core.database.model.FurnitureModel;
import com.aiyu.furniture.core.database.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.inject.Inject;


public class FirebaseInteraction {

    private static final String TAG = "FirebaseInteraction";

    private static final String USER_DATABASE_PATH = "User";
    private final FirebaseFirestore firebaseFirestore;
    private final FirebaseAuth firebaseAuth;

    @Inject
    public FirebaseInteraction(FirebaseFirestore firebaseFirestore, FirebaseAuth firebaseAuth) {
        this.firebaseFirestore = firebaseFirestore;
        this.firebaseAuth = firebaseAuth;
    }


    public void insertUser(User user, Consumer<Exception> onUserAdded) {
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(user.getUid());
        ref.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                onUserAdded.accept(null);
            } else {
                addUserToDatabase(user, onUserAdded, ref);
            }
        }).addOnFailureListener(e -> addUserToDatabase(user, onUserAdded, ref));
    }

    private static void addUserToDatabase(User user, Consumer<Exception> onUserAdded, DocumentReference ref) {
        ref.set(user).addOnSuccessListener(aVoid -> {
            onUserAdded.accept(null);
        }).addOnFailureListener(onUserAdded::accept);
    }

    public void getUser(BiConsumer<User, Exception> onUserRetrieved) {
        if (firebaseAuth.getUid() == null) {
            onUserRetrieved.accept(null, new Exception("User not logged in"));
            return;
        }
        firebaseFirestore.collection(USER_DATABASE_PATH).document(firebaseAuth.getUid()).get().addOnSuccessListener(documentSnapshot -> {
            User user = documentSnapshot.toObject(User.class);
            onUserRetrieved.accept(user, null);
        }).addOnFailureListener(e -> {
            onUserRetrieved.accept(null, e);
        });
    }


    public void logOut(Consumer<Void> onLoggedOut) {
        firebaseAuth.signOut();
        onLoggedOut.accept(null);
    }

    public void getFurnitureData(
            BiConsumer<List<FurnitureModel>, Exception> onSuccess
    ) {
        firebaseFirestore.collection("furniture")
                .addSnapshotListener(
                        (value, error) -> {
                            if (error != null) {
                                onSuccess.accept(null, error);
                                return;
                            }
                            if (value != null && !value.isEmpty()) {
                                List<FurnitureModel> furnitureList = value.toObjects(FurnitureModel.class);
                                onSuccess.accept(furnitureList, null);
                            } else {
                                onSuccess.accept(null, new Exception("No data found"));
                            }
                        }
                );

    }
}