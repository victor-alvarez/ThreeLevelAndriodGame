package com.example.game.models.Interfaces;
import com.example.game.models.Scoreboard;

import java.io.File;

public interface ScoreboardDataRepositoryInterface {

    void save(File contextFile, Scoreboard scoreboard);

    void createScoreboard(File contextFile, Scoreboard scoreboard);

    Scoreboard openScoreboard(File contextFile);
}
