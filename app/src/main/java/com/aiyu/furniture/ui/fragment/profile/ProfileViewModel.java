package com.aiyu.furniture.ui.fragment.profile;

import androidx.lifecycle.ViewModel;

import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.core.database.model.User;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ProfileViewModel extends ViewModel {

    private final FirebaseInteraction firebaseInteraction;

    @Inject
    public ProfileViewModel(FirebaseInteraction firebaseInteraction) {
        this.firebaseInteraction = firebaseInteraction;
    }

    public void getUser(
            BiConsumer<User, Exception> onUserRetrieved
    ) {
        firebaseInteraction.getUser(onUserRetrieved);
    }

    public void logOut(
            Consumer<Void> onLoggedOut
    ) {
        firebaseInteraction.logOut(onLoggedOut);
    }
}
