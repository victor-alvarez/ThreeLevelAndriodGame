package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class RiddleActivity extends AppCompatActivity {
    private Account account;

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
    private View.OnClickListener correct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rightAnswer();
        }
    };

    /**
     * OnClickListeners for the incorrect answer buttons
     */
    private View.OnClickListener incorrect = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            wrongAnswer();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
        account = (Account) getIntent().getSerializableExtra("ac");

        getWindow().getDecorView().setBackgroundResource(account.getBackground());

        lives = findViewById(R.id.livesText_RiddleActivity);
        lives.setText(String.valueOf(account.getHitPoints()));

        answers = new Button[4];
        int size = getResources().getInteger(R.integer.numArrays);
        remainingRiddles = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            remainingRiddles.add(i);
        }

        scores = findViewById(R.id.scoreText_RiddleActivity);
        scores.setText(String.valueOf(account.getCurrentScore()));

        result = findViewById(R.id.result_RiddleActivity);
        question = findViewById(R.id.question_RiddleActivity);

        back = findViewById(R.id.nextRiddle_RiddleActivity);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                populateRiddle();
            }
        });
        answers[0] = findViewById(R.id.a1_RiddleActivity);
        answers[1] = findViewById(R.id.a2_RiddleActivity);
        answers[2] = findViewById(R.id.a3_RiddleActivity);
        answers[3] = findViewById(R.id.a4_RiddleActivity);
        populateRiddle();
    }

    /**
     * Populates the riddle with a random riddle. Will not repeat the same riddle in the same
     * playthrough.
     */
    private void populateRiddle() {
        if(remainingRiddles.size() == 0){
            finishRiddles();
            return;
        }
        try {
            String riddleResourceName = getRiddleResourceName();
            Class<R.array> res = R.array.class;
            Field field = res.getField(riddleResourceName);
            String[] array = getApplicationContext().getResources().
                    getStringArray(field.getInt(null));

            question.setText(array[0]);
            question.setVisibility(View.VISIBLE);



            for (int i = 2; i < array.length; i++) {
                answers[i - 2].setText(array[i]);
                answers[i - 2].setVisibility(View.VISIBLE);
                answers[i - 2].setClickable(true);
                answers[i - 2].setOnClickListener(incorrect);
            }
            answers[Integer.parseInt(array[1])].setOnClickListener(correct);

        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        back.setClickable(false);
    }

    private String getRiddleResourceName(){
        Integer num = remainingRiddles.get(random.nextInt(remainingRiddles.size()));
        String str = "riddle";
        str += num;
        remainingRiddles.remove(num);
        return str;
    }

    private void rightAnswer(){
        result.setText(getResources().getString(R.string.correct));
        changeVisibility();
    }

    private void wrongAnswer(){
        result.setText(getResources().getString(R.string.Nope));
        changeVisibility();
    }

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

    public void finishRiddles() {
        Intent intent = new Intent(this, Win.class);
        // Resets most of the values for the player as they are starting a new game
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
