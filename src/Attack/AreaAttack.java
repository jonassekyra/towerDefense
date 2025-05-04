package Attack;

import Level.Level;
import Tower.Tower;

public class AreaAttack implements AttackStrategy {
    private Tower tower;

    public AreaAttack(Tower tower) {
        this.tower = tower;
    }

    @Override
    public void attack(Level level, Tower tower) {

    }
}
