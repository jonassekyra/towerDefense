package Attack;

import Enemy.Enemy;
import Level.Level;
import Tower.Tower;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Iterator;

public class SlowAttack implements AttackStrategy {

    public SlowAttack() {
    }

    @Override
    public void attack(Level level, Tower tower) {
        int maxProgres = -1;
        Enemy target = null;
        ArrayList<Enemy> enemies = level.getEnemyManager().getEnemies();
        if (enemies.isEmpty()) {
            return;
        }
        ArrayList<Enemy> enemiesInRange = new ArrayList<>();
        Iterator<Enemy> it = enemies.iterator();
        while (it.hasNext()) {

            Enemy enemy = it.next();

            int distanceX = enemy.getPixelX() - (tower.getPosX() * 75);
            int distanceY = enemy.getPixelY() - (tower.getPosY() * 75);

            if (Math.abs(distanceX) < (tower.getRangeX() * 75) && Math.abs(distanceY) < (tower.getRangeY() * 75)) {
                enemiesInRange.add(enemy);
            }
        }


        if (enemiesInRange.isEmpty()) {
            return;
        }
        for (Enemy e : enemiesInRange) {
            if (e.getProgres() > maxProgres){
                maxProgres = e.getProgres();
                target = e;
            }
        }
        if (enemies.contains(target)) {
        }

        target.takeDamage(tower.getDamage(), enemies);
        for (Enemy e : enemies) {
            if (e.equals(target)) {
                e.setSpeed(1);
                break;
            }
        }
        System.out.println(target.getHealth());

        if (!target.isAlive()) {
            enemies.remove(target);
        }
    }
}
