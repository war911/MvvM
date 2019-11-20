package com.example.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * @author war
 */
public class MainViewModel extends ViewModel {
    private int aBack, bBack;

    private SavedStateHandle mSavedStateHandle;

    public MainViewModel(SavedStateHandle handle) {
        this.mSavedStateHandle = handle;
    }


    public MutableLiveData<Integer> getATeamScoreA() {
        if (!mSavedStateHandle.contains(MainActivity.KEY_A)) {
            mSavedStateHandle.set(MainActivity.KEY_A, 0);
            mSavedStateHandle.set(MainActivity.KEY_B, 0);
        }
        return mSavedStateHandle.getLiveData(MainActivity.KEY_A);
    }

    public MutableLiveData<Integer> getBTeamScoreB() {
        if (!mSavedStateHandle.contains(MainActivity.KEY_B)) {
            mSavedStateHandle.set(MainActivity.KEY_A, 0);
            mSavedStateHandle.set(MainActivity.KEY_B, 0);
        }
        return mSavedStateHandle.getLiveData(MainActivity.KEY_B);
    }

    public void aTeamAdd(int p) {
        aBack = getATeamScoreA().getValue();
        bBack = getBTeamScoreB().getValue();
        getATeamScoreA().setValue(aBack + p);
    }

    public void bTeamAdd(int p) {
        aBack = getATeamScoreA().getValue();
        bBack = getBTeamScoreB().getValue();
        getBTeamScoreB().setValue(getBTeamScoreB().getValue() + p);
    }

    public void reset() {
        aBack = getATeamScoreA().getValue();
        bBack = getBTeamScoreB().getValue();
        getATeamScoreA().setValue(0);
        getBTeamScoreB().setValue(0);
    }

    public void unDo() {
        getATeamScoreA().setValue(aBack);
        getBTeamScoreB().setValue(bBack);
    }
}

