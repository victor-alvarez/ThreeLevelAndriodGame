package com.example.game.models;

import com.example.game.BaseActivity;
import com.example.game.models.interfaces.ActivityDataResponseListener;

import java.io.File;

public class ActivityDataUseCases {
    public void resetData(ActivityDataResponseListener dataResponseListener, File contextFile){
        BaseActivity.account.resetValues(contextFile);
        dataResponseListener.reactToReset();
    }
}
