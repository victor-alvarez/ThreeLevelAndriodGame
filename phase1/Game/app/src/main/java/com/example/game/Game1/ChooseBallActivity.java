package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.game.R;

public class ChooseBallActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose_ball);
  }

  /** Called when the user taps the "X" button */
  public void toCustomize(View view) {
    Intent intent = new Intent(this, CustomizeActivity.class);
    startActivity(intent);
  }
}
