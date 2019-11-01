package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.*;
import java.util.ArrayList;

/** An account */
public class Account implements Serializable{

  /** Account's login, customization settings and save data. */
  public String login;

  /** Account's customization:
   * at index 0 - background colour:
   * 0 - grey,
   * 1 - red,
   * 2 - ###;
   * at index 1 - account icon:
   * 0 - none,
   * 1 - ###,
   * 2 - ###;
   * at index 2 - language:
   * 0 - English,
   * 1 - French,
   * 2 - Russian,
   * 3 - Spanish;*/
  public int[] customization;

  /** Account's save data:
   * at index 0 - last level attempted (0-4):
   * 0 - have not started level 1 yet,
   * 1, 2, 3 - started level 1, 2, 3,
   * 4 - won the last game;
   * at index 1 - # of hit points (0-100):
   * at index 2 - current score:
   * at index 3 - high score:*/
  public int[] save;


  /**
   * -------------------- Game 1 Instance Variables ----------------------------------
   */
   SharedPreferences prefrences;
   SharedPreferences.Editor editor;


  /**
   * ---------------------------------------------------------------------------------
   */

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
    int[] b = {0, 100, 0, 0};
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
   * Setter for the customization instance variable.
   *
   * @param customization settings of the Account.
   */
  public void setCustomisation(int[] customization) {
    this.customization = customization;
  }

  /**
   * Getter for the save instance variable.
   *
   * @return save data of the Account.
   */
  public int[] getSave() {
    return this.save;
  }

  /**
   * Setter for the save instance variable.
   *
   * @param save data of the Account.
   */
  public void setSave(int[] save) {
    this.save = save;
  }

  public void saveSettings(Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line;
      ArrayList<String> old = new ArrayList<String>();
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
  public void saveProgress(Context context) {
    try {
      File saveFile = new File(context.getFilesDir() + "/gameSaveFile.txt");
      FileReader loadAccountData = new FileReader(saveFile);
      BufferedReader loadAccData = new BufferedReader(loadAccountData);
      String line;
      ArrayList<String> old = new ArrayList<String>();
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
   * -------------------- Game 1 Methods ---------------------------------------------
   */


  /**
   * ---------------------------------------------------------------------------------
   */

  /*public static void main(String[] args) {
    AccountManager.createNewAccount("TEST");
    AccountManager.createNewAccount("TEST1");
    AccountManager.createNewAccount("TEST2");
    Object[] a = AccountManager.openExistingAccount("TEST1");
    Account c = (Account) a[1];
    System.out.println(a[0] + c.login + c.getCustomisation()[1]);
    String[] newSave = {"1", "50", "3", "4"};
    String[] newSettings = {"1", "1", "1"};
    c.setCustomization(newSettings);
    c.setSave(newSave);
    a = AccountManager.openExistingAccount("TEST1");
    c = (Account) a[1];
    System.out.println(a[0]);
    System.out.println(c.login);
    System.out.println(c.getCustomization()[0]);
    System.out.println(c.getCustomization()[1]);
    System.out.println(c.getCustomization()[2]);
    System.out.println(c.getSave()[0]);
    System.out.println(c.getSave()[1]);
    System.out.println(c.getSave()[2]);
    System.out.println(c.getSave()[3]);
  }*/
}
