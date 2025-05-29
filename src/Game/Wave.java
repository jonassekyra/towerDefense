package Game;

import Enemy.Enemy;

import java.util.ArrayList;

/**
 * Wave with List of enemies.
 */
public class Wave {
    private final ArrayList<Enemy> enemiesInWave = new ArrayList<>();
    private int spawnedEnemies = 0;

    public int getSpawnedEnemies() {
        return spawnedEnemies;
    }

    public void setSpawnedEnemies(int spawnedEnemies) {
        this.spawnedEnemies = spawnedEnemies;
    }

    public ArrayList<Enemy> getEnemiesInWave() {
        return enemiesInWave;
    }


}
