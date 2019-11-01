package com.example.game.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.MainActivity;
import com.example.game.R;

public class Game3ExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_exit);
    }

    /** Called when the user taps the "Retry" button */
    public void retry(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        //intent.putExtra("ac", account);
        startActivity(intent);
    }

    public void toHome(View view) {
        Intent intent = new Intent(this, Game3Activity.class);
        //intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps the "To Main Menu" button */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("ac", account);
        startActivity(intent);
    }
}
