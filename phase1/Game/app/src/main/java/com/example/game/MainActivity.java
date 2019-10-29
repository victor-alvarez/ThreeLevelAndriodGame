package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import com.example.game.Game1.Game1Activity;

public class MainActivity extends AppCompatActivity {

  EditText inputName;
  SharedPreferences mPreferences;
  AccountManager accountManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (mPreferences.getInt("Colour", 0) == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }

    // TODO: Load in account information to accountManager

    inputName = (EditText) findViewById(R.id.accountNameText_MainActivity);
  }

  /** Called when the user taps the "Settings" button */
  public void openOptions(View view) {
    Intent intent = new Intent(this, OptionsActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "Select Account" button */
  public void startGame(View view) {
    // if (inputName.getText().toString().equals(temp)){
    // TODO: Do something with the correct account to pass instructions about data
    //  and starting point
    /* TODO:
    Do something different depending on the selected account. Game manager should handle this
    in the backend.
     */
    Intent intent = new Intent(this, Game1Activity.class);
    // Intent.putExtra("ac", accountManager);
    startActivity(intent);
    // }
  }

  /** Called when the user taps the "Create Account" button */
  public void createAccount(View view) {
    Intent intent = new Intent(this, CreateAccountActivity.class);
    startActivity(intent);
  }
}
