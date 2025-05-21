package Enemy;

import Game.Wave;
import Game.WaveManager;
import Level.MapLoader;

import java.awt.*;

import java.util.ArrayList;


public class EnemyManager {
    private MapLoader mapLoader;
    private long sinceLastSpawn = 0;

    public EnemyManager(MapLoader mapLoader) {
        this.mapLoader = mapLoader;

    }


    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Wave> loadedEnemies = new ArrayList<>();
    int count = 0;

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }


    public void startEndPosition(Enemy e) {

        e.setX(mapLoader.getStartPosition().getX());
        e.setY(mapLoader.getStartPosition().getY());
        e.setPixelX(mapLoader.getStartPosition().getX() * 75);
        e.setPixelY(mapLoader.getStartPosition().getY() * 75);
        e.setEndX(mapLoader.getEndPosition().getX());
        e.setEndY(mapLoader.getEndPosition().getY());
        System.out.println("neco");
        e.setTargetX(e.getX() * 75);
        e.setTargetY(e.getY() * 75);

    }

    public void addEnemies(WaveManager waveManager){
       loadedEnemies.add(waveManager.getWaves().get(waveManager.getCurrentWave())); ;
    }

    public void spawnEnemy(Wave wave) {
        long now = System.currentTimeMillis();

        Enemy nextEnemy = wave.getEnemiesInWave().get(count);

        if (now >= wave.getEnemiesInWave().get(count).getSpawnCooldown() + sinceLastSpawn) {
            startEndPosition(nextEnemy);
            enemyStats(nextEnemy);
            enemies.add(wave.getEnemiesInWave().get(count));
            sinceLastSpawn = now;
            count++;
        }

    }

    public void enemyStats(Enemy enemy) {
        switch (enemy.getEnemyType()) {
            case NORMAL:
                enemy.setColor(Color.CYAN);
                enemy.setHealth(100);
                enemy.setSpeed(2);
                break;

            case FAST:
                enemy.setColor(Color.RED);
                enemy.setHealth(50);
                enemy.setSpeed(5);
                break;

            case TANK:
                enemy.setColor(Color.GRAY);
                enemy.setHealth(250);
                enemy.setSpeed(1);
                break;

            case BOSS:
                enemy.setColor(Color.ORANGE);
                enemy.setHealth(500);
                enemy.setSpeed(2);
                break;

        }
    }
}
