package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

  EditText inputName;
  AccountManager acc;
  SharedPreferences mPreferences;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);

    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (mPreferences.getInt("Colour", 0) == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }

    inputName = (EditText) findViewById(R.id.createName_CreateAccountActivity);
  }

  /** Called when the user taps the "Create Account" or "Back" button */
  public void toMainMenu(View view) {
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

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}
