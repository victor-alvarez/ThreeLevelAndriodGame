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

    /**
     * The Resources needed to access some files in creating objects.
     */
    private Resources res;

    /**
     * The Player CharacterObject who will be represented by the User.
     */
    private CharacterObject player;

    /**
     * The Enemy CharacterObject who will be represented by the Computer AI.
     */
    private CharacterObject enemy;

    /**
     * The Player's Health Bar.
     */
    private HealthBarObject playerHealth;

    /**
     * The Enemy's Health Bar.
     */
    private HealthBarObject enemyHealth;

    /**
     * The Attack Button.
     */
    private Button attackButton;

    /**
     * The Defend Button.
     */
    private Button defendButton;

    /**
     * Checks whether the Player decides to attack or not.
     */
    private Boolean attack = false;

    /**
     * Checks whether the Player decides to defend or not.
     */
    private Boolean defend = false;

    /**
     * The statistic that tracks hitpoints at the end (0 if User loses, 2*remaing Health Level if
     * player wins).
     */
    private int hitpoints = 0;

    /**
     * Number of moves made by the player to win/lose the game.
     */
    private int numMoves = 0;

    /**
     * Getter for number of moves.
     *
     * @return numMoves : The number of moves for the Player.
     */
    public int getNumMoves() {
        return numMoves;
    }

    /**
     * Setter for number of moves.
     *
     * @param numMoves: The number of moves for the Player.
     */
    public void setNumMoves(int numMoves) {
        this.numMoves = numMoves;
    }

    /**
     * Getter for hitpoints.
     *
     * @return hitpoints : The hitpoints for the Player.
     */
    public int getHitpoints() {
        return hitpoints;
    }

    /**
     * Setter for hitpoints.
     *
     * @param hitpoints : The hitpoints for the Player.
     */
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    /**
     * Getter for isTurn.
     *
     * @return isTurn : Checks if it' the user's turn.
     */
    public Boolean getTurn() {
        return isTurn;
    }

    /**
     * Getter for isTurn.
     *
     * @param turn : Checks if it' the user's turn.
     */
    public void setTurn(Boolean turn) {
        isTurn = turn;
    }

    private Boolean isTurn = true;
    private MoveTextObject moveTextObject;
    private int[] enemyDamage = {5, 9, 12, 11, 11, 10, 15, 15};
    private int hpDamage = 0;

    /**
     * A constructor for GameObjectManager.
     */
    GameObjectManager(Resources res) {
        this.res = res;
    }

    /**
     * Creates all the Objects required for this game by calling corresponding methods.
     */
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
        enemyHealth.setPlayerName(res.getString(R.string.enemy) + res.getString(R.string.hp));
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
        playerHealth.setPlayerName(res.getString(R.string.player) + res.getString(R.string.hp));
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
        attackButton.setBtnName(res.getString(R.string.attack));
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
        defendButton.setBtnName(res.getString(R.string.defend));
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

    /**
     * Draws all the Game 3 Objects on given canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    void draw(Canvas canvas, Paint paint) {
        player.draw(canvas, paint);
        enemy.draw(canvas, paint);
        enemyHealth.draw(canvas, paint);
        playerHealth.draw(canvas, paint);
        attackButton.draw(canvas, paint);
        defendButton.draw(canvas, paint);
        moveTextObject.draw(canvas, paint);
    }

    /**
     * Updates the GameObjects that require updates.
     */
    void update() {
        if (isTurn) {

            //Prints the Damage the enemy did to the player.
            moveTextObject.update(res.getString(R.string.player_took) + hpDamage +
                    res.getString(R.string.damage), Color.RED);
            attackButton.setActive(true);
            defendButton.setActive(true);
        } else {
            attackButton.setActive(false);
            defendButton.setActive(false);
            int damage = decideEnemyDamage();
            if (attack) {

                //Player does 12 HP damage if he/she tapped AttackButton
                enemyHealth.update(12);

                //Player gets full damage decided randomly by decideEnemyDamage method if Attack
                // button was tapped.
                moveTextObject.update(res.getString(R.string.enemy_took) + 10 +
                        res.getString(R.string.damage), Color.GREEN);
                hpDamage = damage;
                attack = false;
            }
            if (defend) {

                //Player does 7 damage if he/she tapped DefendButton
                enemyHealth.update(7);

                //Player gets half damage if decided to press Defend button.
                moveTextObject.update(res.getString(R.string.enemy_took) + 5 +
                        res.getString(R.string.damage), Color.GREEN);
                hpDamage = damage / 2;
                defend = false;
            }
            playerHealth.update(hpDamage);
        }

    }

    /**
     * Randomly decides how much attack the Enemy should deal. Based on picking a number randomly
     * from an array of possible hp damage choices.
     */
    private int decideEnemyDamage() {
        int damageIndex = new Random().nextInt(enemyDamage.length);
        return enemyDamage[damageIndex];
    }

    /**
     * Checks if the game has ended (when either of the Player's health has reached 0.
     */
    Boolean gameEnded() {
        return (enemyHealth.getHealthLevel() == 0 || playerHealth.getHealthLevel() == 0);
    }

    /**
     * Checks if the game has ended (when either of the Player's health has reached 0).
     */
    void onTouchEventHelper(MotionEvent event) {
        if (isTurn) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                float touchX = event.getX();
                float touchY = event.getY();

                //Checks if the AttackButton was tapped. If so, player's turn is over.
                if (attackButton.getButton().left <= touchX && touchX <=
                        attackButton.getButton().right && attackButton.getButton().top <= touchY &&
                        touchY <= attackButton.getButton().bottom) {
                    attack = true;
                    isTurn = false;
                    numMoves += 1;
                }

                //Checks if the DefendButton was tapped. If so, player's turn is over.
                if (defendButton.getButton().left <= touchX && touchX <=
                        defendButton.getButton().right && defendButton.getButton().top <= touchY &&
                        touchY <= defendButton.getButton().bottom) {
                    defend = true;
                    isTurn = false;
                    numMoves += 1;
                }
            }
        }

    }

    /**
     * Check's which one of the CharacterObjects is the winner (The enemy or the Player) and return
     * string that displays the result of the game. Also updates the hitpoints for the player.
     *
     * @return result : The result of the game.
     */
    String checkWinner() {
        if (playerHealth.getHealthLevel() == 0) {
            return res.getString(R.string.lost);
        } else {
            return res.getString(R.string.win);
        }
    }

    /**
     * Updates the hitpoints after the game is done.
     */
    int updateHitpoints() {
        if (playerHealth.getHealthLevel() == 0) {
            setHitpoints(0);
        } else {
            setHitpoints(2 * playerHealth.getHealthLevel());
        }
        return getHitpoints();
    }
}
