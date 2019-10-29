package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.game.R;

public class ShopActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
  }

  /** Called when the user taps the "X" button */
  public void toGame1Home(View view) {
    Intent intent = new Intent(this, Game1Activity.class);
    startActivity(intent);
  }
}
