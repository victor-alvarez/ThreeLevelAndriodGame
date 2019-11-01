package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.R;

public class Riddle1 extends AppCompatActivity {
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_riddle1);
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /** Called when the user taps the "Centillion" button */
    public void rightGuess1(View view) {
        Intent intent = new Intent(this, Riddle2.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps any other button */
    public void wrongGuess1(View view) {
        Intent intent = new Intent(this, Wrong1.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
