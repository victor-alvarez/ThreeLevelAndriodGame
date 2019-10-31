package com.example.game.Game1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Account;

public class BallJumperActivity extends Activity {

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

  public void gameOver(){
    Intent intent = new Intent(this, GameOverActivity.class);
    startActivity(intent);
  }
}
