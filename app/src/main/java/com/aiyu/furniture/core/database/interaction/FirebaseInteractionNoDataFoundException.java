package com.aiyu.furniture.core.database.interaction;

public class FirebaseInteractionNoDataFoundException extends Exception {
    public FirebaseInteractionNoDataFoundException() {
        super("No data found");
    }
}
