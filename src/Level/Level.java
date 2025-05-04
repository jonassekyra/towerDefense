package Level;

import Tiles.Tile;

import Enemy.Movement;
import Enemy.EnemyManager;
import java.util.HashMap;


public class Level {
    private HashMap<String, Tile> tileTypes = new HashMap<>();
    //private ArrayList<Enemy> enemies = new ArrayList<>();
    private Tile[][] tiles;
    private int[][] map;
    //private Tower[][] towers = new Tower[10][10];
    Movement movement = new Movement();
    MapLoader mapLoader = new MapLoader();
    EnemyManager enemyManager = new EnemyManager(mapLoader);

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
}
