package com.example.game.Game1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.GameOver;

public class BallJumperActivity extends BaseActivity {

  Account account;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(dm);
    Constants.SCREEN_WIDTH = dm.widthPixels;
    Constants.SCREEN_HEIGHT = dm.heightPixels;

    setContentView(new GamePanel(this));
    account = (Account) getIntent().getSerializableExtra("ac");
  }

  public void gameOver(int score, int hitPoints){
    Intent intent = new Intent(this, GameOverActivity.class);
    intent.putExtra("SCORE", score);
    account.incrementScore(score, getApplicationContext());
    account.decrementHitPoints(hitPoints, getApplicationContext());
    account.incrementGamesPlayed(getApplicationContext());
    if (account.getSave()[1] <= 0){
      //Ran out of lives
      intent = new Intent(this, GameOver.class);
    }
    intent.putExtra("ac", account);
    startActivity(intent);
  }

  @Override
  public void onStop(){
    super.onStop();
    finish();
  }
}
