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

public class MainActivity extends AppCompatActivity {

  EditText inputName;
  SharedPreferences mPreferences;
  Account account;
  TextView textView;
  AccountManager accountManager = new AccountManager();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (mPreferences.getInt("Colour", 0) == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }

    inputName = (EditText) findViewById(R.id.accountNameText_MainActivity);
    textView = findViewById(R.id.textView_MainActivity);
  }

  /** Called when the user taps the "Settings" button */
  public void openOptions(View view) {
    Intent intent = new Intent(this, OptionsActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "Select Account" button */
  public void startGame(View view) {
    Account tempAccount = accountManager.openExistingAccount(inputName.getText().toString(),
            getApplicationContext());
    if (tempAccount != null) {
      account = tempAccount;
      Intent intent = new Intent(this, Game1Activity.class);
      intent.putExtra("ac", account);
      startActivity(intent);
    } else {
        textView.setText(R.string.invalid_username);
    }
  }

  /** Called when the user taps the "Create Account" button */
  public void createAccount(View view) {
    Intent intent = new Intent(this, CreateAccountActivity.class);
    startActivity(intent);
  }
}
