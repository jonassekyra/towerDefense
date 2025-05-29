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

/**
 * Abstract Tower class used to create Child towers using factory method.
 */
public abstract class Tower {
    protected int damage;
    protected BufferedImage image;
    /**
     * X position of the tower on a map.
     */
    protected int rangeX;
    /**
     * Y position of the tower on a map.
     */
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

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Checks if the cooldown for attacking has ended.
     * @param level current level.
     * @param shopManager ShopManager containing coins.
     */
    public void canAttack(Level level, ShopManager shopManager) {
        //https://gamedev.stackexchange.com/questions/158616/how-do-i-create-a-delay-or-cooldown-timer
        long now = System.currentTimeMillis();
        if (now >= cooldown + LastAttack) {
            attackStrategy.attack(level, this,shopManager);
            LastAttack = now;
        }
    }

    /**
     * Factory method that creates specific towers.
     * Loads picture of the tower from resources.
     * @param type type of tower, 1 = normal, 2 = slow
     * @param posX X position of the tower on a map.
     * @param posY  position of the tower on a map.
     * @return Returns created tower.
     * @throws IOException If the Image is missing or cannot be found.
     */
    public static Tower createTower(int type, int posX, int posY) throws IOException {
        return switch (type) {
            case 1 -> {
                BufferedImage image = ImageIO.read(Objects.requireNonNull(Tower.class.getResource("/normal_tower.png")));

                yield new NormalTower(20, image, 3, 3, posX, posY, new SingleAttack(), 750, 50);
            }
            case 2 -> {
                BufferedImage image1 = ImageIO.read(Objects.requireNonNull(Tower.class.getResource("/slow_tower.png")));

                yield new SlowTower(1, image1, 3, 3, posX, posY, new SlowAttack(), 2000, 100);
            }
            default -> null;
        };
    }

}
