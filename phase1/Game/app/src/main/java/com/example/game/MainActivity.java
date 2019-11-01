package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.game.Game1.Game1Activity;
import com.example.game.Game2.Game2Activity;
import com.example.game.Game3.Game3Activity;

/**
 * Main menu activity in which the player may navigate to the settings menu, load their game from
 * the previous point they left off at or start a new game.
 */
public class MainActivity extends BaseActivity {

  /**
   * The player's account. It holds information about the player and can record its information
   */
  Account account;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    account = (Account) getIntent().getSerializableExtra("ac");

    if (account.getCustomization()[0] == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }
  }

  /** Called when the user taps the "Resume Game" button */
  public void resumeGame(View view) {
    int level = account.getSave()[0];
    Intent intent;
    if (level == 0){
      // Resets most of the values for the player as they are starting a new game
      account.resetValues(getApplicationContext());
      intent = new Intent(this, Game1Activity.class);
    } else if (level == 1){
      intent = new Intent(this, Game2Activity.class);
    } else {
      intent = new Intent(this, Game3Activity.class);
    }
    intent.putExtra("ac", account);
    startActivity(intent);
  }

  /** Called when the user taps the "Settings" button */
  public void openOptions(View view) {
    Intent intent = new Intent(this, OptionsActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }

  /** Called when the user taps the "Start Game" button */
  public void startGame(View view) {
      Intent intent = new Intent(this, Game1Activity.class);
      // Resets most of the values for the player as they are starting a new game
      account.resetValues(getApplicationContext());
      intent.putExtra("ac", account);
      startActivity(intent);
  }
}
