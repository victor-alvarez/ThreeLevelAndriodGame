package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Game3Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game3);
  }

  /** Called when the user taps the "To Main Menu" button */
  public void toMainMenu(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}
