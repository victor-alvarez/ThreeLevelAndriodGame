package com.example.game.Game3;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.game.R;

/**
 * A Manager class for GameObjects.
 */
public class GameObjectManager {

    private Resources res;
    private CharacterObject player;
    private CharacterObject enemy;
    private HealthBarObject playerHealth;
    private HealthBarObject enemyHealth;
    private Button attackButton;
    private Button defendButton;

    /**
     * A constructor for GameObjectManager.
     */
    GameObjectManager(Resources res) {
        this.res = res;
    }

    private void createObjects() {
        createPlayer();
        createEnemy();
        createEnemyHealthBar();
        createPlayerHealthBar();
        createAttackButton();
        createDefendButton();
    }

    /**
     * Creates a Character for the Player.
     */
    private CharacterObject createPlayer() {
        //Bitmap sprite = BitmapFactory.decodeResource(res, R.drawable.character_sprite);

        player = new CharacterObject();
        player.setSprite(BitmapFactory.decodeResource(res, R.drawable.player));
        player.setX(-500);
        player.setY(800);
        return player;
    }

    /**
     * Creates a Health Bar for the Enemy.
     */
    private void createEnemyHealthBar() {
        enemyHealth = new HealthBarObject();
        enemyHealth.setX(600);
        enemyHealth.setY(200);
        enemyHealth.setColor(Color.RED);
        enemyHealth.setPlayerName("ENEMY");
        enemyHealth.setTextSize(50);
    }

    /**
     * Creates a Character for the Enemy.
     */
    private void createEnemy() {
        enemy = new CharacterObject();
        enemy.setSprite(BitmapFactory.decodeResource(res, R.drawable.enemy));
        enemy.setX(300);
        enemy.setY(800);
    }

    /**
     * Creates a Health Bar for the Player.
     */
    private void createPlayerHealthBar() {
        playerHealth = new HealthBarObject();
        playerHealth.setX(100);
        playerHealth.setY(200);
        playerHealth.setColor(Color.GREEN);
        playerHealth.setPlayerName("PLAYER");
        playerHealth.setTextSize(50);
    }

    private void createAttackButton() {
        attackButton = new Button();
        attackButton.setButton(new Rect(155, 1700, 455, 1875));
        attackButton.setBtnColor(Color.BLACK);
        attackButton.setTextColor(Color.WHITE);
        attackButton.setBtnName("ATTACK");
        attackButton.setX(200);
        attackButton.setY(1800);
    }

    private void createDefendButton() {
        defendButton = new Button();
        defendButton.setButton(new Rect(655, 1700, 955, 1875));
        defendButton.setBtnColor(Color.BLACK);
        defendButton.setTextColor(Color.WHITE);
        defendButton.setBtnName("DEFEND");
        defendButton.setX(700);
        defendButton.setY(1800);
    }

    void draw(Canvas canvas, Paint paint) {
        createObjects();
        player.draw(canvas, paint);
        enemy.draw(canvas, paint);
        enemyHealth.draw(canvas, paint);
        playerHealth.draw(canvas, paint);
        attackButton.draw(canvas, paint);
        defendButton.draw(canvas, paint);

    }
}
