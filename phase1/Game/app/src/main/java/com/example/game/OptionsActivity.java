package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;

/**
 * Options activity where the player may set their required customizations
 */
public class OptionsActivity extends BaseActivity {

  /**
   * Share preferences allows for access to these variables anywhere, even outside of where the
   * account in logged in
   */
  SharedPreferences mPreferences;
  SharedPreferences.Editor mEditor;

  /**
   * The player's account. It holds information about the player and can record its information
   */
  Account account;

  /**
   * Code to execute when the Activity is created.
   *
   * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_options);

    account = (Account) getIntent().getSerializableExtra("ac");
    mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    if (account.getCustomization()[0] == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }
  }

  /** Called when the user taps the "Red_Colour" or "Gray_Colour" button */
  public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    mEditor = mPreferences.edit();

    // Determine which radio button was clicked
    switch (view.getId()) {
      case R.id.gray_button_OptionsActivity:
        if (checked)
          getWindow().getDecorView().setBackgroundResource(R.color.background2);
        mEditor.putInt("Colour", 0);
        account.setBackground(0, getApplicationContext());
        break;
      case R.id.red_button_OptionsActivity:
        if (checked) mEditor.putInt("Colour", 1);
        getWindow().getDecorView().setBackgroundResource(R.color.background1);
        account.setBackground(1, getApplicationContext());
        break;
    }
    mEditor.apply();
  }

  /** Called when the user taps the "Back" button */
  public void toMainMenu(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }
}
