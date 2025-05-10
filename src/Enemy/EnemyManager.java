package Enemy;

import Level.MapLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class EnemyManager {
    private MapLoader mapLoader;
    private long sinceLastSpawn = 0;

    public EnemyManager(MapLoader mapLoader) {
        this.mapLoader = mapLoader;
        loadEnemies();
        startEndPosition();

    }


    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> loadedEnemies = new ArrayList<>();
    int count = 0;

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }


    public void startEndPosition() {
        for (Enemy e : loadedEnemies) {
            e.setSpawnCooldown(1000);
            e.setX(mapLoader.getStartPosition().getX());
            e.setY(mapLoader.getStartPosition().getY());
            e.setPixelX(mapLoader.getStartPosition().getX() * 75);
            e.setPixelY(mapLoader.getStartPosition().getY() * 75);
            e.setEndX(mapLoader.getEndPosition().getX());
            e.setEndY(mapLoader.getEndPosition().getY());
            e.setSpeed(5);
            e.setHealth(100);
            e.setTargetX(e.getX() * 75);
            e.setTargetY(e.getY() * 75);
        }
        /*
        for (Enemy e : enemies) {
            e.setX(mapLoader.getStartPosition().getX());
            e.setY(mapLoader.getStartPosition().getY());
            e.setPixelX(mapLoader.getStartPosition().getX() * 75);
            e.setPixelY(mapLoader.getStartPosition().getY() * 75);
            e.setEndX(mapLoader.getEndPosition().getX());
            e.setEndY(mapLoader.getEndPosition().getY());
            e.setSpeed(8);
            e.setHealth(100);
            e.setTargetX(e.getX() * 75);
            e.setTargetY(e.getY() * 75);
        }

         */
    }

    public void loadEnemies() {
        try (BufferedReader br = new BufferedReader(new FileReader("Enemies1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                loadedEnemies.add(new Enemy(15));
            }
            System.out.println(enemies.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void spawnEnemy() {
        long now = System.currentTimeMillis();
        if (count>= loadedEnemies.size()) {
            return;
        }
        if (now >= loadedEnemies.get(count).getSpawnCooldown() + sinceLastSpawn) {
            enemies.add(loadedEnemies.get(count));
            sinceLastSpawn = now;
            count++;
        }

    }
}
