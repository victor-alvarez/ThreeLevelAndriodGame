package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Game2Activity;

public class Game1Activity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(new GamePanel(this));
  }

  /** Called when the user taps the "To Game Two" button */
  public void nextGame(View view) {
    Intent intent = new Intent(this, Game2Activity.class);
    startActivity(intent);
  }
}
