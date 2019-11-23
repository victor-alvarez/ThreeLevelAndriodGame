package com.example.game;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        account = (Account) getIntent().getSerializableExtra("ac");
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button changeIcon = findViewById(R.id.choose_icon);
        changeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeIconDialog(v.getContext());
            }
        });

        Button changeLang = findViewById(R.id.language_select_button);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }
    }

    /**
     * Called when the user taps the "Red_Colour" or "Gray_Colour" button
     */
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

    private void setNewLocale(String language) {
        localeManager.setNewLocale(this, language);

        Intent i = new Intent(this, OptionsActivity.class);
        i.putExtra("ac", account);
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
                    setNewLocale(LocaleManager.FRENCH);
                } else if (which == 1) {
                    setNewLocale(LocaleManager.ENGLISH);
                } else if (which == 2) {
                    setNewLocale(LocaleManager.RUSSIAN);
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
    private void showChangeIconDialog(final Context context) {
        final String[] listItems = {getString(R.string.male_icon), getString(R.string.female_icon),
                getString(R.string.robot_icon)};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(OptionsActivity.this);
        mBuilder.setTitle("Choose Icon...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    account.setIcon(0, context);
                } else if (which == 1) {
                    account.setIcon(1, context);
                } else if (which == 2) {
                    account.setIcon(2, context);
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
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
