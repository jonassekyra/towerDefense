package Tests;

import Enemy.EnemyManager;
import Game.MainFrame;
import Game.WaveManager;
import Level.MapLoader;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WaveManagerTest {

    MainFrame mainFrame = new MainFrame();
    WaveManager waveManager = new WaveManager();
    MapLoader mapLoader = new MapLoader();
    EnemyManager enemyManager = new EnemyManager(mapLoader);


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        enemyManager.setEnemies(new ArrayList<>());
        waveManager.setEnemyManager(enemyManager);
        waveManager.setCurrentWave(3);
        waveManager.setNumberOfWaves(4);
    }

    @org.junit.jupiter.api.Test
    void endGame() {
        boolean result = waveManager.endGame(mainFrame);
        assertTrue(result);
    }
}