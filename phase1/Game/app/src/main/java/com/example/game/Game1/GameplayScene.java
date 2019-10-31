package com.example.game.Game1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import java.util.ArrayList;

public class GameplayScene implements Scene {

    private RectPlayer player;
    private Point playerPoint;
    private ObstacleManager obstacleManager;
    private PlatformHandler platformHandler;
    private boolean movingPlayer = false;
    private boolean gameOver = false;
    private long gameOverTime;
    private Rect r = new Rect();
    private int score; // Score for the game
    private int lives; // Lives for the game

    public GameplayScene() {
        player = new RectPlayer(new Rect(100, 100, 200, 200), Color.rgb(255, 0, 0));
        playerPoint = new Point(Constants.SCREEN_WIDTH/2, 3 * Constants.SCREEN_HEIGHT/4);
        player.update(playerPoint);
        obstacleManager = new ObstacleManager(200, 350, 75, Color.BLACK);
        platformHandler = new PlatformHandler(Color.BLUE);
        lives = 3;
    }

    @Override
    public void terminate() {
        SceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        player.draw(canvas);
        platformHandler.draw(canvas);
        obstacleManager.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);
        // Draw score
        canvas.drawText("" + score, 50, 50 + paint.descent() - paint.ascent(), paint);
        // Draw lives
        paint.setColor(Color.GREEN);
        canvas.drawText("Lives: " + lives, 1*Constants.SCREEN_WIDTH/2, 50 + paint.descent() - paint.ascent(), paint);
    }

    @Override
    public void update() {
        if (!gameOver) {
            player.update(playerPoint);
            ArrayList<Obstacle> obstacles = obstacleManager.getObstacles();
            // If obstacle goes off screen remove it, then add to our score
            if (obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
                obstacles.remove(obstacles.size() - 1);
                score++;
            }
            obstacleManager.update();
            // When player gets hit subtract lives
            if (obstacleManager.playerCollide(player)) {
                lives --;
                reset();
            }
            // If player has no lives go to GameOverActivity
            if (lives == 0) {
                ((BallJumperActivity) Constants.CURRENT_CONTEXT).gameOver(score);
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
            }
        }
    }

    @Override
    public void receiveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!gameOver && player.getRectangle().contains((int) event.getX(), (int) event.getY())) {
                    movingPlayer = true;
                }
                if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
                    reset();
                    gameOver = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (!gameOver && movingPlayer) {
                    playerPoint.set((int) event.getX(), (int) event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }
    }

    private void drawCenterText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }

    public void reset() {
        playerPoint = new Point(Constants.SCREEN_WIDTH/2, 3 * Constants.SCREEN_HEIGHT/4);
        player.update(playerPoint);
        obstacleManager = new ObstacleManager(200, 350, 75, Color.BLACK);
        movingPlayer = false;
    }
}
