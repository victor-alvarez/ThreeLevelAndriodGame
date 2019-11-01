package com.example.game.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.MainActivity;
import com.example.game.R;

public class Game3Activity extends BaseActivity {

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /**
     * Called when the user taps the "To Main Menu" button
     */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Called when user taps the "Play" Button.
     */
    public void toPlay(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        startActivity(intent);
    }
}
