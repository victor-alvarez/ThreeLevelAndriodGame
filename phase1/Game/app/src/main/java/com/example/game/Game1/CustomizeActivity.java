package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.BaseActivity;
import com.example.game.R;

public class CustomizeActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customize);
  }

  /** Called when the user taps the "Choose Ball" button */
  public void chooseBall(View view) {
    Intent intent = new Intent(this, ChooseBallActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "Change Song" button */
  public void changeSong(View view) {
    Intent intent = new Intent(this, ChangeSongActivity.class);
    startActivity(intent);
  }

  /** Called when the user taps the "X" button */
  public void toGame1Home(View view) {
    Intent intent = new Intent(this, Game1Activity.class);
    startActivity(intent);
  }
}
