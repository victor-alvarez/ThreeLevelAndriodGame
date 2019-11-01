package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.R;

public class Wrong1 extends AppCompatActivity {
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_riddle1_wrong);
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /** Called when the user taps the "Back to the Riddle" button */
    public void back1(View view) {
        Intent intent = new Intent(this, Riddle1.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
