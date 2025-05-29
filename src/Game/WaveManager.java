package Game;

import Enemy.Enemy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Enemy.*;

/**
 * Manages all the waves.
 * Loads enemies to their respective waves.
 */
public class WaveManager implements Resettable{
    private int currentWave;
    private int numberOfWaves;
    /**
     * List of all the waves.
     */
    private final ArrayList<Wave> waves = new ArrayList<>();
    private EnemyManager enemyManager;

    public WaveManager() {
        loadEnemies();
    }

    public void setEnemyManager(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }

    /**
     * Loads enemies into their waves from a .txt file.
     */
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


    /**
     * Adds 1 to current wave if there are no enemies left, and it isn't the final wave.
     */
    public void nextWave() {
        if (enemyManager.getEnemies().isEmpty() && currentWave + 1 < numberOfWaves) {
            currentWave++;
        }
    }

    /**
     * Sets END game state if all waves are beaten and no enemies are alive.
     * Sets GAME_OVER game state if health gets below 0.
     * @param mainFrame Main frame of the game.
     * @return Returns true if either of those conditions are met.
     */
    public boolean endGame(MainFrame mainFrame) {
        if ((currentWave + 1) == numberOfWaves && enemyManager.getEnemies().isEmpty()) {
            mainFrame.switchPanels(GameState.END);
            return true;
        } else if (mainFrame.getGame().getHealth() <= 0) {
            mainFrame.switchPanels(GameState.GAME_OVER);
            return true;
        }else {
            return false;
        }
    }

    /**
     * Resets current wave.
     * clears enemies and loads new ones.
     */
    @Override
    public void reset() {
        currentWave = 0;
        waves.clear();
        loadEnemies();

    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }


    public void setNumberOfWaves(int numberOfWaves) {
        this.numberOfWaves = numberOfWaves;
    }


}