package com.aiyu.furniture.core.database.interaction;


import com.aiyu.furniture.core.database.model.AddressModel;
import com.aiyu.furniture.core.database.model.CartModel;
import com.aiyu.furniture.core.database.model.FurnitureModel;
import com.aiyu.furniture.core.database.model.OrderModel;
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
    private static final String CART_DATABASE_PATH = "Cart";
    private static final String ORDER_DATABASE_PATH = "Order";

    private static final String ADDRESS_DATABASE_PATH = "Address";
    private static final String FURNITURE_DATABASE_PATH = "furniture";
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

    public void updateUser(User user, Consumer<Exception> onUserAdded) {
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(user.getUid());
        ref.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                addUserToDatabase(user, onUserAdded, ref);
            } else {
                onUserAdded.accept(new Exception("User not found"));
            }
        }).addOnFailureListener(onUserAdded::accept);
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

    public void getFurnitureData(BiConsumer<List<FurnitureModel>, Exception> onSuccess) {
        firebaseFirestore.collection(FURNITURE_DATABASE_PATH).addSnapshotListener((value, error) -> {
            if (error != null) {
                onSuccess.accept(null, error);
                return;
            }
            if (value != null && !value.isEmpty()) {
                List<FurnitureModel> furnitureList = value.toObjects(FurnitureModel.class);
                onSuccess.accept(furnitureList, null);
            } else {
                onSuccess.accept(null, new FirebaseInteractionNoDataFoundException());
            }
        });
    }

    public void addItemToCart(CartModel cartModel, Consumer<Exception> onItemAdded) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(uid).collection(CART_DATABASE_PATH);
        ref.document(cartModel.getItems().getPath()).set(cartModel).addOnSuccessListener(aVoid -> {
            onItemAdded.accept(null);
        }).addOnFailureListener(onItemAdded::accept);
    }

    public void getCartItems(BiConsumer<List<CartModel>, Exception> onSuccess) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(uid).collection(CART_DATABASE_PATH);
        ref.addSnapshotListener((value, error) -> {
            if (error != null) {
                onSuccess.accept(null, error);
                return;
            }
            if (value != null && !value.isEmpty()) {
                List<CartModel> cartList = value.toObjects(CartModel.class);
                onSuccess.accept(cartList, null);
            } else {
                onSuccess.accept(null, new FirebaseInteractionNoDataFoundException());
            }
        });
    }

    public void removeItemFromCart(String path, Consumer<Exception> onItemRemoved) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(uid).collection(CART_DATABASE_PATH);
        ref.document(path).delete().addOnSuccessListener(aVoid -> {
            onItemRemoved.accept(null);
        }).addOnFailureListener(onItemRemoved::accept);
    }


    public void addOrder(OrderModel orderModel, Consumer<Exception> onOrderAdded) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH)
                .document(uid)
                .collection(ORDER_DATABASE_PATH);
        var path = ref.getId();
        orderModel.setPath(path);
        ref.document(path).set(orderModel).addOnSuccessListener(aVoid -> {
            onOrderAdded.accept(null);
        }).addOnFailureListener(onOrderAdded::accept);
    }

    public void getOrders(BiConsumer<List<OrderModel>, Exception> onSuccess) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(uid).collection(ORDER_DATABASE_PATH);
        ref.addSnapshotListener((value, error) -> {
            if (error != null) {
                onSuccess.accept(null, error);
                return;
            }
            if (value != null && !value.isEmpty()) {
                List<OrderModel> orderList = value.toObjects(OrderModel.class);
                onSuccess.accept(orderList, null);
            } else {
                onSuccess.accept(null, new FirebaseInteractionNoDataFoundException());
            }
        });
    }

    public void addAddress(AddressModel addressModel, Consumer<Exception> onAddressAdded) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(uid).collection(ADDRESS_DATABASE_PATH);
        ref.document(addressModel.getPath()).set(addressModel).addOnSuccessListener(aVoid -> {
            onAddressAdded.accept(null);
        }).addOnFailureListener(onAddressAdded::accept);
    }

    public void getAddress(BiConsumer<List<AddressModel>, Exception> onSuccess) {
        String uid = firebaseAuth.getUid();
        var ref = firebaseFirestore.collection(USER_DATABASE_PATH).document(uid).collection(ADDRESS_DATABASE_PATH);
        ref.addSnapshotListener((value, error) -> {
            if (error != null) {
                onSuccess.accept(null, error);
                return;
            }
            if (value != null && !value.isEmpty()) {
                List<AddressModel> addressList = value.toObjects(AddressModel.class);
                onSuccess.accept(addressList, null);
            } else {
                onSuccess.accept(null, new FirebaseInteractionNoDataFoundException());
            }
        });
    }
}