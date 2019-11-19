package com.example.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author war
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> LikedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if (LikedNumber == null) {
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikedNumber(int number) {
        LikedNumber.setValue(LikedNumber.getValue() + number);
    }

    public void cutLikedNumber(int number) {
        LikedNumber.setValue(LikedNumber.getValue() - number);
    }
}
