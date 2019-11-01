package com.example.game.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.MainActivity;
import com.example.game.R;

public class Game3ExitActivity extends AppCompatActivity {

    TextView gameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_exit);
        TextView gameResult = (TextView) findViewById(R.id.gameResult);
        gameResult.setText(getIntent().getStringExtra("EXTRA_WINNER"));
        gameResult.setTextColor(Color.BLUE);
        gameResult.setTextSize(50);
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
