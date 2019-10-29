package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.game.Game2Activity;
import com.example.game.MainActivity;
import com.example.game.R;

public class Game1Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game1);
  }

  /** Called when the user taps the "Play" button */
  public void playGame(View view) {
    Intent intent = new Intent(this, BallJumperActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "Customize" button */
  public void toCustomization(View view) {
    Intent intent = new Intent(this, CustomizeActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "Shop" button */
  public void toShop(View view) {
    Intent intent = new Intent(this, ShopActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "To Game Two" button */
  public void nextGame(View view) {
    Intent intent = new Intent(this, Game2Activity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "To Main Menu" button */
  public void toMainMenu(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}
