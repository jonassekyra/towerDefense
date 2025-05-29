package Enemy;

import Game.Wave;

import Level.MapLoader;

import java.awt.*;

import java.util.ArrayList;

/**
 * Manages enemies, their stats and spawns
 */
public class EnemyManager {

    private final MapLoader mapLoader;
    /**
     * Time since the last enemy was spawned.
     */
    private long sinceLastSpawn = 0;
    /**
     * Arraylist of currently active enemies.
     */
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public EnemyManager(MapLoader mapLoader) {
        this.mapLoader = mapLoader;

    }


    /**
     * Sets start and end positions to the enemy.
     * @param e Enemy that is being set up.
     */
    public void startEndPosition(Enemy e) {

        e.setX(mapLoader.getStartPosition().getX());
        e.setY(mapLoader.getStartPosition().getY());
        e.setPixelX(mapLoader.getStartPosition().getX() * 75);
        e.setPixelY(mapLoader.getStartPosition().getY() * 75);
        e.setEndX(mapLoader.getEndPosition().getX());
        e.setEndY(mapLoader.getEndPosition().getY());
        e.setTargetX(e.getX() * 75);
        e.setTargetY(e.getY() * 75);

    }

    /**
     * Spawns enemies from wave.
     * Only spawns when the cooldown has ended.
     * @param wave Current wave from which enemies are being spawned.
     */
    public void spawnEnemy(Wave wave) {

        long now = System.currentTimeMillis();
        int spawnedEnemies = wave.getSpawnedEnemies();

        if (wave.getSpawnedEnemies() >= wave.getEnemiesInWave().size()) {
            return;
        }

        Enemy nextEnemy = wave.getEnemiesInWave().get(wave.getSpawnedEnemies());

        if (now >= wave.getEnemiesInWave().get(spawnedEnemies).getSpawnCooldown() + sinceLastSpawn) {
            startEndPosition(nextEnemy);
            enemyStats(nextEnemy);
            enemies.add(wave.getEnemiesInWave().get(spawnedEnemies));
            sinceLastSpawn = now;
            wave.setSpawnedEnemies(spawnedEnemies + 1);
        }

    }

    /**
     * Removes slow effect from enemy.
     * Only when the timer has ended.
     * @param wave Current wave(enemies aren't used because it would be harder to get to them).
     */
    public void removeSlow(Wave wave) {
        long now = System.currentTimeMillis();
        for (Enemy e : wave.getEnemiesInWave()) {
            if (now >= e.getSpawnCooldown() + e.getSlowCooldown()) {
                e.setSpeed(e.getBaseSpeed());
            }
        }

    }

    /**
     * Sets stats to enemy based on its type.
     * @param enemy Enemy that is being set up.
     */
    public void enemyStats(Enemy enemy) {
        switch (enemy.getEnemyType()) {
            case NORMAL:
                enemy.setColor(Color.CYAN);
                enemy.setHealth(60);
                enemy.setMaxHealth(60);
                enemy.setBaseSpeed(2);
                enemy.setSpeed(2);
                enemy.setDamage(5);
                enemy.setReward(10);
                break;

            case FAST:
                enemy.setColor(Color.RED);
                enemy.setHealth(30);
                enemy.setMaxHealth(30);
                enemy.setBaseSpeed(3);
                enemy.setSpeed(3);
                enemy.setDamage(10);
                enemy.setReward(20);
                break;

            case TANK:
                enemy.setColor(Color.GRAY);
                enemy.setHealth(150);
                enemy.setMaxHealth(150);
                enemy.setBaseSpeed(1);
                enemy.setSpeed(1);
                enemy.setDamage(20);
                enemy.setReward(50);
                break;

            case BOSS:
                enemy.setColor(Color.ORANGE);
                enemy.setHealth(300);
                enemy.setMaxHealth(300);
                enemy.setDamage(40);
                enemy.setBaseSpeed(2);
                enemy.setSpeed(2);
                enemy.setReward(60);
                break;

        }
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
}
