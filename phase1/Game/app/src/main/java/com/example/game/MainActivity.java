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

public class MainActivity extends BaseActivity {

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

  /** Called when the user taps the "Select Account" button */
  public void startGame(View view) {
      Intent intent = new Intent(this, Game1Activity.class);
      account.resetValues(getApplicationContext());
      intent.putExtra("ac", account);
      startActivity(intent);
  }
}
