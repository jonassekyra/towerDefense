package Tower;

import Attack.AttackStrategy;

import java.awt.image.BufferedImage;

/**
 * Slow toweer
 */
public class SlowTower extends Tower {
    public SlowTower(int damage, BufferedImage image, int rangeX, int rangeY, int posX, int posY, AttackStrategy attackStrategy, long cooldown, int cost) {
        super(damage, image, rangeX, rangeY, posX, posY, attackStrategy, cooldown, cost);
    }
}
