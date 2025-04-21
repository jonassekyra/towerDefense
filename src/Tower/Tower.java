package Tower;

import java.awt.image.BufferedImage;
import java.sql.Time;

public abstract class Tower {
    protected int damage;
    protected Time attackSpeed;
    protected BufferedImage image;
    protected int cost;

    public Tower(int damage, Time attackSpeed, BufferedImage image, int cost) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.image = image;
        this.cost = cost;
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
}
