package com.example.game.models.interfaces;
import com.example.game.models.Scoreboard;

import java.io.File;

/**
 * Interface for whatever service/class accesses the database directly for scoreboard information
 */
public interface ScoreboardDataRepositoryInterface {

    void save(File contextFile, Scoreboard scoreboard);

    Scoreboard openScoreboard(File contextFile);
}
