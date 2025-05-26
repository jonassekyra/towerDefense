package Attack;

import Enemy.Enemy;
import Game.ShopManager;
import Level.Level;
import Tower.Tower;

import java.util.ArrayList;
import java.util.List;

public class AttackUtils {


    public static void removeDeadEnemy(List<Enemy> enemies, ShopManager shopManager, Enemy enemy) {
        if (!enemy.isAlive()) {
            enemies.remove(enemy);
            shopManager.addCoins(enemy);
        }
    }

    public static Enemy getFirstTarget(List<Enemy> enemiesInRange) {
        int maxProgress = Integer.MIN_VALUE;
        Enemy target = null;

        if (enemiesInRange.isEmpty()) {
            return null;
        }

        for (Enemy e : enemiesInRange) {
            if (e.getProgress() > maxProgress) {
                maxProgress = e.getProgress();
                target = e;
            }
        }

        return target;
    }


    public static List<Enemy> getEnemiesInRange(Level level, Tower tower) {
        List<Enemy> enemiesInRange = new ArrayList<>();

        for (Enemy enemy : level.getEnemyManager().getEnemies()) {
            int distanceX = enemy.getPixelX() - (tower.getPosX() * 75);
            int distanceY = enemy.getPixelY() - (tower.getPosY() * 75);

            if (Math.abs(distanceX) < (tower.getRangeX() * 75) && Math.abs(distanceY) < (tower.getRangeY() * 75)) {
                enemiesInRange.add(enemy);
            }
        }

        return enemiesInRange;
    }

    public static int[] calculateStart(Tower tower) {
        int startX = tower.getPosX() * 75 + 75 / 2 - 5;
        int startY = tower.getPosY() * 75 + 75 / 2 - 5;
        return new int[]{startX, startY};

    }

    public static int[] calculateTarget(Enemy target) {
        int targetX = target.getPixelX() + 75 / 2 - 5;
        int targetY = target.getPixelY() + 75 / 2 - 5;
        return new int[]{targetX, targetY};
    }
}
