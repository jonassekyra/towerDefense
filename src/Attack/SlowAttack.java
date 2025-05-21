package Attack;

import Enemy.Enemy;
import Level.Level;
import Tower.Tower;

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
            if (e.getProgress() > maxProgres){
                maxProgres = e.getProgress();
                target = e;
            }
        }
        if (enemies.contains(target)) {
        }

        int startX = tower.getPosX() * 75+75/2-5;
        int startY = tower.getPosY() * 75+75/2-5;
        int targetX = target.getPixelX()+ 75 / 2 - 5;
        int targetY = target.getPixelY()+ 75 / 2 - 5;
        Projectile p = new Projectile(startX,startY,20,targetX,targetY);

        level.getProjectiles().add(p);

        target.takeDamage(tower.getDamage());

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
