package Attack;

import Enemy.Enemy;

import Level.Level;
import Tower.Tower;
import Game.ShopManager;
import java.util.ArrayList;

import java.util.List;

public class SingleAttack implements AttackStrategy {
    public SingleAttack() {
    }

    @Override
    public void attack(Level level, Tower tower, ShopManager shopManager) {
        ArrayList<Enemy> enemies = level.getEnemyManager().getEnemies();
        if (enemies.isEmpty()) {
            return;
        }
        List<Enemy> enemiesInRange = AttackUtils.getEnemiesInRange(level, tower);
        Enemy target = AttackUtils.getFirstTarget(enemiesInRange);


        if (enemiesInRange.contains(target)) {
            int[] start = AttackUtils.calculateStart(tower);

            //from IntelliJ Idea
            assert target != null;

            int[] targetXY = AttackUtils.calculateTarget(target);

            Projectile p = new Projectile(start[0], start[1], 8, targetXY[0], targetXY[1], tower.getDamage(), false);
            level.getProjectiles().add(p);
        }


    }
}
