package Tower;

import Attack.AttackStrategy;
import Enemy.Enemy;
import Level.Level;

import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    protected int damage;
    protected Time attackSpeed;
    protected BufferedImage image;
    protected int rangeX;
    protected int rangeY;
    protected int cost;
    protected int posX;
    protected int posY;
    protected AttackStrategy attackStrategy;
    //in milliseconds
    protected long cooldown;
    protected long LastAttack = 0;



    public Tower(int damage, BufferedImage image, int rangeX, int rangeY, int posX, int posY,AttackStrategy attackStrategy,long cooldown) {
        this.damage = damage;
        this.image = image;
        this.rangeX = rangeX;
        this.rangeY = rangeY;
        this.posX = posX;
        this.posY = posY;
        this.attackStrategy = attackStrategy;
        this.cooldown = cooldown;
    }

    public int getRangeX() {
        return rangeX;
    }

    public void setRangeX(int rangeX) {
        this.rangeX = rangeX;
    }

    public int getRangeY() {
        return rangeY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setRangeY(int rangeY) {
        this.rangeY = rangeY;
    }

    public Tower() {
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Time getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(Time attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public List<Enemy> enemiesInRange(ArrayList<Enemy> enemies) {
        List<Enemy> results = new ArrayList<>();
        for (Enemy enemy: enemies){
            int distanceX = enemy.getX() - posX;
            int distanceY = enemy.getY() - posY;

            if (Math.abs(distanceX) < rangeX && Math.abs(distanceY) < rangeY){
                results.add(enemy);
            }

        }
        return results;
    }

    public void canAttack(Level level){
        //https://gamedev.stackexchange.com/questions/158616/how-do-i-create-a-delay-or-cooldown-timer
        long now = System.currentTimeMillis();
        if (now >= cooldown + LastAttack){
            attackStrategy.attack(level, this);
            LastAttack = now;
        }
    }

}
