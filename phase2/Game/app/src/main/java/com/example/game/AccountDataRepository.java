package com.example.game;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static android.content.ContentValues.TAG;

class AccountDataRepository {

    private static final String FILE_NAME = "save.txt";

    static void save(Context context, Account account){
        try {
            Gson gson = new Gson();
            String accountString = gson.toJson(account);

            File saveFile = new File(context.getFilesDir(), FILE_NAME);
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

    static Account openExistingAccount(String login, Context context){
        try {
            Gson gson = new Gson();
            File saveFile = new File(context.getFilesDir(), FILE_NAME);
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

    static void createNewAccount(String login, Context context) {
        try {
            Gson gson = new Gson();
            Account account = new Account(login);
            File saveFile = new File(context.getFilesDir(), FILE_NAME);
            FileWriter fileWriter = new FileWriter(saveFile, true);
            fileWriter.write(gson.toJson(account));
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    static void deleteAccountData(Context context){
        File saveFile = new File(context.getFilesDir(), FILE_NAME);
        if (saveFile.delete()) {
            System.out.println("Successfully deleted");
        }
    }
}
