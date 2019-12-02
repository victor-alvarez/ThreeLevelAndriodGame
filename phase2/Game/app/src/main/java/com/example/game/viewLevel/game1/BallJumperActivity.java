package com.example.game.viewLevel.game1;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.BaseActivity;
import com.example.game.models.game1.AnimationFactoryImpl;
import com.example.game.models.game1.AnimationManagerFactoryImpl;
import com.example.game.models.game1.ObstacleFactoryImpl;
import com.example.game.models.game1.Constants;
import com.example.game.models.game1.ModelFactories;
import com.example.game.models.game1.ObstacleManagerFactoryImpl;
import com.example.game.models.game1.OrientationDataFactoryImp;
import com.example.game.models.game1.RectPlayerFactoryImpl;
import com.example.game.presenters.game1.SceneFactoryImp;
import com.example.game.presenters.game1.PresenterFactories;
import com.example.game.presenters.game1.Game1PresenterFactoryImp;

public class BallJumperActivity extends BaseActivity {

    /**
     * The activity that is commenced once the "Play" or "Retry" button is pressed in Game1.


    // === Instance Variables ===

    /**
     * Creates the GamePanel that is displayed on screen.
     *
     * @param savedInstanceState the saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow()
                .setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        ModelFactories.OBSTACLE_FACTORY = new ObstacleFactoryImpl();
        ModelFactories.RECT_PLAYER_FACTORY = new RectPlayerFactoryImpl();
        ModelFactories.OBSTACLE_MANAGER_FACTORY = new ObstacleManagerFactoryImpl();
        ModelFactories.ANIMATION_FACTORY = new AnimationFactoryImpl();
        ModelFactories.ANIMATION_MANAGER_FACTORY = new AnimationManagerFactoryImpl();
        ModelFactories.ORIENTATION_DATA_FACTORY = new OrientationDataFactoryImp();
        PresenterFactories.SCENE_FACTORY = new SceneFactoryImp();
        PresenterFactories.SCENE_PRESENTER_FACTORY = new Game1PresenterFactoryImp();
        Game1ViewFactory game1ViewFactory = ViewFactories.GAME1_VIEW_FACTORY;
        Game1View game1View = game1ViewFactory.makeGame1ViewImpl(this);
        game1View.setDifficulty(getIntent().getStringExtra("difficulty"));
        setContentView((SurfaceView) game1View);
    }

    /**
     * Starts the GameOverActivity and updates the account with Game1 statistics.
     *
     * @param score     the score from Game1.
     * @param hitPoints the hit-points from Game1.
     */
    public void gameOver(int score, int hitPoints, String difficulty) {
        Intent intent = new Intent(this, GameOverActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("difficulty", difficulty);
        account.incrementLevel(getApplicationContext().getFilesDir());
        account.incrementScore(score, getApplicationContext().getFilesDir());
        account.decrementHitPoints(hitPoints, getApplicationContext().getFilesDir());
        account.incrementGamesPlayed(getApplicationContext().getFilesDir());
        startActivity(intent);
    }

    /**
     * Stops this activity.
     */
    @Override
    public void onStop() {
        super.onStop();
        finish();
    }
}
