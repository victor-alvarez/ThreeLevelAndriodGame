package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over2);

        getWindow().getDecorView().setBackgroundResource(BaseActivity.account.getBackground());
    }

    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        BaseActivity.account.resetValues(getApplicationContext());
        startActivity(intent);
    }
}
