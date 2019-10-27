package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class OptionsActivity extends AppCompatActivity {

    Button button;

    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (mPreferences.getInt("Colour", 0) == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        button = findViewById(R.id.backButton_OptionsActivity);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toMainMenu();
            }
        });
    }

    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        mEditor = mPreferences.edit();
        switch (v.getId()) {
            case R.id.gray_button_OptionsActivity:
                if (checked)
                    //android:setTheme(R.style.AppTheme2);
                    getWindow().getDecorView().setBackgroundResource(R.color.background2);
                    mEditor.putInt("Colour", 0);
                break;
            case R.id.red_button_OptionsActivity:
                if (checked)
                    mEditor.putInt("Colour", 1);
                    getWindow().getDecorView().setBackgroundResource(R.color.background1);
                break;
        }
        mEditor.apply();
    }

    public void toMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
