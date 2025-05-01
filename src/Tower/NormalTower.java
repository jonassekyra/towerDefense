package Tower;

import Attack.AttackStrategy;
import Attack.SingleAttack;

import java.awt.image.BufferedImage;
import java.sql.Time;

public class NormalTower extends Tower {

    public NormalTower(int damage, BufferedImage image, int rangeX, int rangeY, int posX, int posY, AttackStrategy attackStrategy,long cooldown) {
        super(damage, image, rangeX, rangeY, posX, posY,new SingleAttack(),cooldown);
    }

    public NormalTower() {
    }
}
