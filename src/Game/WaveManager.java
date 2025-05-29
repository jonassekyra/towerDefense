package Game;

import Enemy.Enemy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Enemy.*;


public class WaveManager implements Resettable{
    private int currentWave;
    private int numberOfWaves;
    private final ArrayList<Wave> waves = new ArrayList<>();
    private EnemyManager enemyManager;

    public WaveManager() {
        loadEnemies();
    }

    public void setEnemyManager(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }

    public void loadEnemies() {
        try (BufferedReader br = new BufferedReader(new FileReader("enemies.txt"))) {
            String line;
            Wave wave = new Wave();
            while ((line = br.readLine()) != null) {
                Enemy enemy = new Enemy();
                if (line.startsWith("#")) {

                    if (!wave.getEnemiesInWave().isEmpty()) {
                        waves.add(wave);
                        wave = new Wave();
                    }
                    continue;
                }
                String[] split = line.split(",");
                enemy.setEnemyType(EnemyType.valueOf(split[0].toUpperCase()));
                enemy.setSpawnCooldown(Integer.parseInt(split[1]));
                wave.getEnemiesInWave().add(enemy);

            }
            numberOfWaves = waves.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCurrentWave() {
        return currentWave;
    }



    public ArrayList<Wave> getWaves() {
        return waves;
    }



    public void nextWave() {
        if (enemyManager.getEnemies().isEmpty() && currentWave + 1 < numberOfWaves) {
            currentWave++;

        } else {
            //musi se to vypsat na obrazovku
            System.out.println("wave hasnt been cleared");
        }
    }

    public boolean endGame(MainFrame mainFrame) {
        if ((currentWave + 1) == numberOfWaves && enemyManager.getEnemies().isEmpty()) {
            System.out.println("game has ended");
            mainFrame.setGameState(GameState.END);
            return true;
        } else if (mainFrame.getGame().getHealth() <= 0) {
            mainFrame.setGameState(GameState.GAME_OVER);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void reset() {
        currentWave = 0;
        waves.clear();
        loadEnemies();

    }
}