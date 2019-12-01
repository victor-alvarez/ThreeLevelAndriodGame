package com.example.game;

import android.content.Context;

import java.util.ArrayList;
import java.util.Stack;

public class Scoreboard {
    private Stack<Pair<Account, Integer>> rank;

    Scoreboard(){
        rank = new Stack<>();
    }

    ArrayList<Pair<Account, Integer>> getScoreboard(){
        Stack<Pair<Account, Integer>> tempStack = new Stack<>();
        ArrayList<Pair<Account, Integer>> scoreboard = new ArrayList<>();
        while(!rank.isEmpty()){
            Pair<Account, Integer> currentAccount = rank.pop();
            tempStack.push(currentAccount);
            scoreboard.add(currentAccount);
        }
        while(!tempStack.isEmpty()){
            Pair<Account, Integer> currentAccount = tempStack.pop();
            rank.push(currentAccount);
        }
        return scoreboard;
    }

    boolean addScore(Account account, int score, Context context){
        Pair<Account, Integer> accountIntegerPair = new Pair<>(account, score);
        int accountRank = findAccountRank(score);
        if(accountRank != 0) {
            placeAccount(accountIntegerPair, accountRank);
            SaveScoreboardData.save( context, this);
            return true;
        } else {
            return false;
        }
    }


    private void placeAccount(Pair<Account, Integer> accountIntegerPair, int accountRank) {
        Stack<Pair<Account, Integer>> tempStack = new Stack<>();
        while(!rank.isEmpty()){
            Pair<Account, Integer> currentAccount = rank.pop();
            if(accountRank == tempStack.size() + 1){
                tempStack.push(accountIntegerPair);
            }
            if (tempStack.size() < 5){
                tempStack.push(currentAccount);
            }
        }
        if(accountRank == tempStack.size() + 1){
            tempStack.push(accountIntegerPair);
        }
        while(!tempStack.isEmpty()){
            Pair<Account, Integer> currentAccount= tempStack.pop();
            rank.push(currentAccount);
        }
    }

    private int findAccountRank(int score) {
        if(rank.isEmpty()){
            return 1;
        } else if(isScoreHighEnough(score)){
            int count = 0;
            Stack<Pair<Account, Integer>> tempStack = new Stack<>();
            while(!rank.isEmpty()){
                Pair<Account, Integer> currentAccount = rank.pop();
                if(currentAccount.getSecond() < score){
                    count++;
                }
                tempStack.push(currentAccount);
            }
            while(!tempStack.isEmpty()){
                Pair<Account, Integer> currentAccount= tempStack.pop();
                rank.push(currentAccount);
            }
            return rank.size() + 1 - count; //
        }else{
            //score is not high enough to be in the scoreBoard
            return 0;
        }
    }

    private boolean isScoreHighEnough(int score) {
        boolean isScoreHighEnough = false;
        Stack<Pair<Account, Integer>> tempStack = new Stack<>();
        while(!rank.isEmpty()){
            Pair<Account, Integer> currentAccount= rank.pop();
            if(currentAccount.getSecond() < score){
                isScoreHighEnough = true;
            }
            tempStack.push(currentAccount);
        }
        while(!tempStack.isEmpty()){
            Pair<Account, Integer> currentAccount= tempStack.pop();
            rank.push(currentAccount);
        }
        if(rank.size() < 5){
            isScoreHighEnough = true;
        }
        return isScoreHighEnough;
    }


}
