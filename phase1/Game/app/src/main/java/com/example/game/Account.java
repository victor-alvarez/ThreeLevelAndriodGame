package com.example.game;

import android.content.Context;

import java.io.*;
import java.util.ArrayList;

/** An account */
public class Account implements Serializable{

  /** Account's login, customization settings and save data. */
  public String login;

  public String[] customisation;
  public String[] save;

  private Context context;

  /**
   * Constructor for brand new Account. Activates from Create Account button. Takes login from Enter
   * Login field. Uses default values for customization settings and save data.
   *
   * @param login of the Account.
   */
  public Account(String login, Context context) {
    this.login = login;
    String[] a = {"0", "0", "0"};
    this.customisation = a;
    String[] b = {"0", "0", "0", "0"};
    this.save = b;
    this.context = context;
  }

  /**
   * Constructor for existing Account. Activates from Select Account button. Takes login from Enter
   * Login field. Uses saved values for customization settings and save data.
   *
   * @param login of the Account;
   * @param customisation settings of the Account;
   * @param save data of the Account;
   */
  public Account(String login, String[] customisation, String[] save) {
    this.login = login;
    this.customisation = customisation;
    this.save = save;
  }

  /**
   * Getter for the customisation instance variable.
   *
   * @return customization settings of the Account.
   */
  public String[] getCustomisation() {
    return this.customisation;
  }

  /**
   * Setter for the customisation instance variable.
   *
   * @param customisation settings of the Account.
   */
  public void setCustomisation(String[] customisation) {
    this.customisation = customisation;
    this.saveSettings();
  }

  /**
   * Getter for the save instance variable.
   *
   * @return save data of the Account.
   */
  public String[] getSave() {
    return this.save;
  }

  /**
   * Setter for the save instance variable.
   *
   * @param save data of the Account.
   */
  public void setSave(String[] save) {
    this.save = save;
    this.saveProgress();
  }

  public void saveSettings() {
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
          String[] set = this.getCustomisation();
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
  public void saveProgress() {
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
          String[] save = this.getSave();
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

  /*public static void main(String[] args) {
    AccountManager.createNewAccount("TEST");
    AccountManager.createNewAccount("TEST1");
    AccountManager.createNewAccount("TEST2");
    Object[] a = AccountManager.openExistingAccount("TEST1");
    Account c = (Account) a[1];
    System.out.println(a[0] + c.login + c.getCustomisation()[1]);
    String[] newSave = {"1", "2", "3", "4"};
    String[] newSettings = {"1", "1", "1"};
    c.setCustomisation(newSettings);
    c.setSave(newSave);
    c.saveSettings();
    c.saveProgress();
    a = AccountManager.openExistingAccount("TEST1");
    c = (Account) a[1];
    System.out.println(a[0]);
    System.out.println(c.login);
    System.out.println(c.getCustomisation()[0]);
    System.out.println(c.getCustomisation()[1]);
    System.out.println(c.getCustomisation()[2]);
    System.out.println(c.getSave()[0]);
    System.out.println(c.getSave()[1]);
    System.out.println(c.getSave()[2]);
    System.out.println(c.getSave()[3]);
  }*/
}
