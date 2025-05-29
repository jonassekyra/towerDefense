package Enemy;

import Game.Game;
import Position.Position;


import java.awt.*;
import java.util.HashSet;
import java.util.Objects;

public class Enemy {
    private int x;
    private int y;
    private int pixelX;
    private int pixelY;
    private int speed;
    private int baseSpeed;
    private int targetX;
    private int targetY;
    private int endX;
    private int endY;
    private boolean hasStarted = false;
    private boolean hasEnded = false;
    private final HashSet<Position> visitedLocations = new HashSet<>();
    private int damage;
    private int health;
    private int maxHealth;
    private Direction direction;
    private EnemyType enemyType;
    private long spawnCooldown;
    private long slowCooldown;
    private int progress;
    private Color color;
    private int reward;


    public void doDamage(Game game) {
        int temp = game.getHealth() - damage;
        game.setHealth(temp);

    }

    public void applySlow(int slow,long durationMs) {
        this.speed = slow;
        this.slowCooldown = System.currentTimeMillis() +  durationMs;
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

    public void takeDamage(int damage) {
        if (isAlive()) {
            health -= damage;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enemy enemy = (Enemy) o;
        return Objects.equals(visitedLocations, enemy.visitedLocations);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(visitedLocations);
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

