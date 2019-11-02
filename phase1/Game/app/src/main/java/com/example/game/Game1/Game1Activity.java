package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.Game2.Game2Activity;
import com.example.game.MainActivity;
import com.example.game.R;

public class Game1Activity extends BaseActivity {

  Account account;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game1);

    account = (Account) getIntent().getSerializableExtra("ac");

    if (account.getCustomization()[0] == 1) {
      getWindow().getDecorView().setBackgroundResource(R.color.background1);
    }
  }

  /** Called when the user taps the "Play" button */
  public void playGame(View view) {
    Intent intent = new Intent(this, BallJumperActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }

  /** Called when the user taps the "Customize" button
  public void toCustomization(View view) {
    Intent intent = new Intent(this, CustomizeActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }
   */

  /** Called when the user taps the "Shop" button
  public void toShop(View view) {
    Intent intent = new Intent(this, ShopActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }*/

  /** Called when the user taps the "To Main Menu" button */
  public void toMainMenu(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.putExtra("ac", account);
    startActivity(intent);
  }
}
