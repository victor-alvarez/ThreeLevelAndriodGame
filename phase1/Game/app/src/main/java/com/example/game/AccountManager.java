package com.example.game;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.content.ContextCompat;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

/** Account manager that manages accounts. */
public class AccountManager implements Serializable {

  /**
   * Creates new account with given login. Activates from Create Account button. Takes login from
   * Enter Login field. Uses default values for customization settings and save data. Creates save
   * file if missing.
   *
   * @param login of the Account.
   * @return new Account with given login.
   */
  public static Account createNewAccount(String login, Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      if (!saveFile.exists()) {
        saveFile.createNewFile();
        FileWriter saveAccount = new FileWriter(saveFile);
        saveAccount.write("*Empty, 0, Empty 0, Empty, 0");
        saveAccount.close();
      }
      FileWriter saveAccount = new FileWriter(saveFile, true);
      saveAccount.write("\n" + login + ", 0, 0, 0, 0, 0, 0, 0");
      saveAccount.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
    return new Account(login, context);
  }

  /**
   * Creates account that was earlier saved to file. Activates from Select Account button. Takes
   * login from Enter Login field. Uses saved values for customization settings and save data.
   *
   * @param login of the Account.
   * @return Array[boolean][Account]: account found => true + loaded Account, save file or account
   *     missing => false + null.
   */
  public static Account openExistingAccount(String login, Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      if (!saveFile.exists()) {
        return null;
      }
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line = loadAccData.readLine();
      while ((line = loadAccData.readLine()) != null) {
        int i = line.indexOf(", ");
        String s = line.substring(0, i);
        if (login.equals(s)) {
          String[] l = line.split(", ");
          String[] cust = {l[1], l[2], l[3]};
          String[] save = {l[4], l[5], l[6], l[7]};
          Account acc = new Account(login, cust, save);
          return acc;
        }
      }
    } catch (IOException error) {
      error.printStackTrace();
      System.out.println("Can't find account");
    }
    return null;
  }
}
