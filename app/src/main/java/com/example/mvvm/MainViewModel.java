package com.example.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author war
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScoreA;
    private MutableLiveData<Integer> bTeamScoreB;
    private int aBack, bBack;

    public MutableLiveData<Integer> getaTeamScoreA() {
        if (aTeamScoreA == null) {
            aTeamScoreA = new MutableLiveData<>();
            aTeamScoreA.setValue(0);
        }
        return aTeamScoreA;
    }

    public MutableLiveData<Integer> getbTeamScoreB() {
        if (bTeamScoreB == null) {
            bTeamScoreB = new MutableLiveData<>();
            bTeamScoreB.setValue(0);
        }
        return bTeamScoreB;
    }

    public void aTeamAdd(int p) {
        aBack = aTeamScoreA.getValue();
        bBack = bTeamScoreB.getValue();
        aTeamScoreA.setValue(aBack + p);
    }

    public void bTeamAdd(int p) {
        aBack = aTeamScoreA.getValue();
        bBack = bTeamScoreB.getValue();
        bTeamScoreB.setValue(bTeamScoreB.getValue() + p);
    }

    public void reset() {
        aBack = aTeamScoreA.getValue();
        bBack = bTeamScoreB.getValue();
        aTeamScoreA.setValue(0);
        bTeamScoreB.setValue(0);
    }

    public void unDo(){
        aTeamScoreA.setValue(aBack);
        bTeamScoreB.setValue(bBack);
    }
}

