package com.example.game.Game3;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    private BottleObject healthPotion;

    private int waitTime = 0;

    private Game3Strategy gameStrategy;

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
    private ObjectBuilder objectBuilder;
    private final DrawManager drawManager;

    /**
     * A constructor for GameObjectManager.
     */
    GameObjectManager(Resources res, DrawManager drawManager, String gameDifficulty) {
        this.res = res;
        this.objectBuilder = new ObjectBuilder(res);
        this.drawManager = drawManager;

        if (gameDifficulty.equals("easy")) {
            this.gameStrategy = new Game3EasyStrategy();
        } else if (gameDifficulty.equals("normal")) {
            this.gameStrategy = new Game3NormalStrategy();
        } else {
            this.gameStrategy = new Game3HardStrategy();
        }
    }

    /**
     * Creates all the Objects required for this game by calling corresponding methods.
     */
    void createObjects() {
        player = objectBuilder.createPlayer();
        enemy = objectBuilder.createEnemy();
        enemyHealth = objectBuilder.createEnemyHealthBar();
        playerHealth = objectBuilder.createPlayerHealthBar();
        attackButtonObject = objectBuilder.createAttackButton();
        defendButtonObject = objectBuilder.createDefendButton();
        moveTextObject = objectBuilder.createMoveText();
    }


    /**
     * Draws all the Game 3 Objects on given canvas.
     */
    void draw() {
        drawCharacter(enemy);
        drawCharacter(player);
        drawButton(attackButtonObject);
        drawButton(defendButtonObject);
        drawHealth(enemyHealth);
        drawHealth(playerHealth);
        drawMoveText(moveTextObject);
    }

    void drawCharacter(CharacterObject character) {
        drawManager.drawCharacterObject(character.getSprite(), character.getX(), character.getY());
    }

    void drawHealth(HealthBarObject playerHealth) {
        drawManager.drawHealthBarObject(playerHealth.getHealthLevel(), playerHealth.getColor(),
                playerHealth.getTextSize(), playerHealth.getPlayerName(), playerHealth.getX(),
                playerHealth.getY());
    }

    void drawButton(ButtonObject button) {
        if (button.isActive()) {
            drawManager.drawButtonObject(button.getBtnColor(), button.getTextColor(),
                    button.getButton(), button.getBtnName(), button.getX(), button.getY());
        }
    }

    void drawMoveText(MoveTextObject moveText) {
        drawManager.drawMoveTextObject(moveText.getTextColor(), moveText.getMoveText(),
                moveText.getX(), moveText.getY());
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
            int damage = 0;
            if (!animate) {
                if (attack) {
                    damage = gameStrategy.playerAttack();
                    hpDamage = gameStrategy.enemyAttack();
                    attack = false;
                }
                if (defend) {
                    damage = gameStrategy.playerDefend();
                    hpDamage = gameStrategy.enemyDefend();
                    defend = false;
                }
                //Player does 12 HP damage if he/she tapped AttackButton
                enemyHealth.update(damage);

                //Player gets full damage decided randomly by decideEnemyDamage method if Attack
                // button was tapped.
                moveTextObject.update(res.getString(R.string.enemy_took) + damage +
                        res.getString(R.string.damage), Color.GREEN);
                playerHealth.update(hpDamage);
            }
            animate = true;
        }
        if (animate) {
            CharacterObject[] players = new CharacterObject[]{enemy, player};
            animatePlayer(players, 100);
        }
    }

    private void animatePlayer(CharacterObject[] characters, int frameRate) {
        animateFrame++;
        for (CharacterObject character : characters) {
            character.update();
        }
        waitTime = frameRate;
        if (animateFrame == 5) {
            animate = false;
            waitTime = 0;
            animateFrame = 0;
            isTurn = true;
        }
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
    void onTouchEventHelper(float touchX, float touchY) {
        if (isTurn) {

            //Checks if the AttackButton was tapped. If so, player's turn is over.
            if (buttonPressed(attackButtonObject, touchX, touchY)) {
                attack = true;
                isTurn = false;
                numMoves += 1;
            }

            //Checks if the DefendButton was tapped. If so, player's turn is over.
            if (buttonPressed(defendButtonObject, touchX, touchY)) {
                defend = true;
                isTurn = false;
                numMoves += 1;
            }
        }
    }

    Boolean buttonPressed(ButtonObject buttonObject, float touchX, float touchY) {
        return buttonObject.getButton().left <= touchX && touchX <=
                buttonObject.getButton().right && buttonObject.getButton().top <= touchY &&
                touchY <= buttonObject.getButton().bottom;
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
