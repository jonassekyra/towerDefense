package Attack;

import Enemy.Enemy;
import Level.Level;
import Tower.Tower;

import java.util.List;

public class AreaAttack implements AttackStrategy {
    private Tower tower;

    public AreaAttack(Tower tower) {
        this.tower = tower;
    }

    @Override
    public void attack(Level level,Tower tower) {

    }
}
