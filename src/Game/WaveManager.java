package Game;

import Enemy.Enemy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Enemy.*;

public class WaveManager {
    private int currentWave;
    private int numberOfWaves;
    private ArrayList<Wave> waves = new ArrayList<>();

    public WaveManager() {
        loadEnemies();
    }

    public void loadEnemies() {
        try (BufferedReader br = new BufferedReader(new FileReader("Enemies1"))) {
            String line;
            Wave wave = new Wave();
            while ((line = br.readLine()) != null) {
                Enemy enemy = new Enemy();
                if (line.startsWith("#")){
                    if (!wave.getEnemiesInWave().isEmpty()){
                        waves.add(wave);
                        wave = new Wave();
                    }
                    continue;
                }
                String[] split = line.split(",");
                enemy.setEnemyType(EnemyType.valueOf(split[0].toUpperCase()));
                enemy.setSpawnCooldown(Integer.parseInt(split[1]));
                //enemyStats(enemy);
                wave.getEnemiesInWave().add(enemy);

                //loadedEnemies.add(enemy);
            }
            //System.out.println(enemies.size());
            System.out.println(waves.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    public int getNumberOfWaves() {
        return numberOfWaves;
    }

    public void setNumberOfWaves(int numberOfWaves) {
        this.numberOfWaves = numberOfWaves;
    }

    public ArrayList<Wave> getWaves() {
        return waves;
    }

    public void setWaves(ArrayList<Wave> waves) {
        this.waves = waves;
    }
}
