package com.example.game.models.game3;

import android.content.res.Resources;

/**
 * A Manager class for GameObjects.
 */
public class GameObjectManager {

    /**
     * The Player CharacterObject who will be represented by the User.
     */
    private CharacterObject player;

    /**
     * Getter for player.
     *
     * @return player : A character representing the user.
     */
    public CharacterObject getPlayer() {
        return player;
    }

    /**
     * The Enemy CharacterObject who will be represented by the Computer AI.
     */
    private CharacterObject enemy;

    /**
     * Getter for enemy.
     *
     * @return enemy : A character representing the computer.
     */
    public CharacterObject getEnemy() {
        return enemy;
    }

    /**
     * The Player's Health Bar.
     */
    private HealthBarObject playerHealth;

    /**
     * Getter for player's health bar.
     *
     * @return playerHealth : A health bar for the player.
     */
    public HealthBarObject getPlayerHealth() {
        return playerHealth;
    }

    /**
     * The Enemy's Health Bar.
     */
    private HealthBarObject enemyHealth;

    /**
     * Getter for enemy's health bar.
     *
     * @return enemyHealth : A health bar for the enemy.
     */
    public HealthBarObject getEnemyHealth() {
        return enemyHealth;
    }

    /**
     * The Attack ButtonObject.
     */
    private ButtonObject attackButtonObject;

    /**
     * Getter for the attack button.
     *
     * @return attackButtonObject : the attack button.
     */
    public ButtonObject getAttackButtonObject() {
        return attackButtonObject;
    }

    /**
     * The Defend ButtonObject.
     */
    private ButtonObject defendButtonObject;

    /**
     * Getter for the defend button.
     *
     * @return defendButtonObject : the defend button.
     */
    public ButtonObject getDefendButtonObject() {
        return defendButtonObject;
    }

    /**
     * A BottleObject that increases the player's HP when activated.
     */
    private BottleObject healthPotion;

    /**
     * Getter for the health potion.
     *
     * @return healthPotion : A bottle that increases player's HP when activated.
     */
    public BottleObject getHealthPotion() {
        return healthPotion;
    }

    /**
     * The object that displays the move the players make.
     */
    private MoveTextObject moveTextObject;

    /**
     * Getter for move text.
     *
     * @return moveText : A object that displays the move the players make.
     */
    public MoveTextObject getMoveTextObject() {
        return moveTextObject;
    }

    /**
     * The class that creates all the objects that will be displayed on the screen.
     */
    private ObjectBuilder objectBuilder;


    /**
     * A constructor for GameObjectManager.
     *
     * @param res Resources.
     */
    public GameObjectManager(Resources res) {
        this.objectBuilder = new ObjectBuilder(res);
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

}
