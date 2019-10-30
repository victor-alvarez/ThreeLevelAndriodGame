package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Game3Activity;
import com.example.game.R;

public class Game2Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2);
  }

  /** Called when the user taps the "To Game Three" button */
  public void nextGame(View view) {
    Intent intent = new Intent(this, Game3Activity.class);
    startActivity(intent);
  }
}
