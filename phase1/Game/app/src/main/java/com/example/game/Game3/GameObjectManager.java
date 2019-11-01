package com.example.game.Game3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.game.R;

/**A Manager class for GameObjects.*/
public class GameObjectManager {

    private Resources res;
    private CharacterObject player;
    private CharacterObject enemy;
    private HealthBarObject playerHealth;
    private HealthBarObject enemyHealth;

    /**
     * A constructor for GameObjectManager.
     * */
    GameObjectManager(Resources res){
        this.res = res;
    }

    private void createObjects(){
        createPlayer();
        createEnemy();
        createEnemyHealthBar();
        createPlayerHealthBar();
    }

    /**
     * Creates a Character for the Player.
     * */
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
     * */
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
     * */
    private void createEnemy() {
        enemy = new CharacterObject();
        enemy.setSprite(BitmapFactory.decodeResource(res, R.drawable.enemy));
        enemy.setX(300);
        enemy.setY(800);
    }

    /**
     * Creates a Health Bar for the Player.
     * */
    private void createPlayerHealthBar() {
        playerHealth = new HealthBarObject();
        playerHealth.setX(100);
        playerHealth.setY(200);
        playerHealth.setColor(Color.GREEN);
        playerHealth.setPlayerName("PLAYER");
        playerHealth.setTextSize(50);
    }

    void draw(Canvas canvas, Paint paint){
        createObjects();
        player.draw(canvas, paint);
        enemy.draw(canvas, paint);
        enemyHealth.draw(canvas, paint);
        playerHealth.draw(canvas, paint);

    }
}
