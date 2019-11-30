package com.example.game;

import com.example.game.models.ActivityDataResponseListener;
import com.example.game.models.game2.RiddleListener;

import java.io.File;
import java.util.ArrayList;

public class ActivityDataUseCases {
    public void resetData(ActivityDataResponseListener dataResponseListener, File contextFile){
        BaseActivity.account.resetValues(contextFile);
        dataResponseListener.reactToReset();
    }
}
