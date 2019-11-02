package com.example.game;

import android.content.Context;
import java.io.*;
import java.util.ArrayList;

/** Account manager that manages the creation and opening of accounts. */
class AccountManager {

  /**
   * Creates new account with given login. Activates from Create Account button. Takes login from
   * Enter Login field. Uses default values for customization settings and save data. Creates save
   * file if missing.
   *
   * @param login of the Account.
   */
  void createNewAccount(String login, Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      if (!saveFile.exists()) {
        saveFile.createNewFile();
        FileWriter saveAccount = new FileWriter(saveFile);
        saveAccount.write("*Empty, 0, Empty 0, Empty, 0");
        saveAccount.close();
      }
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line;
      ArrayList<String> old = new ArrayList<>();
      while ((line = loadAccData.readLine()) != null) {
        old.add(line);
      }
      old.add(login + ", 0, 0, 0, 0, 200, 0, 0" );
      PrintWriter updateSave = new PrintWriter(saveFile);
      for (String i : old) {
        updateSave.println(i);
      }
      updateSave.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

  /**
   * Creates account that was earlier saved to file. Activates from Select Account button. Takes
   * login from Enter Login field. Uses saved values for customization settings and save data.
   *
   * @param login of the Account.
   * @return Array[boolean][Account]: account found => loaded Account, save file or account
   *     missing => null.
   */
  Account openExistingAccount(String login, Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      if (!saveFile.exists()) {
        return null;
      }
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line;
      while ((line = loadAccData.readLine()) != null) {
        int i = line.indexOf(", ");
        String s = line.substring(0, i);
        if (login.equals(s)) {
          String[] l = line.split(", ");
          String[] cust = {l[1], l[2], l[3]};
          String[] save = {l[4], l[5], l[6], l[7]};
          Account acc = new Account(login, cust, save);
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

  // Deletes all accounts
  void deleteAccountData(Context context){
    File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
    if(saveFile.delete()) {
      System.out.println("Successfully deleted");
    }
  }

  /* For Phase 2. Left here as rough methods we were unable to implement in time

  public void updateHighScores(Account acc, Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line = loadAccData.readLine();
      loadAccData.close();
      String[] l = line.split(", ");
      int highscore1 = Integer.parseInt(l[1]);
      int highscore2 = Integer.parseInt(l[3]);
      int highscore3 = Integer.parseInt(l[5]);
      String Winner1 = l[0];
      String Winner2 = l[2];
      String Winner3 = l[4];
      int hs = acc.save[2];
      String w = acc.login;
      if (hs > highscore1) {
        String s = w+", "+hs+", "+Winner1+", "+highscore1+", "+Winner2+", "+highscore2;
        writeHighScore(s, context);
      } else if (hs > highscore2){
        String s = Winner1+", "+highscore1+", "+w+", "+hs+", "+Winner2+", "+highscore2;
        writeHighScore(s, context);
      } else if (hs > highscore3){
        String s = Winner1+", "+highscore1+", "+Winner2+", "+highscore2+", "+w+", "+hs;
        writeHighScore(s, context);
      }
    } catch (IOException error) {
      error.printStackTrace();
      System.out.println("Error");
    }
  }

  public void writeHighScore(String hs, Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line = loadAccData.readLine();
      ArrayList<String> old = new ArrayList<String>();
      while ((line = loadAccData.readLine()) != null) {
        old.add(line);
      }
      loadAccData.close();
      PrintWriter updateSave = new PrintWriter(saveFile);
      updateSave.println(hs);
      for (String i : old) {
        updateSave.println(i);
      }
      updateSave.close();
    } catch (IOException error) {
      System.out.println("Can't find account");
    }
  }*/
}