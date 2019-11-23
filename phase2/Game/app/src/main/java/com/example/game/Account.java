package com.example.game;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/** An account */
public class Account implements Serializable{

  /** Account's login, customization settings and save data. */
  private String login;

  /** Account's customization:
   * at index 0 - background colour:
   * 0 - grey,
   * 1 - red;
   * at index 1 - account icon:
   * 0 - none;
   * at index 2 - language:
   * 0 - English,
   * 1 - French,
   * 2 - Russian,
   * 3 - Spanish;*/
  private int[] customization;

  /** Account's save data:
   * at index 0 - last level attempted (0-4):
   * 0 - have not started level 1 yet,
   * 1, 2, 3 - started level 1, 2, 3,
   * 4 - won the last game;
   * at index 1 - hit points (0-100);
   * at index 2 - current score (0+);
   * at index 3 - games played (addiction counter) (0+). Includes retries of games.*/
  private int[] save;

  /**
   * Constructor for brand new Account. Activates from Create Account button. Takes login from Enter
   * Login field. Uses default values for customization settings and save data.
   *
   * @param login of the Account.
   */
  public Account(String login) {
    this.login = login;
    int[] a = {0, 0, 0};
    this.customization = a;
    int[] b = {0, 200, 0, 0};
    this.save = b;
  }

  /**
   * Constructor for existing Account. Activates from Select Account button. Takes login from Enter
   * Login field. Uses saved values for customization settings and save data.
   *
   * @param login of the Account;
   * @param customization settings of the Account;
   * @param save data of the Account;
   */
  public Account(String login, String[] customization, String[] save) {
    this.login = login;
    int[] a = {Integer.parseInt(customization[0]), Integer.parseInt(customization[1]),
            Integer.parseInt(customization[2])};
    this.customization = a;
    int[] b = {Integer.parseInt(save[0]), Integer.parseInt(save[1]), Integer.parseInt(save[2]),
            Integer.parseInt(save[3])};
    this.save = b;
  }

  /**
   * Getter for the customization instance variable.
   *
   * @return customization settings of the Account.
   */
  public int[] getCustomization() {
      return this.customization;
  }

  /**
   * Getter for the save instance variable.
   *
   * @return save data of the Account.
   */
  public int[] getSave() {
    return this.save;
  }

  private void saveSettings(Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line;
      ArrayList<String> old = new ArrayList<>();
      while ((line = loadAccData.readLine()) != null) {
        int i = line.indexOf(", ");
        String s = line.substring(0, i);
        if (this.login.equals(s)) {
          String[] l = line.split(", ");
          String save = l[4] + ", " + l[5] + ", " + l[6] + ", " + l[7];
          int[] set = this.customization;
          String settings = set[0] + ", " + set[1] + ", " + set[2] + ", ";
          String newSettings = s + ", " + settings + save;
          old.add(newSettings);
        } else {
          old.add(line);
        }
      }
      PrintWriter saveSettings = new PrintWriter(saveFile);
      for (String i : old) {
        saveSettings.println(i);
      }
      saveSettings.close();
    } catch (IOException error) {
      System.out.println("Can't find account");
    }
  }

  /**
   * Does the exact same thing as the saveSetting method, so we really only need one of them);
   */
  private void saveProgress(Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line;
      ArrayList<String> old = new ArrayList<>();
      while ((line = loadAccData.readLine()) != null) {
        int i = line.indexOf(", ");
        String s = line.substring(0, i);
        if (this.login.equals(s)) {
          String[] l = line.split(", ");
          int[] save = this.save;
          String set = l[1] + ", " + l[2] + ", " + l[3] + ", ";
          String sav = save[0] + ", " + save[1] + ", " + save[2] + ", " + save[3];
          String newSave = s + ", " + set + sav;
          old.add(newSave);
        } else {
          old.add(line);
        }
      }
      PrintWriter updateSave = new PrintWriter(saveFile);
      for (String i : old) {
        updateSave.println(i);
      }
      updateSave.close();
    } catch (IOException error) {
      System.out.println("Can't find account");
    }
  }

    /**
     * Sets this account's background colour to selected colour and records it
     * @param colour the number that respresents a background colour for this account
     * @param context an access to the current file state of the app
     */
    void setBackground(int colour, Context context) {
        this.customization[0] = colour;
        this.saveSettings(context);
    }

    /**
     * Sets this account's language and records the setting
     * @param lang the number that respresents a language for this account
     * @param context an access to the current file state of the app
     */
    void setLanguage(int lang, Context context) {
        this.customization[1] = lang;
        this.saveSettings(context);
    }

    /**
     * Sets this accounts icon
     * @param muz the icon setting
     * @param context an access to the current file state of the app
     */
    public void setIcon(int muz, Context context) {
        this.customization[2] = muz;
        this.saveSettings(context);
    }

    /**
     * Increments level or resets it where appropriate and records it
     * @param context an access to the current file state of the app
     */
    public void incrementLevel(Context context) {
      if (this.save[0] < 4){
        this.save[0] += 1;
      } else {
        this.save[0] = 0;
      }
      this.saveProgress(context);
    }

  /**
   * Decrements level for purposes of retrying where appropriate and records it
   * @param context an access to the current file state of the app
   */
  public void decrementLevel(Context context) {
    if (this.save[0] > 0){
      this.save[0] -= 1;
    }
    this.saveProgress(context);
  }

    /**
     * Reduces hitpoints by a set amount and records it
     * @param reduce the amount by which hit points are reduced
     * @param context an access to the current file state of the app
     */
    public void decrementHitPoints(int reduce, Context context) {
        this.save[1] -= reduce;
        this.saveProgress(context);
    }

    /**
     * Changes score by amount add
     * @param add the amount to be added to the score
     * @param context an access to the current file state of the app
     */
    public void incrementScore(int add, Context context) {
        this.save[2] += add;
        this.saveProgress(context);
    }

    /**
     * Increments the number of times the games are played on this account
     * @param context an access to the current file state of the app
     */
    public void incrementGamesPlayed(Context context) {
        this.save[3] += 1;
        this.saveProgress(context);
    }

    /**
     * Sets this account's stats to starting ones
     * @param context an access to the current file state of the app
     */
    void resetValues(Context context){
      this.save[0] = 0;
      this.save[1] = 200;
      this.save[2] = 0;
      this.saveProgress(context);
    }
}
