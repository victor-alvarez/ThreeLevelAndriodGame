package com.example.game.models;

import com.example.game.models.Interfaces.ScoreboardDataRepositoryInterface;

import java.io.File;
import java.util.ArrayList;

public class ScoreboardHolder {

    private Scoreboard scoreboard;
    private ScoreboardDataRepositoryInterface scoreboardDataRepositoryInterface;

    public ScoreboardHolder(File file, ScoreboardDataRepositoryInterface
            scoreboardDataRepositoryInterface){
        this.scoreboardDataRepositoryInterface = scoreboardDataRepositoryInterface;

        if(this.scoreboardDataRepositoryInterface.openScoreboard(file) == null){
            this.scoreboardDataRepositoryInterface.createScoreboard(file, new Scoreboard());
            this.scoreboard = this.scoreboardDataRepositoryInterface.openScoreboard(file);
        }
        else{
            this.scoreboard = this.scoreboardDataRepositoryInterface.openScoreboard(file);
        }
    }

    public ArrayList<Pair<Account, Integer>> getScoreboardList(){
        return scoreboard.getScoreboardList();
    }

    public boolean addScore(Account account, int score, File file){
        return scoreboard.addScore(account, score, file, scoreboardDataRepositoryInterface);
    }
}
