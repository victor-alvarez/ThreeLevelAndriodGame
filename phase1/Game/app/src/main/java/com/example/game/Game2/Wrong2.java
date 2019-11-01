package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.R;

public class Wrong2 extends AppCompatActivity {
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_riddle2_wrong);
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /** Called when the user taps the "Back to the Riddle" button */
    public void back2(View view) {
        Intent intent = new Intent(this, Riddle2.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
