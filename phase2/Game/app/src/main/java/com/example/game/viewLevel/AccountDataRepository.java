package com.example.game.viewLevel;

import android.util.Log;

import com.example.game.models.Account;
import com.example.game.models.AccountDataRepositoryInterface;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static android.content.ContentValues.TAG;

class AccountDataRepository implements AccountDataRepositoryInterface {
    /**
     * Should items outside of the view in MVP be able to know about/need android specific objects?
     * Question about what feedback means. If also does not know then ask what can be done.
     * How should accessing data be done to follow clean architecture and MVP?
     * Is it more correct to have AccountDataRepository implement and interface and pass it to account instead of static?
     * Should retrieving resources data be done by a subclass? (Probably, still in view though)
     * Ask about the two items that must be completed.
     */
    private static final String FILE_NAME = "save.txt";

    public void save(File contextFile, Account account){
        try {
            Gson gson = new Gson();
            String accountString = gson.toJson(account);

            File saveFile = new File(contextFile, FILE_NAME);
            FileReader fileReader = new FileReader(saveFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(account.getLogin())) {
                    line = accountString;
                }
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            fileReader.close();
            bufferedReader.close();
            FileWriter fileOut = new FileWriter(saveFile);
            fileOut.write(stringBuilder.toString());
            fileOut.close();
            Log.v(TAG, "lol" + stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Account openExistingAccount(String login, File contextFile){
        try {
            Gson gson = new Gson();
            File saveFile = new File(contextFile, FILE_NAME);
            FileReader loadAccountData = new FileReader(saveFile);
            BufferedReader loadAccData = new BufferedReader(loadAccountData);
            String line;
            while ((line = loadAccData.readLine()) != null) {
                if (line.contains(login)) {
                    Account acc = gson.fromJson(line, Account.class);
                    loadAccData.close();
                    return acc;
                }
            }
        } catch (IOException error) {
            error.printStackTrace();
            System.out.println("Can't find account");
        }
        return null;
    }

    public void createNewAccount(String login, File contextFile) {
        try {
            Gson gson = new Gson();
            Account account = new Account(login);
            File saveFile = new File(contextFile, FILE_NAME);
            FileWriter fileWriter = new FileWriter(saveFile, true);
            fileWriter.write(gson.toJson(account));
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void deleteAccountData(File contextFile){
        File saveFile = new File(contextFile, FILE_NAME);
        if (saveFile.delete()) {
            System.out.println("Successfully deleted");
        }
    }
}
