package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;

public class OptionsActivity extends BaseActivity {

  SharedPreferences mPreferences;
  SharedPreferences.Editor mEditor;
  Account account;

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
  public void onRadioButtonClicked(View v) {
    // Is the button now checked?
    boolean checked = ((RadioButton) v).isChecked();

    // Check which radio button was clicked
    mEditor = mPreferences.edit();
    int[] data = account.getCustomization();
    switch (v.getId()) {
      case R.id.gray_button_OptionsActivity:
        if (checked)
          getWindow().getDecorView().setBackgroundResource(R.color.background2);
        mEditor.putInt("Colour", 0);
        data[0] = 0;
        account.setCustomisation(data);
        break;
      case R.id.red_button_OptionsActivity:
        if (checked) mEditor.putInt("Colour", 1);
        getWindow().getDecorView().setBackgroundResource(R.color.background1);
        data[0] = 1;
        account.setCustomisation(data);
        break;
    }
    mEditor.apply();
  }

  /** Called when the user taps the "Back" button */
  public void toMainMenu(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    account.saveSettings(getApplicationContext());
    intent.putExtra("ac", account);
    startActivity(intent);
  }
}
