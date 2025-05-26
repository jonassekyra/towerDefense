package Level;

import Attack.AttackUtils;
import Attack.Projectile;
import Enemy.Enemy;
import Game.ShopManager;
import Tiles.Tile;

import Enemy.Movement;
import Enemy.EnemyManager;

import java.util.ArrayList;
import java.util.Iterator;


public class Level {
    private final Tile[][] tiles;
    private final int[][] map;
    private final Movement movement = new Movement();
    private final MapLoader mapLoader = new MapLoader();
    private final EnemyManager enemyManager = new EnemyManager(mapLoader);
    private final ShopManager shopManager;
    private final ArrayList<Projectile> projectiles = new ArrayList<>();


    public Level(ShopManager shopManager) {
        this.shopManager = shopManager;
        map = mapLoader.getMap();
        tiles = mapLoader.getTiles();

    }



    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void updateProjectiles() {

        Iterator<Projectile> iterator = projectiles.iterator();
        while (iterator.hasNext()) {
            Projectile projectile = iterator.next();
            projectile.update();
            if (!projectile.isActive()){
                iterator.remove();
                continue;
            }
            for (Enemy enemy : enemyManager.getEnemies()) {
                if (projectile.hasHit(enemy)){
                    if (projectile.isSlowing()){
                        enemy.setSpeed(1);
                    }
                    enemy.takeDamage(projectile.getDamage());
                    AttackUtils.removeDeadEnemy(enemyManager.getEnemies(),shopManager,enemy);
                    projectile.setActive(false);
                    break;
                }
            }
        }

    }



    public int[][] getMap() {
        return map;
    }

    public EnemyManager getEnemyManager() {
        return enemyManager;
    }

    public Movement getMovement() {
        return movement;
    }


    public Tile[][] getTiles() {
        return tiles;
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }
}
