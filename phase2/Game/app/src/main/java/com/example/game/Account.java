package com.example.game;

import android.content.Context;

import java.io.Serializable;

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
  private Customization customization;

  /** Account's save data:
   * at index 0 - last level attempted (0-4):
   * 0 - have not started level 1 yet,
   * 1, 2, 3 - started level 1, 2, 3,
   * 4 - won the last game;
   * at index 1 - hit points (0-100);
   * at index 2 - current score (0+);
   * at index 3 - games played (addiction counter) (0+). Includes retries of games.*/
  private GameData gameData;

  /**
   * Constructor for brand new Account. Activates from Create Account button. Takes login from Enter
   * Login field. Uses default values for customization settings and save data.
   *
   * @param login of the Account.
   */
  public Account(String login) {
    this.login = login;
    this.customization = new Customization();
    this.gameData = new GameData();
  }

  public String getLogin() {
    return login;
  }

  /**
   * Sets this account's background colour to selected colour and records it
   * @param colour the number that respresents a background colour for this account
   * @param context an access to the current file state of the app
   */
  public void setBackground(String colour, Context context) {
    customization.setCurrentColour(colour);
    AccountDataRepository.save(context, this);
  }

  public int getBackground(){
    return customization.getCurrentColour();
  }

  /**
   * Sets this account's language and records the setting
   * @param language the number that respresents a language for this account
   * @param context an access to the current file state of the app
   */
  public void setLanguage(String language, Context context) {
    customization.setCurrentLanguage(language);
    AccountDataRepository.save(context, this);
  }

  public String getLanguage(){
    return customization.getCurrentLanguage();
  }


  /**
   * Sets this accounts icon
   * @param icon the icon setting
   * @param context an access to the current file state of the app
   */
  public void setIcon(String icon, Context context) {
    customization.setCurrentIcon(icon);
    AccountDataRepository.save(context, this);
  }

  public int getIcon(){
    return customization.getCurrentIcon();
  }


  /**
   * Increments level or resets it where appropriate and records it
   * @param context an access to the current file state of the app
   */
  public void incrementLevel(Context context) {
    gameData.incrementLevel();
    AccountDataRepository.save(context, this);
  }

  /**
   * Decrements level for purposes of retrying where appropriate and records it
   * @param context an access to the current file state of the app
   */
  public void decrementLevel(Context context) {
    gameData.decrementLevel();
    AccountDataRepository.save(context, this);
  }

  /**
   * Reduces hitpoints by a set amount and records it
   * @param reduce the amount by which hit points are reduced
   * @param context an access to the current file state of the app
   */
  public void decrementHitPoints(int reduce, Context context) {
    gameData.decrementHitPoints(reduce);
    AccountDataRepository.save(context, this);
  }

  /**
   * Changes score by amount add
   * @param add the amount to be added to the score
   * @param context an access to the current file state of the app
   */
  public void incrementScore(int add, Context context) {
    gameData.incrementScore(add);
    AccountDataRepository.save(context, this);
  }

  /**
   * Increments the number of times the games are played on this account
   * @param context an access to the current file state of the app
   */
  public void incrementGamesPlayed(Context context) {
    gameData.incrementGamesPlayed();
    AccountDataRepository.save(context, this);
  }

  /**
   * Sets this account's stats to starting ones
   * @param context an access to the current file state of the app
   */
  void resetValues(Context context){
    gameData.resetData();
    AccountDataRepository.save(context, this);
  }

  public int getLastAttemptedLevel() {
    return gameData.getLastAttemptedLevel();
  }

  public int getHitPoints() {
    return gameData.getHitPoints();
  }

  public int getCurrentScore() {
    return gameData.getCurrentScore();
  }

  public int getGamesPlayed() {
    return gameData.getGamesPlayed();
  }

  public int getCoins() {
    return gameData.getCoins();
  }
}
