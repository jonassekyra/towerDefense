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
}
