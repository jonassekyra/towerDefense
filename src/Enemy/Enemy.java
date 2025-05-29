package Enemy;

import Game.Game;
import Position.Position;

import java.awt.*;
import java.util.HashSet;

/**
 * Represents an enemy in the game.
 * Tracks all necessary attributes.
 */
public class Enemy {
    /**
     * X position on a map.
     */
    private int x;
    /**
     * Y position on a map.
     */
    private int y;
    /**
     * X position in pixels.
     */
    private int pixelX;
    /**
     * Y position in pixels.
     */
    private int pixelY;
    /**
     * Current speed of an enemy.
     */
    private int speed;
    /**
     * Default speed.
     */
    private int baseSpeed;
    /**
     * X location in pixels the enemy is traveling to.
     */
    private int targetX;
    /**
     * Y location in pixels the enemy is traveling to.
     */
    private int targetY;
    /**
     * End X location on a map.
     */
    private int endX;
    /**
     * End Y location on a map.
     */
    private int endY;
    private boolean hasStarted = false;
    private boolean hasEnded = false;
    private final HashSet<Position> visitedLocations = new HashSet<>();
    /**
     * Damage that the enemy does to the player's health.
     */
    private int damage;
    /**
     * Current health.
     */
    private int health;
    private int maxHealth;
    /**
     * Direction the enemy is traveling(LEFT,RIGHT,UP,DOWN).
     */
    private Direction direction;
    /**
     * Type of enemy(Normal, Fast.....)
     */
    private EnemyType enemyType;
    /**
     * Time it takes to spawn after the previous enemy.
     */
    private long spawnCooldown;
    /**
     * How long will the enemy be slowed down for.
     */
    private long slowCooldown;
    /**
     * Progress on the map.
     */
    private int progress;
    private Color color;
    /**
     * Amount of coins that is given to the player after killing the enemy.
     */
    private int reward;

    /**
     * Deals damage to the player.
     * @param game Reference to the game in which players health is kept.
     */
    public void doDamage(Game game) {
        int temp = game.getHealth() - damage;
        game.setHealth(temp);

    }

    /**
     * Applies slow effect to the enemy.
     * @param slow Speed at which the enemy will be traveling.
     * @param durationMs Duration of the speed effect.
     */
    public void applySlow(int slow,long durationMs) {
        this.speed = slow;
        this.slowCooldown = System.currentTimeMillis() +  durationMs;
    }

    /**
     * Damages the enemy.
     * @param damage Amount of damage the enemy should take.
     */
    public void takeDamage(int damage) {
        if (isAlive()) {
            health -= damage;
        }
    }




    //region Set&Get



    public long getSlowCooldown() {
        return slowCooldown;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }




    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getSpawnCooldown() {
        return spawnCooldown;
    }

    public Enemy() {
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setSpawnCooldown(long spawnCooldown) {
        this.spawnCooldown = spawnCooldown;
    }

    public HashSet<Position> getVisitedLocations() {
        return visitedLocations;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
    }


    public boolean isAlive() {
        return health > 0;

    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPixelX() {
        return pixelX;
    }

    public void setPixelX(int pixelX) {
        this.pixelX = pixelX;
    }

    public int getPixelY() {
        return pixelY;
    }

    public void setPixelY(int pixelY) {
        this.pixelY = pixelY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Enemy(int damage) {
        this.damage = damage;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public boolean isHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
    //endregion
}

