package com.example.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity extends BaseActivity {

    /**
     * Text field which contains the user input
     */
    EditText inputName;

    /**
     * Shared preference used to determine background colour
     */
    SharedPreferences mPreferences;

    /**
     * Text displayed to show the success of the create account button
     */
    TextView textView;

    /**
     * Determines the existence of a users account on the system and creates new accounts
     */
    private AccountManager accountManager = new AccountManager();

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
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

    /**
     * Creates a new account if one with the login name does not already exist.
     *
     * @param view the create account button's view
     */
    public void createAccount(View view) {
        Account tempAccount = accountManager.openExistingAccount(inputName.getText().toString(),
                getApplicationContext());
        if (tempAccount == null) {
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

    /**
     * Called when the user taps the "Back" button
     */
    public void toLoginMenu(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the "Back" button
     */
    public void deleteData(View view) {
        accountManager.deleteAccountData(getApplicationContext());
    }
}
