package Game;

import Enemy.Enemy;

import java.util.ArrayList;

public class Wave {
    private ArrayList<Enemy> enemiesInWave = new ArrayList<>();
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

    public void setEnemiesInWave(ArrayList<Enemy> enemiesInWave) {
        this.enemiesInWave = enemiesInWave;
    }
}
