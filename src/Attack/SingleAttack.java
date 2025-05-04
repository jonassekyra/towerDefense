package Attack;

import Enemy.Enemy;
import Level.Level;
import Tower.Tower;
import java.util.ArrayList;
import java.util.Iterator;

public class SingleAttack implements AttackStrategy {
    public SingleAttack() {
    }

    @Override
    public void attack(Level level, Tower tower) {
        ArrayList<Enemy> enemies = level.getEnemyManager().getEnemies();
        Iterator<Enemy> it = enemies.iterator();
        while (it.hasNext()) {

            Enemy enemy = it.next();
            if (!enemy.isAlive()) {
                it.remove();
            }
            int distanceX = enemy.getPixelX() - (tower.getPosX() * 75);
            int distanceY = enemy.getPixelY() - (tower.getPosY() * 75);

            if (Math.abs(distanceX) < (tower.getRangeX() * 75) && Math.abs(distanceY) < (tower.getRangeY() * 75)) {
                enemy.takeDamage(tower.getDamage(), enemies);
                System.out.println(enemy.getHealth());
            }
        }
    }
}
