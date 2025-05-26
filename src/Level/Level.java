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
    private Tile[][] tiles;
    private int[][] map;
    private Movement movement = new Movement();
    private MapLoader mapLoader = new MapLoader();
    private EnemyManager enemyManager = new EnemyManager(mapLoader);
    private ShopManager shopManager;

    public Level(ShopManager shopManager) {
        this.shopManager = shopManager;
        map = mapLoader.getMap();
        tiles = mapLoader.getTiles();

    }

    private ArrayList<Projectile> projectiles = new ArrayList<>();


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
                if (projectile.hasHit(projectile,enemy)){
                    if (projectile.isSlowing()){
                        enemy.setSpeed(1);
                    }
                    enemy.takeDamage(projectile.getDamage());
                    AttackUtils.removeDeadEnemy(enemyManager.getEnemies(),shopManager,enemy);
                    System.out.println(enemy.getHealth());
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
