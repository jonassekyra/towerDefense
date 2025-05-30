package Attack;

import Enemy.Enemy;
import Game.ShopManager;
import Level.Level;
import Tower.Tower;

import java.util.ArrayList;
import java.util.List;

/**
 * AttackUtils hold static methods that can be used in different attack strategies.
 */
    public class AttackUtils {

    /**
     * Removes the enemy from list of enemies that are alive.
     * @param enemies list of enemies that are alive.
     * @param shopManager Class responsible for keeping track of coins.
     * @param enemy enemy that is being checked.
     */
        public static void removeDeadEnemy(List<Enemy> enemies, ShopManager shopManager, Enemy enemy) {
            if (!enemy.isAlive()) {
                enemies.remove(enemy);
                shopManager.addCoins(enemy);
            }
        }

    /**
     * Finds the enemy that is furthest on the map by checking progress of each enemy.
     * @param enemiesInRange All enemies that are in range of the tower.
     * @return Enemy that is the furthest.
     */
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

    /**
     * Finds all enemies in range of the tower.
     * @param level Current level.
     * @param tower Tower that is being checked.
     * @return List of enemies in range.
     */
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

    /**
     * Calculates where should the projectile spawn.
     * @param tower tower that shoots the projectile.
     * @return Array with x and y value.
     */
    public static int[] calculateStart(Tower tower) {
        int startX = tower.getPosX() * 75 + 75 / 2 - 5;
        int startY = tower.getPosY() * 75 + 75 / 2 - 5;
        return new int[]{startX, startY};

    }

    /**
     * Calculates location that the projectile flies to.
     * @param target Enemy that is targeted by the tower.
     * @return Array with x and y position of the targeted enemy in time of the shot.
     */
    public static int[] calculateTarget(Enemy target) {
        int targetX = target.getPixelX() + 75 / 2 - 5;
        int targetY = target.getPixelY() + 75 / 2 - 5;
        return new int[]{targetX, targetY};
    }
}
