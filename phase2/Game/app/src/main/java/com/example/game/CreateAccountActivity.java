package com.example.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.game.Domain.CreateAccountActions;

public class CreateAccountActivity extends BaseActivity implements CreateAccountActions {

    /**
     * Text field which contains the user input
     */
    private EditText inputName;

    /**
     * Shared preference used to determine background colour
     */
    private SharedPreferences mPreferences;

    /**
     * Text displayed to show the success of the create account button
     */
    private TextView textView;

    /**
     * Determines the existence of a users account on the system and creates new accounts
     */
    private AccountManager accountManager = new AccountManager();

    private CreateAccountPresenter presenter;

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

        presenter = new CreateAccountPresenter(this, new CreateAccountUseCases());

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
        presenter.createAccount(inputName.getText().toString(), getApplicationContext());
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

    /**
     * If account creation has failed then display a message stating so for the user.
     */
    @Override
    public void accountCreationFailed() {
        textView.setText(getResources().getText(R.string.account_already_exists));
        if (mPreferences.getInt("Colour", 0) == 1) {
            textView.setTextColor(getResources().getColor(R.color.background2));
        } else {
            textView.setTextColor(getColor(R.color.background1));
        }
    }

    /**
     * If account create has succeded display a message stating so for the user.
     */
    @Override
    public void accountCreationSuccess() {
        textView.setText(getResources().getText(R.string.account_created));
        textView.setTextColor(getColor(R.color.font1));
    }
}
