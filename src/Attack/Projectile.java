package Attack;

import Enemy.Enemy;

/**
 * Represents projectile that moves towards an enemy.
 */
public class Projectile {
    /**
     * Damage dealt by the projectile(loaded from tower).
     */
    private int damage;
    /**
     * X position.
     */
    private int x;
    /**
     * Y position.
     */
    private int y;
    /**
     * Speed of the projectile.
     */
    private int speed;
    /**
     * Target X location.
     */
    private int targetX;
    /**
     * Target Y location.
     */
    private int targetY;
    /**
     * Controls if the projectile should slow down enemies.
     */
    private boolean isSlowing;
    /**
     * Controls if the projectile can be removed.
     */
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

    /**
     * Update method moves the x,y location until the projectile gets close to the target, then deactivates the projectile.
     */
    public void update() {
        if (!active) {

            return;
        }

        int directionX = targetX - x;
        int directionY = targetY - y;

        double distance = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));

        if (distance < speed) {
            x = targetX;
            y = targetY;
            active = false;

            return;

        }

        double vekX = (double) directionX / distance;
        double vekY = (double) directionY / distance;

        x += (int) (vekX * speed);
        y += (int) (vekY * speed);

    }

    /**
     * hasHit method checks if the projectile is within the radius of the enemy.
     * @param enemy that is being checked for hit.
     * @return true if the distance of the projectile from enemy is smaller than their radii combined.
     */
    public boolean hasHit(Enemy enemy) {
        int projectileCenterX = this.x;
        int projectileCenterY = this.y;

        int enemyCenterX = enemy.getPixelX() + 75 / 2;
        int enemyCenterY = enemy.getPixelY() + 75 / 2;


        int directionX = projectileCenterX - enemyCenterX;
        int directionY = projectileCenterY - enemyCenterY;

        double projectileRadius = 5;
        double enemyRadius = 37.5;

        double distance = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));
        return distance < (enemyRadius + projectileRadius);
    }

    //region set&get

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Projectile() {
    }
    //endregion
}
