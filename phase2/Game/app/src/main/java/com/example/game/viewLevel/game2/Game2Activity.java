package com.example.game.viewLevel.game2;

//image used (free license):
//https://pixabay.com/illustrations/road-sign-attention-right-of-way-808733/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.BaseActivity;
import com.example.game.viewLevel.MainActivity;
import com.example.game.R;

public class Game2Activity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game2_title);

    getWindow().getDecorView().setBackgroundResource(account.getBackground());
  }

  /**
   *
   * @param view the view of button clicked
   * @param type the type of questions to be asked
   */
  public void toRiddles(View view, String type) {
    Intent intent = new Intent(this, RiddleActivity.class);
    intent.putExtra("type", type);
    startActivity(intent);
  }

  /**
   * Have easy trivia questions as the questions.
   * @param view the button clicked
   */
  public void easyTrivia(View view){
    toRiddles(view, "easyTrivia");
  }

  /**
   * Have hard trivia questions as the questions.
   * @param view the button clicked
   */
  public void hardTrivia(View view){
    toRiddles(view, "hardTrivia");
  }

  /**
   * Have riddle based questions as the questions.
   * @param view the button clicked
   */
  public void riddle(View view){
    toRiddles(view, "riddle");
  }

  /**
   * Called when the user taps the "To Main Menu" button. Takes User to main menu of the App.
   *
   * @param view The View of this Activity.
   */
  public void toMainMenu(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}
