package com.example.game.viewLevel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import com.example.game.BaseActivity;
import com.example.game.R;
import com.example.game.models.LocaleManager;

import java.io.File;

/**
 * Options activity where the player may set their required customizations
 */
public class OptionsActivity extends BaseActivity {

    /**
     * Share preferences allows for access to these variables anywhere, even outside of where the
     * account in logged in. Used essentially only where there is no account.
     */
    private SharedPreferences mPreferences;

    /**
     * Code to execute when the Activity is created.
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button changeIcon = findViewById(R.id.choose_icon);
        changeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeIconDialog(v.getContext().getFilesDir());
            }
        });

        Button changeLang = findViewById(R.id.language_select_button);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

        getWindow().getDecorView().setBackgroundResource(account.getBackground());
    }

    /**
     * Called when the user taps the "Red_Colour" or "Gray_Colour" button
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        SharedPreferences.Editor mEditor = mPreferences.edit();

        // Determine which radio button was clicked
        switch (view.getId()) {
            case R.id.gray_button_OptionsActivity:
                if (checked)
                    getWindow().getDecorView().setBackgroundResource(R.color.background2);
                mEditor.putInt("Colour", 0);
                account.setBackground("grey", getApplicationContext().getFilesDir());
                break;
            case R.id.red_button_OptionsActivity:
                if (checked) mEditor.putInt("Colour", 1);
                getWindow().getDecorView().setBackgroundResource(R.color.background1);
                account.setBackground("red", getApplicationContext().getFilesDir());
                break;
        }
        mEditor.apply();
    }

    private void setNewLocale(String language) {
        localeManager.setNewLocale(this, language);

        Intent i = new Intent(this, OptionsActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Creates list dialog to choose new language
     */
    private void showChangeLanguageDialog() {
        final String[] listItems = {"Francais", "English", "русский"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(OptionsActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    setNewLocale(LocaleManager.getFrench());
                } else if (which == 1) {
                    setNewLocale(LocaleManager.getEnglish());
                } else if (which == 2) {
                    setNewLocale(LocaleManager.getRussian());
                }
                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();

        mDialog.show();

    }

    /**
     * Creates list dialog to choose new icon
     */
    private void showChangeIconDialog(final File contextFile) {
        final String[] listItems = {getString(R.string.male_icon), getString(R.string.female_icon),
                getString(R.string.robot_icon)};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(OptionsActivity.this);
        mBuilder.setTitle("Choose Icon...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    account.setIcon("male", contextFile);
                } else if (which == 1) {
                    account.setIcon("female", contextFile);
                } else if (which == 2) {
                    account.setIcon("robot", contextFile);
                }
                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();

        mDialog.show();

    }

    /**
     * Called when the user taps the "Back" button
     */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
