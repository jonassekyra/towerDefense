package Attack;

import Enemy.Enemy;

public class Projectile {
private int x;
private int y;
private int speed;
private int targetX;
private int targetY;
private boolean active;

    public Projectile() {
    }

    public Projectile(int x, int y, int speed, int targetX, int targetY) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.targetX = targetX;
        this.targetY = targetY;
        this.damage = damage;
        this.isSlowing = isSlowing;
        this.active = true;
    }

    public void update(){
        if(!active){

            return;
        }

        int directionX = targetX - x;
        int directionY = targetY - y;

        double distance = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));
        if(distance < speed){
            x = directionX;
            y = directionY;
            active = false;

            return;

        }

        double vekX = (double) directionX /distance;
        double vekY = (double) directionY /distance;

        x +=(int)(vekX*speed);
        y +=(int)(vekY*speed);

    }

    public boolean hasHit(Projectile projectile, Enemy enemy){
        int directionX = projectile.getX() - enemy.getPixelX();
        int directionY = projectile.getY() - enemy.getPixelY();

        double distance = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));
        //return distance < 32.5;
        return distance<(enemyRadius + projectileRadius);
    }

    public boolean isSlowing() {
        return isSlowing;
    }

    public void setSlowing(boolean slowing) {
        isSlowing = slowing;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
