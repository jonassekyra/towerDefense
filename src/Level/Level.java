package Level;

import Attack.Projectile;
import Enemy.Enemy;
import Tiles.Tile;

import Enemy.Movement;
import Enemy.EnemyManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Level {
    private HashMap<String, Tile> tileTypes = new HashMap<>();
    //private ArrayList<Enemy> enemies = new ArrayList<>();
    private Tile[][] tiles;
    private int[][] map;
    //private Tower[][] towers = new Tower[10][10];
    Movement movement = new Movement();
    MapLoader mapLoader = new MapLoader();
    EnemyManager enemyManager = new EnemyManager(mapLoader);

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
                    enemy.takeDamage(20);
                    System.out.println(enemy.getHealth());
                    projectile.setActive(false);
                    break;
                }
            }
        }

    }


    public Level() {
        map = mapLoader.getMap();
        tiles = mapLoader.getTiles();

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
