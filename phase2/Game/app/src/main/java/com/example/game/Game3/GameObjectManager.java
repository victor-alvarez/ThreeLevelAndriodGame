package com.example.game.Game3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.example.game.R;

import java.util.Random;


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
     * The Attack ButtonObject.
     */
    private ButtonObject attackButtonObject;

    /**
     * The Defend ButtonObject.
     */
    private ButtonObject defendButtonObject;

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

    private boolean animate;
    private int animateFrame = 0;
    private int screenHeight;
    private int screenWidth;


    private int waitTime = 0;

    int getWaitTime() {
        return waitTime;
    }

    void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    /**
     * Getter for number of moves.
     *
     * @return numMoves : The number of moves for the Player.
     */
    int getNumMoves() {
        return numMoves;
    }

    /**
     * Setter for number of moves.
     *
     * @param numMoves: The number of moves for the Player.
     */
    void setNumMoves(int numMoves) {
        this.numMoves = numMoves;
    }

    /**
     * Getter for hitpoints.
     *
     * @return hitpoints : The hitpoints for the Player.
     */
    int getHitpoints() {
        return hitpoints;
    }

    /**
     * Setter for hitpoints.
     *
     * @param hitpoints : The hitpoints for the Player.
     */
    void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    /**
     * Getter for isTurn.
     *
     * @return isTurn : Checks if it' the user's turn.
     */
    Boolean getTurn() {
        return isTurn;
    }

    /**
     * Getter for isTurn.
     *
     * @param turn : Checks if it' the user's turn.
     */
    void setTurn(Boolean turn) {
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
        DisplayMetrics display = res.getDisplayMetrics();
        screenHeight = display.heightPixels;
        screenWidth = display.widthPixels;
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
        Bitmap[] sprites = new Bitmap[5];
        Matrix m = new Matrix();
        m.preScale(1, 1);
        Bitmap characterSprite = BitmapFactory.decodeResource(res, R.drawable.charactersprite);
        int w = characterSprite.getWidth() / 5;
        Bitmap f11 = Bitmap.createBitmap(characterSprite, 0, 0, w, characterSprite.getHeight(), m, false);
        Bitmap f22 = Bitmap.createBitmap(characterSprite, w, 0, w, characterSprite.getHeight(), m, false);
        Bitmap f33 = Bitmap.createBitmap(characterSprite, 2 * w, 0, w, characterSprite.getHeight(), m, false);
        Bitmap f44 = Bitmap.createBitmap(characterSprite, 3 * w, 0, w, characterSprite.getHeight(), m, false);
        Bitmap f55 = Bitmap.createBitmap(characterSprite, 4 * w, 0, w, characterSprite.getHeight(), m, false);
        Bitmap resizedBitmap1 = Bitmap.createScaledBitmap(f11, 300, 300, false);
        Bitmap resizedBitmap2 = Bitmap.createScaledBitmap(f22, 300, 300, false);
        Bitmap resizedBitmap3 = Bitmap.createScaledBitmap(f33, 300, 300, false);
        Bitmap resizedBitmap4 = Bitmap.createScaledBitmap(f44, 300, 300, false);
        Bitmap resizedBitmap5 = Bitmap.createScaledBitmap(f55, 300, 300, false);

        sprites[0] = resizedBitmap1;
        sprites[1] = resizedBitmap2;
        sprites[2] = resizedBitmap3;
        sprites[3] = resizedBitmap4;
        sprites[4] = resizedBitmap5;

        player.setSpriteAnimate(sprites);
        player.setSprite(BitmapFactory.decodeResource(res, R.drawable.player));
        player.setX(screenWidth / 6);
        player.setY(screenHeight / 2);
    }

    /**
     * Creates a Health Bar for the Enemy.
     */
    private void createEnemyHealthBar() {
        enemyHealth = new HealthBarObject();
        enemyHealth.setX(3*screenWidth/5);
        enemyHealth.setY(screenHeight/10);
        enemyHealth.setColor(Color.RED);
        enemyHealth.setPlayerName(res.getString(R.string.enemy) + res.getString(R.string.hp));
        enemyHealth.setTextSize(50);
    }

    /**
     * Creates a Character for the Enemy.
     */
    private void createEnemy() {
        enemy = new CharacterObject();
        Bitmap[] sprites = new Bitmap[5];
        Matrix m = new Matrix();
        m.preScale(1, 1);
        Bitmap enemySprite = BitmapFactory.decodeResource(res, R.drawable.enemysprite);
        int w = enemySprite.getWidth() / 5;
        Bitmap f11 = Bitmap.createBitmap(enemySprite, 0, 0, w, enemySprite.getHeight(), m, false);
        Bitmap f22 = Bitmap.createBitmap(enemySprite, w, 0, w, enemySprite.getHeight(), m, false);
        Bitmap f33 = Bitmap.createBitmap(enemySprite, 2 * w, 0, w, enemySprite.getHeight(), m, false);
        Bitmap f44 = Bitmap.createBitmap(enemySprite, 3 * w, 0, w, enemySprite.getHeight(), m, false);
        Bitmap f55 = Bitmap.createBitmap(enemySprite, 4 * w, 0, w, enemySprite.getHeight(), m, false);
        Bitmap resizedBitmap1 = Bitmap.createScaledBitmap(f11, 300, 300, false);
        Bitmap resizedBitmap2 = Bitmap.createScaledBitmap(f22, 300, 300, false);
        Bitmap resizedBitmap3 = Bitmap.createScaledBitmap(f33, 300, 300, false);
        Bitmap resizedBitmap4 = Bitmap.createScaledBitmap(f44, 300, 300, false);
        Bitmap resizedBitmap5 = Bitmap.createScaledBitmap(f55, 300, 300, false);
        sprites[0] = resizedBitmap5;
        sprites[1] = resizedBitmap4;
        sprites[2] = resizedBitmap3;
        sprites[3] = resizedBitmap2;
        sprites[4] = resizedBitmap1;
        enemy.setSpriteAnimate(sprites);
        enemy.setSprite(BitmapFactory.decodeResource(res, R.drawable.enemy));
        enemy.setX(3 * screenWidth / 5);
        enemy.setY(screenHeight / 2);
    }

    /**
     * Creates a Health Bar for the Player.
     */
    private void createPlayerHealthBar() {
        playerHealth = new HealthBarObject();
        playerHealth.setX(screenWidth/10);
        playerHealth.setY(screenHeight/10);
        playerHealth.setColor(Color.GREEN);
        playerHealth.setPlayerName(res.getString(R.string.player) + res.getString(R.string.hp));
        playerHealth.setTextSize(50);
    }

    /**
     * Creates a Attack ButtonObject.
     */
    private void createAttackButton() {
        attackButtonObject = new ButtonObject();
        attackButtonObject.setButton(new Rect(155, 1700, 455, 1875));
        attackButtonObject.setBtnColor(Color.GRAY);
        attackButtonObject.setTextColor(Color.WHITE);
        attackButtonObject.setBtnName(res.getString(R.string.attack));
        attackButtonObject.setX(200);
        attackButtonObject.setY(1800);
    }

    /**
     * Creates a Defend ButtonObject.
     */
    private void createDefendButton() {
        defendButtonObject = new ButtonObject();
        defendButtonObject.setButton(new Rect(655, 1700, 955, 1875));
        defendButtonObject.setBtnColor(Color.GRAY);
        defendButtonObject.setTextColor(Color.WHITE);
        defendButtonObject.setBtnName(res.getString(R.string.defend));
        defendButtonObject.setX(700);
        defendButtonObject.setY(1800);
    }

    /**
     * Creates a Text to show Player and Enemy moves.
     */
    private void createMoveText() {
        moveTextObject = new MoveTextObject();
        moveTextObject.setTextColor(Color.WHITE);
        moveTextObject.setMoveText("");
        moveTextObject.setX(screenWidth/4);
        moveTextObject.setY(2*screenHeight/10);
    }

    /**
     * Draws all the Game 3 Objects on given canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    void draw(Canvas canvas, Paint paint) {
        enemy.draw(canvas, paint);
        player.draw(canvas, paint);
        attackButtonObject.draw(canvas, paint);
        defendButtonObject.draw(canvas, paint);
        if (animate) {
            animateFrame++;
            enemy.update();
            player.update();
            waitTime = 100;
            if (animateFrame == 5) {
                animate = false;
                waitTime = 0;
                animateFrame = 0;
                isTurn = true;
            }
        }
        enemyHealth.draw(canvas, paint);
        playerHealth.draw(canvas, paint);
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
            attackButtonObject.setActive(true);
            defendButtonObject.setActive(true);
        } else {
            attackButtonObject.setActive(false);
            defendButtonObject.setActive(false);
            int damage = decideEnemyDamage();
            if (!animate) {
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

                    //Player gets 2/3 the damage if decided to press Defend button.
                    moveTextObject.update(res.getString(R.string.enemy_took) + 5 +
                            res.getString(R.string.damage), Color.GREEN);
                    hpDamage = 2 * (damage / 3);
                    defend = false;
                }
                playerHealth.update(hpDamage);
            }
            animate = true;
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
                if (attackButtonObject.getButton().left <= touchX && touchX <=
                        attackButtonObject.getButton().right && attackButtonObject.getButton().top <= touchY &&
                        touchY <= attackButtonObject.getButton().bottom) {
                    attack = true;
                    isTurn = false;
                    numMoves += 1;
                }

                //Checks if the DefendButton was tapped. If so, player's turn is over.
                if (defendButtonObject.getButton().left <= touchX && touchX <=
                        defendButtonObject.getButton().right && defendButtonObject.getButton().top <= touchY &&
                        touchY <= defendButtonObject.getButton().bottom) {
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
