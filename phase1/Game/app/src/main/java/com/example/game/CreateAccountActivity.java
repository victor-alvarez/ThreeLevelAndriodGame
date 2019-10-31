package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity {

  EditText inputName;
  AccountManager accountManager = new AccountManager();
  SharedPreferences mPreferences;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);

    inputName = findViewById(R.id.createName_CreateAccountActivity);
    textView = findViewById(R.id.textView_CreateAccountActivity);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (mPreferences.getInt("Colour", 0) == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }
  }

  public void createAccount(View view){
    Account tempAccount = accountManager.openExistingAccount(inputName.getText().toString(),
            getApplicationContext());
    if (tempAccount == null){
      accountManager.createNewAccount(inputName.getText().toString(), getApplicationContext());
      textView.setText(getResources().getText(R.string.account_created));
      textView.setTextColor(getColor(R.color.font1));
    } else {
      textView.setText(getResources().getText(R.string.account_already_exists));
      if (mPreferences.getInt("Colour", 0) == 1) {
        textView.setTextColor(getResources().getColor(R.color.background2));
      } else {
        textView.setTextColor(getColor(R.color.background1));
      }
    }
  }

  /** Called when the user taps the "Create Account" or "Back" button */
  public void toLoginMenu(View view) {
    // The button with id R.id.createButton_CreateAccountActivity is still linked to this
    // method. Recall the previous To-do associated with this button:

    // Todo: create account (perhaps by passing info back to MainActivity).
    //  May also send this back to main. For now it will do that.

    // if()
    // toMainMenu()

    // Should probably create a new method for the R.id.createButton_CreateAccountActivity
    // button OR check the id of the view parameter to determine what to do. But for now, as stated
    // in the To-do, it will just call this method.

    // Also recall that the button with id R.id.backButton_CreateAccountActivity is also
    // linked to this method, as it should be.

    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }
}
