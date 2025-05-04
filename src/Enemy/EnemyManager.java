package Enemy;

import Level.MapLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EnemyManager {
    private MapLoader mapLoader;

    public EnemyManager(MapLoader mapLoader) {
        this.mapLoader = mapLoader;
        loadEnemies();
        startEndPosition();

    }

    private ArrayList<Enemy> enemies = new ArrayList<>();


    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }


    public void startEndPosition() {
        for (Enemy e : enemies) {
            e.setX(mapLoader.getStartPosition().getX());
            e.setY(mapLoader.getStartPosition().getY());
            e.setPixelX(mapLoader.getStartPosition().getX() * 75);
            e.setPixelY(mapLoader.getStartPosition().getY() * 75);
            e.setEndX(mapLoader.getEndPosition().getX());
            e.setEndY(mapLoader.getEndPosition().getY());
            e.setSpeed(3);
            e.setHealth(100);
        }
    }

    public void loadEnemies() {
        try (BufferedReader br = new BufferedReader(new FileReader("Enemies1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                enemies.add(new Enemy(15));
            }
            System.out.println(enemies.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
