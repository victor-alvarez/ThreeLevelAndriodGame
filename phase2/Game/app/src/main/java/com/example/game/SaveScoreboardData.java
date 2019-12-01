package com.example.game;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveScoreboardData {
    //TODO: Use a JSON file system to save scoreboard information across uses.
    private static final String FILE_NAME = "scoreboardData.txt";

    static void save(Context context, Scoreboard scoreboard){
        try {
            Gson gson = new Gson();
            String scoreboardString = gson.toJson(scoreboard);

            File saveFile = new File(context.getFilesDir(), FILE_NAME);
            FileWriter fileOut = new FileWriter(saveFile);
            fileOut.write(scoreboardString);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Scoreboard openScoreboard(Context context){
        try {
            Gson gson = new Gson();
            File saveFile = new File(context.getFilesDir(), FILE_NAME);
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

    static void createScoreboard(Context context) {
        try {
            Gson gson = new Gson();
            Scoreboard scoreboard = new Scoreboard();
            File saveFile = new File(context.getFilesDir(), FILE_NAME);
            FileWriter fileWriter = new FileWriter(saveFile, true);
            fileWriter.write(gson.toJson(scoreboard));
            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    static void deleteScoreboardData(Context context){
        File saveFile = new File(context.getFilesDir(), FILE_NAME);
        if (saveFile.delete()) {
            System.out.println("Successfully deleted");
        }
    }
}
