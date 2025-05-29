package Tower;

import Attack.AttackStrategy;

import java.awt.image.BufferedImage;

public class NormalTower extends Tower {

    public NormalTower(int damage, BufferedImage image, int rangeX, int rangeY, int posX, int posY, AttackStrategy attackStrategy,long cooldown, int cost) {
        super(damage, image, rangeX, rangeY, posX, posY,attackStrategy,cooldown, cost);
    }

    public NormalTower() {
    }
}
