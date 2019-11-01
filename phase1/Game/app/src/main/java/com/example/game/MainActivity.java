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

public class MainActivity extends BaseActivity {

  SharedPreferences mPreferences;
  Account account;
  AccountManager accountManager = new AccountManager();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (mPreferences.getInt("Colour", 0) == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }
  }

  /** Called when the user taps the "Settings" button */
  public void openOptions(View view) {
    Intent intent = new Intent(this, OptionsActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }

  /** Called when the user taps the "Select Account" button */
  public void startGame(View view) {
      Intent intent = new Intent(this, Game1Activity.class);
      intent.putExtra("ac", account);
      startActivity(intent);
  }
}
