package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText inputName;
    SharedPreferences mPreferences;
    Account account;
    TextView textView;
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
        Account tempAccount = accountManager.openExistingAccount(inputName.getText().toString(),
                getApplicationContext());
        if (tempAccount != null) {
            account = tempAccount;
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
