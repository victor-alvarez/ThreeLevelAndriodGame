package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.Game3.Game3Activity;
import com.example.game.R;

public class Win extends AppCompatActivity {
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /** Called when the user taps the "To Game Three" button */
    public void nextGame(View view) {
        Intent intent = new Intent(this, Game3Activity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}