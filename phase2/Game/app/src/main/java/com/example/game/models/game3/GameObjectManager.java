package com.example.game.models.game3;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;

import com.example.game.views.game3.DrawManager;
import com.example.game.R;


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

    private BottleObject healthPotion;

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

    private int waitTime = 0;

    private Game3Strategy gameStrategy;

    public int getWaitTime() {
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
    public int getNumMoves() {
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
    public int getHitpoints() {
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
    public boolean getTurn() {
        return isTurn;
    }

    /**
     * Setter for isTurn.
     *
     * @param turn : Checks if it' the user's turn.
     */
    void setTurn(Boolean turn) {
        isTurn = turn;
    }

    private Boolean isTurn = true;
    private MoveTextObject moveTextObject;
    private int hpDamage = 0;
    private ObjectBuilder objectBuilder;
    private final DrawManager drawManager;
    private int screenWidth;

    /**
     * A constructor for GameObjectManager.
     */
    public GameObjectManager(Resources res, DrawManager drawManager, String gameDifficulty) {
        this.res = res;
        this.objectBuilder = new ObjectBuilder(res);
        this.drawManager = drawManager;
        DisplayMetrics display = res.getDisplayMetrics();
        screenWidth = display.widthPixels;
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
    public void createObjects() {
        player = objectBuilder.createPlayer();
        enemy = objectBuilder.createEnemy();
        enemyHealth = objectBuilder.createEnemyHealthBar();
        playerHealth = objectBuilder.createPlayerHealthBar();
        attackButtonObject = objectBuilder.createAttackButton();
        defendButtonObject = objectBuilder.createDefendButton();
        moveTextObject = objectBuilder.createMoveText();
        healthPotion = objectBuilder.createHealthPotion();
    }


    /**
     * Draws all the Game 3 Objects on given canvas.
     */
    public void draw() {
        drawCharacter(enemy);
        drawCharacter(player);
        drawButton(attackButtonObject);
        drawButton(defendButtonObject);
        drawHealth(enemyHealth);
        drawHealth(playerHealth);
        drawMoveText(moveTextObject);
        drawBottleObject(healthPotion);
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

    void drawBottleObject(BottleObject bottle) {
        if (bottle.getActive()) {
            drawManager.drawBottleObject(bottle.getSprite(), bottle.getX(), bottle.getY());
        }
    }

    /**
     * Updates the GameObjects that require updates.
     */
    public void update() {
        healthPotion.update(screenWidth);
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
                    damage = gameStrategy.playerAttack(healthPotion);
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
    public boolean gameEnded() {
        return (enemyHealth.getHealthLevel() == 0 || playerHealth.getHealthLevel() == 0);
    }

    /**
     * Checks if the game has ended (when either of the Player's health has reached 0).
     */
    public void onTouchEventHelper(float touchX, float touchY) {
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
        if (bottlePressed(healthPotion, touchX, touchY)) {
            if (playerHealth.getHealthLevel() > 95) {
                playerHealth.setHealthLevel(100);
            } else {
                playerHealth.update(-5);
            }
            healthPotion.setActive(false);
        }
    }

    Boolean buttonPressed(ButtonObject buttonObject, float touchX, float touchY) {
        return buttonObject.getButton().left <= touchX && touchX <=
                buttonObject.getButton().right && buttonObject.getButton().top <= touchY &&
                touchY <= buttonObject.getButton().bottom;
    }

    Boolean bottlePressed(BottleObject bottleObject, float touchX, float touchY) {
        if (bottleObject.getActive()) {
            return bottleObject.getLeft() <= touchX && touchX <=
                    bottleObject.getRight() && bottleObject.getTop() <= touchY &&
                    touchY <= bottleObject.getBottom();
        } else {
            return false;
        }
    }

    /**
     * Check's which one of the CharacterObjects is the winner (The enemy or the Player) and return
     * string that displays the result of the game. Also updates the hitpoints for the player.
     *
     * @return result : The result of the game.
     */
    public String checkWinner() {
        if (playerHealth.getHealthLevel() == 0) {
            return res.getString(R.string.lost);
        } else {
            return res.getString(R.string.win);
        }
    }

    /**
     * Updates the hitpoints after the game is done.
     */
    public int updateHitpoints() {
        if (playerHealth.getHealthLevel() == 0) {
            setHitpoints(0);
        } else {
            setHitpoints(2 * playerHealth.getHealthLevel());
        }
        return getHitpoints();
    }
}
