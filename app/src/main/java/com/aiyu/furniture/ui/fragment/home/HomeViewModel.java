package com.aiyu.furniture.ui.fragment.home;

import androidx.lifecycle.ViewModel;

import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.core.database.model.FurnitureModel;

import java.util.List;
import java.util.function.BiConsumer;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final FirebaseInteraction firebaseInteraction;

    @Inject
    public HomeViewModel(FirebaseInteraction firebaseInteraction) {
        this.firebaseInteraction = firebaseInteraction;
    }

    public void getFurnitureData(
            BiConsumer<List<FurnitureModel>, Exception> onSuccess
    ) {
        firebaseInteraction.getFurnitureData(onSuccess);
    }
}
