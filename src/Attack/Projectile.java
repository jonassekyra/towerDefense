package Attack;

import Enemy.Enemy;

public class Projectile {
private int x;
private int y;
private final int speed;
private final int targetX;
private final int targetY;
private final int damage;
private final boolean isSlowing;
private boolean active;


    public Projectile(int x, int y, int speed, int targetX, int targetY, int damage, boolean isSlowing) {
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

    public boolean hasHit(Enemy enemy){
        int projectileCenterX = this.x;
        int projectileCenterY = this.y;

        int enemyCenterX = enemy.getPixelX() + 75/2;
        int enemyCenterY = enemy.getPixelY() + 75/2;


        int directionX = projectileCenterX - enemyCenterX;
        int directionY = projectileCenterY - enemyCenterY;

        double projectileRadius = 5;
        double enemyRadius = 37.5;

        double distance = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));
        return distance<(enemyRadius + projectileRadius);
    }

    public boolean isSlowing() {
        return isSlowing;
    }


    public int getDamage() {
        return damage;
    }


    public int getX() {
        return x;
    }



    public int getY() {
        return y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
