package com.example.game.Game3;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.game.R;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.concurrent.TimeUnit;


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
    private Boolean attack = false;
    private Boolean defend = false;

    public Boolean getTurn() {
        return isTurn;
    }

    public void setTurn(Boolean turn) {
        isTurn = turn;
    }

    private Boolean isTurn = true;
    private MoveTextObject moveTextObject;
    private int[] enemyDamage = {5, 10, 15};
    private int hpDamage = 0;

    /**
     * A constructor for GameObjectManager.
     */
    GameObjectManager(Resources res) {
        this.res = res;
    }

    void createObjects() {
        createPlayer();
        createEnemy();
        createEnemyHealthBar();
        createPlayerHealthBar();
        createAttackButton();
        createDefendButton();
        createMoveText();
    }

    /**
     * Creates a Character for the Player.
     */
    private void createPlayer() {
        player = new CharacterObject();
        player.setSprite(BitmapFactory.decodeResource(res, R.drawable.player));
        player.setX(-500);
        player.setY(800);
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

    /**
     * Creates a Attack Button.
     */
    private void createAttackButton() {
        attackButton = new Button();
        attackButton.setButton(new Rect(155, 1700, 455, 1875));
        attackButton.setBtnColor(Color.BLACK);
        attackButton.setTextColor(Color.WHITE);
        attackButton.setBtnName("ATTACK");
        attackButton.setX(200);
        attackButton.setY(1800);
    }

    /**
     * Creates a Defend Button.
     */
    private void createDefendButton() {
        defendButton = new Button();
        defendButton.setButton(new Rect(655, 1700, 955, 1875));
        defendButton.setBtnColor(Color.BLACK);
        defendButton.setTextColor(Color.WHITE);
        defendButton.setBtnName("DEFEND");
        defendButton.setX(700);
        defendButton.setY(1800);
    }

    /**
     * Creates a Text to show Player and Enemy moves.
     */
    private void createMoveText() {
        moveTextObject = new MoveTextObject();
        moveTextObject.setTextColor(Color.WHITE);
        moveTextObject.setMoveText("");
        moveTextObject.setX(275);
        moveTextObject.setY(600);
    }

    void draw(Canvas canvas, Paint paint) {
        player.draw(canvas, paint);
        enemy.draw(canvas, paint);
        enemyHealth.draw(canvas, paint);
        playerHealth.draw(canvas, paint);
        attackButton.draw(canvas, paint);
        defendButton.draw(canvas, paint);
        moveTextObject.draw(canvas, paint);
    }

    void update() {
        if (isTurn) {
            moveTextObject.update("PLAYER TOOK " + hpDamage + " DAMAGE", Color.RED);
            attackButton.setActive(true);
            defendButton.setActive(true);
        } else {
            attackButton.setActive(false);
            defendButton.setActive(false);
            int damage = decideEnemyDamage();
            if (attack) {
                enemyHealth.update(10);
                moveTextObject.update("ENEMY TOOK " + 10 + " DAMAGE", Color.GREEN);
                hpDamage = damage;
                attack = false;
            }
            if (defend) {
                enemyHealth.update(5);
                moveTextObject.update("ENEMY TOOK " + 5 + " DAMAGE", Color.GREEN);
                hpDamage = damage / 2;
                defend = false;
            }
            playerHealth.update(hpDamage);
        }

    }

    private int decideEnemyDamage() {
        int damageIndex = new Random().nextInt(enemyDamage.length);
        return enemyDamage[damageIndex];
    }

    Boolean gameEnded() {
        return (enemyHealth.getHealthLevel() == 0 || playerHealth.getHealthLevel() == 0);
    }

    void onTouchEventHelper(MotionEvent event) {
        if (isTurn) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                float touchX = event.getX();
                float touchY = event.getY();
                if (attackButton.getButton().left <= touchX && touchX <=
                        attackButton.getButton().right && attackButton.getButton().top <= touchY &&
                        touchY <= attackButton.getButton().bottom) {
                    attack = true;
                    isTurn = false;
                }
                if (defendButton.getButton().left <= touchX && touchX <=
                        defendButton.getButton().right && defendButton.getButton().top <= touchY &&
                        touchY <= defendButton.getButton().bottom) {
                    defend = true;
                    isTurn = false;
                }
            }
        }

    }

    String checkWinner(){
        if (playerHealth.getHealthLevel() == 0){
            return "YOU WON!";
        }else{
            return "YOU LOST";
        }
    }
}
