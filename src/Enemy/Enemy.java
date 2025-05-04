package Enemy;

import Game.Game;
import Position.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Enemy {
    private int x;
    private int y;
    private int pixelX;
    private int pixelY;
    private int speed;
    private int targetX;
    private int targetY;
    private int endX;
    private int endY;
    private boolean hasStarted = false;
    private boolean hasEnded = false;
    private HashSet<Position> visitedLocations = new HashSet<>();
    private int damage;
    private int health;
    private Direction direction;


    public HashSet<Position> getVisitedLocations() {
        return visitedLocations;
    }

    public void doDamage(Game game) {
        int temp = game.getHealth() - damage;
        game.setHealth(temp);


    }

    public void takeDamage(int damage, ArrayList<Enemy> enemies) {
        if (isAlive()) {
            health -= damage;
        }
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

    public void setTargetPosition(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
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

    public int getDamage() {
        return damage;
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
}
