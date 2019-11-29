package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.R;
import com.example.game.models.RiddleActions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class RiddleActivity extends AppCompatActivity implements RiddleActions {

    /**
     * Text displaying player stats
     */
    private TextView lives, scores;

    /**
     * Text displaying the question or result for this riddle
     */
    private TextView question, result;

    /**
     * Buttons for the answers to the riddle
     */
    private Button[] answers;

    /**
     * Button for going to the next riddle
     */
    private Button back;

    /**
     * OnClickListener for the correct answer button
     */
    private View.OnClickListener answer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            determineAnswer(view);
        }
    };

    /**
     * The numbers of the names of the remaining riddles
     */
    private ArrayList<Integer> remainingRiddles;

    /**
     * Created as an instance variable for more random psuedo-random number generation
     */
    private Random random = new Random();

    /**
     * Presenter for this view.
     */
    private RiddlePresenter presenter;

    /**
     * Array of question and answers of the most recent riddle.
     */
    private String[] riddleArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
        presenter = new RiddlePresenter(this, new RiddleUseCases());

        getWindow().getDecorView().setBackgroundResource(BaseActivity.account.getBackground());

        lives = findViewById(R.id.livesText_RiddleActivity);

        scores = findViewById(R.id.scoreText_RiddleActivity);

        answers = new Button[4];
        int size = getResources().getInteger(R.integer.numArrays);
        remainingRiddles = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            remainingRiddles.add(i);
        }

        result = findViewById(R.id.result_RiddleActivity);
        question = findViewById(R.id.question_RiddleActivity);

        back = findViewById(R.id.nextRiddle_RiddleActivity);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                populateRiddleIfAble();
            }
        });
        answers[0] = findViewById(R.id.a1_RiddleActivity);
        answers[1] = findViewById(R.id.a2_RiddleActivity);
        answers[2] = findViewById(R.id.a3_RiddleActivity);
        answers[3] = findViewById(R.id.a4_RiddleActivity);
        for (int i = 0; i < answers.length; i++){
            answers[i].setOnClickListener(answer);
        }

        populateRiddleIfAble();
    }

    /**
     * Populates the riddle with a random riddle. Will not repeat the same riddle in the same
     * playthrough. If there are no more riddles will go to the end screen for game 2.
     */
    private void populateRiddleIfAble() {
        presenter.nextRiddle(remainingRiddles);
    }

    /**
     * Determines whether the answer is right or wrong and reacts accordingly.
     * @param view actually a button, as this is activated as an onClickListener. It is the button
     *             for one of the answers to the Riddle.
     */
    private void determineAnswer(View view){
        presenter.determineRightOrWrong(riddleArray, ((Button) view).getText().toString());
    }

    @Override
    public void setNewRiddleText(){
        lives.setText(String.valueOf(BaseActivity.account.getHitPoints()));
        scores.setText(String.valueOf(BaseActivity.account.getCurrentScore()));

        try {
            String riddleResourceName = getRiddleResourceName();
            Class<R.array> res = R.array.class;
            Field field = res.getField(riddleResourceName);
            riddleArray = getApplicationContext().getResources().
                    getStringArray(field.getInt(null));

            question.setText(riddleArray[0]);
            question.setVisibility(View.VISIBLE);

            for (int i = 2; i < riddleArray.length; i++) {
                answers[i - 2].setText(riddleArray[i]);
                answers[i - 2].setVisibility(View.VISIBLE);
                answers[i - 2].setClickable(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        back.setClickable(false);
    }

    /**
     * Changes the view if the answer is correct.
     */
    @Override
    public void rightAnswer(){
        BaseActivity.account.incrementScore(5, getApplicationContext());
        result.setText(getResources().getString(R.string.correct));
        changeVisibility();
    }

    /**
     * Changes the view if the answer is incorrect.
     */
    @Override
    public void wrongAnswer(){
        BaseActivity.account.decrementHitPoints(5, getApplicationContext());
        result.setText(getResources().getString(R.string.Nope));
        changeVisibility();
    }

    /**
     * Finishes all the riddles; moves the the end screen activity for game 2.
     */
    @Override
    public void finishRiddles() {
        Intent intent = new Intent(this, Win.class);
        startActivity(intent);
    }

    /**
     * Changes visibility of the buttons and text fields so the question and answers buttons are
     * non-visible and non-clickable, while making it so then the result and next riddle buttons
     * are.
     */
    private void changeVisibility(){
        question.setVisibility(View.INVISIBLE);
        for (int i = 0; i < answers.length; i++) {
            answers[i].setVisibility(View.INVISIBLE);
            answers[i].setClickable(false);
        }

        result.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        back.setClickable(true);
    }

    /**
     * Uses pseudo-randomness to
     * @return the name of a random not already used riddle resource
     */
    private String getRiddleResourceName(){
        Integer num = remainingRiddles.get(random.nextInt(remainingRiddles.size()));
        String str = "riddle";
        str += num;
        remainingRiddles.remove(num);
        return str;
    }
}
