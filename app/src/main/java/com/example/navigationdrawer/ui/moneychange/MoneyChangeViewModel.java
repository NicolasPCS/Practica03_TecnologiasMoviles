package com.example.navigationdrawer.ui.moneychange;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoneyChangeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MoneyChangeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}