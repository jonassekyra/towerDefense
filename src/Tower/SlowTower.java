package Tower;

import Attack.AttackStrategy;

import java.awt.image.BufferedImage;

public class SlowTower extends Tower {
    public SlowTower(int damage, BufferedImage image, int rangeX, int rangeY, int posX, int posY, AttackStrategy attackStrategy, long cooldown) {
        super(damage, image, rangeX, rangeY, posX, posY, attackStrategy, cooldown);
    }
}
