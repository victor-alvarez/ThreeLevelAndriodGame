package com.example.game.models;

import com.example.game.models.Account;
import com.example.game.models.AccountDataRepositoryInterface;

import java.io.File;

/**
 * Javadocs
 */
public class AccountHolder{
    private Account account;

    private AccountDataRepositoryInterface accountDataRepositoryInterface;

    public AccountHolder(Account account, AccountDataRepositoryInterface accountDataRepositoryInterface){
        this.account = account;
        this.accountDataRepositoryInterface = accountDataRepositoryInterface;
    }

    public String getLogin() {
        return account.getLogin();
    }

    /**
     * Sets this account's background colour to selected colour and records it
     * @param colour the number that respresents a background colour for this account
     * @param contextFile an access to the current file state of the app
     */
    public void setBackground(String colour, File contextFile) {
        account.setBackground(colour, contextFile, accountDataRepositoryInterface);
    }

    public int getBackground(){
        return account.getBackground();
    }

    /**
     * Sets this account's language and records the setting
     * @param language the number that respresents a language for this account
     * @param contextFile an access to the current file state of the app
     */
    public void setLanguage(String language, File contextFile) {
        account.setLanguage(language, contextFile, accountDataRepositoryInterface);
    }

    public String getLanguage(){
        return account.getLanguage();
    }


    /**
     * Sets this accounts icon
     * @param icon the icon setting
     * @param contextFile an access to the current file state of the app
     */
    public void setIcon(String icon, File contextFile) {
        account.setIcon(icon, contextFile, accountDataRepositoryInterface);
    }

    public int getIcon(){
        return account.getIcon();
    }


    /**
     * Increments level or resets it where appropriate and records it
     * @param contextFile an access to the current file state of the app
     */
    public void incrementLevel(File contextFile) {
        account.incrementLevel(contextFile, accountDataRepositoryInterface);
    }

    /**
     * Decrements level for purposes of retrying where appropriate and records it
     * @param contextFile an access to the current file state of the app
     */
    public void decrementLevel(File contextFile) {
        account.decrementLevel(contextFile, accountDataRepositoryInterface);
    }

    /**
     * Reduces hitpoints by a set amount and records it
     * @param reduce the amount by which hit points are reduced
     * @param contextFile an access to the current file state of the app
     */
    public void decrementHitPoints(int reduce, File contextFile) {
        account.decrementHitPoints(reduce, contextFile, accountDataRepositoryInterface);
    }

    /**
     * Changes score by amount add
     * @param add the amount to be added to the score
     * @param contextFile an access to the current file state of the app
     */
    public void incrementScore(int add, File contextFile) {
        account.incrementScore(add, contextFile, accountDataRepositoryInterface);
    }

    /**
     * Increments the number of times the games are played on this account
     * @param contextFile an access to the current file state of the app
     */
    public void incrementGamesPlayed(File contextFile) {
        account.incrementGamesPlayed(contextFile, accountDataRepositoryInterface);
    }

    /**
     * Sets this account's stats to starting ones
     * @param contextFile an access to the current file state of the app
     */
    public void resetValues(File contextFile){
        account.resetValues(contextFile, accountDataRepositoryInterface);
    }

    public int getLastAttemptedLevel() {
        return account.getLastAttemptedLevel();
    }

    public int getHitPoints() {
        return account.getHitPoints();
    }

    public int getCurrentScore() {
        return account.getCurrentScore();
    }

    public int getGamesPlayed() {
        return account.getGamesPlayed();
    }

    public int getCoins() {
        return account.getCoins();
    }

    public Account getAccount() {
        return account;
    }
}
