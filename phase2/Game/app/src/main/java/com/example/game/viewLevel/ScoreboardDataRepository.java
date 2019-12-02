package com.example.game.viewLevel;

import com.example.game.models.Scoreboard;
import com.example.game.models.interfaces.ScoreboardDataRepositoryInterface;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Accesses and stores information in a database
 */
public class ScoreboardDataRepository implements ScoreboardDataRepositoryInterface {
    /**
     * Name of file
     */
    private static final String FILE_NAME = "scoreboardData.txt";

    /**
     * Saves a scoreboard to file
     * @param file file path to write in
     * @param scoreboard The scoreboard to save
     */
    public void save(File file, Scoreboard scoreboard){
        try {
            Gson gson = new Gson();
            String scoreboardString = gson.toJson(scoreboard);
            File saveFile = new File(file, FILE_NAME);
            FileWriter fileOut = new FileWriter(saveFile);
            fileOut.write(scoreboardString);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the current scoreboard
     * @param file file path to write in
     * @return Returns the scoreboard found in the database
     */
    public Scoreboard openScoreboard(File file){
        try {
            Gson gson = new Gson();
            File saveFile = new File(file, FILE_NAME);
            FileReader loadAccountData = new FileReader(saveFile);
            BufferedReader loadAccData = new BufferedReader(loadAccountData);
            String line;
            if ((line = loadAccData.readLine()) != null) {
                Scoreboard scoreboard = gson.fromJson(line, Scoreboard.class);
                loadAccData.close();
                return scoreboard;
            }
        } catch (IOException error) {
            error.printStackTrace();
            System.out.println("Can't find scoreboard");
        }
        return null;
    }
}
