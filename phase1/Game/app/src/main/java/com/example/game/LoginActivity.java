package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Login activity for login the user in. Lets the user enter a username and if it exists they may
 * then sign into that account and play the game.
 */
public class LoginActivity extends BaseActivity {

    /**
     * Text field which contains the user input
     */
    EditText inputName;

    /**
     * Shared preference used to determine background colour
     */
    SharedPreferences mPreferences;

    /**
     * Text displayed to show if the input is not an existing account
     */
    TextView textView;

    /**
     * Determines the existence of a users account on the system and creates an account object for
     * them to login with.
     */
    private AccountManager accountManager = new AccountManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputName = findViewById(R.id.accountNameText_LoginActivity);
        textView = findViewById(R.id.textView_LoginActivity);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (mPreferences.getInt("Colour", 0) == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
            textView.setTextColor(getResources().getColor(R.color.background2));
        }
    }

    /** Called when the user taps the "Select Account" button */
    public void login(View view) {
        Account account;
        account = accountManager.openExistingAccount(inputName.getText().toString(),
                getApplicationContext());

        //If account with name exists, login with that account. If not display that is does not.
        if (account != null) {
            Intent intent = new Intent(this, MainActivity.class);
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
