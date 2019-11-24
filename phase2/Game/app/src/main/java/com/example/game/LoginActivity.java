package com.example.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.game.Domain.LoginActions;

/**
 * Login activity for login the user in. Lets the user enter a username and if it exists they may
 * then sign into that account and play the game.
 */
public class LoginActivity extends BaseActivity implements LoginActions {

    /**
     * Text field which contains the user input
     */
    private EditText inputName;

    /**
     * Shared preference used to determine background colour
     */
    //TODO: Since all activities use this, move to superclass?
    private SharedPreferences mPreferences;

    /**
     * Text displayed to show if the input is not an existing account
     */
    private TextView textView;

    /**
     * Determines the existence of a users account on the system and creates an account object for
     * them to login with.
     */
    private AccountManager accountManager = new AccountManager();

    /**
     * Presenter which interacts with the login for this activity.
     */
    private LoginPresenter loginPresenter;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputName = findViewById(R.id.accountNameText_LoginActivity);
        textView = findViewById(R.id.textView_LoginActivity);
        loginPresenter = new LoginPresenter(this, new LoginUseCases());

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (mPreferences.getInt("Colour", 0) == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
            textView.setTextColor(getResources().getColor(R.color.background2));
        }
    }

    /**
     * Called when the user taps the "Select Account" button. Will attempt a login based off the
     * currently entered in textfield inputName.
     */
    public void login(View view) {
        loginPresenter.login(inputName.getText().toString(), getApplicationContext());
    }

    /**
     * Called when the user taps the "Create Account" button
     */
    public void createAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    @Override
    public void incorrectUsername() {
        textView.setText(R.string.invalid_username);
    }

    @Override
    public void moveToMainMenu(Account account) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
