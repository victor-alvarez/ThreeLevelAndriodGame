package com.example.game.models;

import com.example.game.models.interfaces.DataIncrementerListener;

import java.io.File;

import static com.example.game.BaseActivity.account;

public class DataIncrementerUseCases {
    public void decrementThenAgain(DataIncrementerListener listener, File contextFile){
        account.decrementLevel(contextFile);
        listener.doAgain();
    }

    public void incrementThenNext(DataIncrementerListener listener, File contextFile){
        account.incrementLevel(contextFile);
        listener.next();
    }
}
