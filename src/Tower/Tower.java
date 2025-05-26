package Tower;

import Attack.AttackStrategy;
import Attack.SingleAttack;
import Attack.SlowAttack;
import Game.ShopManager;
import Level.Level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class Tower {
    protected int damage;
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


    public Tower(int damage, BufferedImage image, int rangeX, int rangeY, int posX, int posY, AttackStrategy attackStrategy, long cooldown, int cost) {
        this.damage = damage;
        this.image = image;
        this.rangeX = rangeX;
        this.rangeY = rangeY;
        this.posX = posX;
        this.posY = posY;
        this.attackStrategy = attackStrategy;
        this.cooldown = cooldown;
        this.cost = cost;
    }

    public int getRangeX() {
        return rangeX;
    }


    public int getRangeY() {
        return rangeY;
    }

    public int getPosX() {
        return posX;
    }



    public int getPosY() {
        return posY;
    }



    public Tower() {
    }

    public int getDamage() {
        return damage;
    }



    public BufferedImage getImage() {
        return image;
    }


    public int getCost() {
        return cost;
    }




    public void canAttack(Level level, ShopManager shopManager) {
        //https://gamedev.stackexchange.com/questions/158616/how-do-i-create-a-delay-or-cooldown-timer
        long now = System.currentTimeMillis();
        if (now >= cooldown + LastAttack) {
            attackStrategy.attack(level, this,shopManager);
            LastAttack = now;
        }
    }

    public static Tower createTower(int type, int posX, int posY) throws IOException {
        return switch (type) {
            case 1 -> {
                BufferedImage image = ImageIO.read(Objects.requireNonNull(Tower.class.getResource("/tiles/Red.png")));

                yield new NormalTower(20, image, 3, 3, posX, posY, new SingleAttack(), 750, 50);
            }
            case 2 -> {
                BufferedImage image1 = ImageIO.read(Objects.requireNonNull(Tower.class.getResource("/tiles/Red.png")));

                yield new SlowTower(10, image1, 3, 3, posX, posY, new SlowAttack(), 2000, 100);
            }
            default -> null;
        };
    }

}
