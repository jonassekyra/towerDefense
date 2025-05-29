package Render;

import Attack.Projectile;
import Enemy.Enemy;
import Game.Game;
import Enemy.EnemyManager;
import Game.ShopManager;

import java.awt.*;
import java.util.Iterator;

import Enemy.Movement;
import Level.Level;
import Tower.TowerManager;
import Game.WaveManager;

/**
 * Management of all methods that draw something on game panel.
 */
public class Render {
    EnemyManager enemyManager;
    Movement movement;
    Level level;

    public Render(EnemyManager enemyManager, Movement movement, Level level) {
        this.enemyManager = enemyManager;
        this.movement = movement;
        this.level = level;
    }

    /**
     *Draws all enemies and their health bars.
     * @param g Graphics g.
     * @param game Game that stores players lives.
     */
    public void drawEnemy(Graphics g, Game game) {
        Graphics2D g2D = (Graphics2D) g;
        Iterator<Enemy> it = enemyManager.getEnemies().iterator();


        while (it.hasNext()) {
            Enemy e = it.next();
            g2D.setColor(e.getColor());
            if (e.isHasEnded()) {
                it.remove();
                continue;
            }
            g2D.fillOval(e.getPixelX(), e.getPixelY(), 75, 75);


            float healthPercent = (e.getHealth() /(float)e.getMaxHealth());
            int maxWidth = 75;
            int currentWidth =(int)(maxWidth * healthPercent);
            g2D.setColor(Color.BLACK);
            g2D.drawRect(e.getPixelX() , e.getPixelY()- (32 / 2), 75, 10);
            g2D.setColor(Color.GREEN);

            g2D.fillRect(e.getPixelX(), e.getPixelY() - (32 / 2), currentWidth, 10);
            if (e.isHasStarted()) {
                movement.move(e, level, game);
            } else {
                e.setHasStarted(true);
            }
        }
    }

    /**
     * Draws all the tiles(grass, path).
     * @param g Graphics g;
     * @param level Current level, containing map.
     */
    public void drawLevel(Graphics g, Level level) {
        Graphics2D g2D = (Graphics2D) g;
        for (int i = 0; i < level.getTiles().length; i++) {
            for (int j = 0; j < level.getTiles()[i].length; j++) {
                g2D.drawImage(level.getTiles()[i][j].getImage(), i * 75, j * 75, 75, 75, null);
            }
        }

    }

    /**
     * Draws towers.
     * @param g Graphics.
     * @param level Current level, containing map.
     * @param towerManager TowerManager containing towers.
     */
    public void drawTowers(Graphics g, Level level, TowerManager towerManager) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < level.getMap().length; i++) {
            for (int j = 0; j < level.getMap().length; j++) {
                if (towerManager.getTowers()[i][j] != null) {
                    g2d.drawImage(towerManager.getTowers()[i][j].getImage(), i * 75, j * 75, 75, 75, null);
                }
            }

        }
    }

    /**
     * Draws projectiles.
     * @param g Graphics.
     * @param level Current level, containing projectiles.
     */
    public void renderProjectile(Graphics g, Level level) {
        g.setColor(Color.BLUE);
        for (Projectile projectile : level.getProjectiles()) {
            g.fillOval(projectile.getX(), projectile.getY(), 10, 10);
        }
    }


    /**
     * Draws current wave.
     * @param g Graphics.
     * @param waveManager WaveManager used for getting to info about waves.
     */
    public void drawWave(Graphics g, WaveManager waveManager) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("wave: " + (waveManager.getCurrentWave() + 1) + "/" + waveManager.getWaves().size(), 600, 90);
    }

    /**
     * Draws number of coins the player has.
     * @param g Graphics.
     * @param shopManager Class responsible for keeping track of coins.
     */
    public void drawCoins(Graphics g, ShopManager shopManager) {
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("coins: " + shopManager.getCoins(), 600, 60);

    }

    /**
     * Draws the amount of lives the player has.
     * @param g Graphics.
     * @param game Game containing health.
     */
    public void drawHealth(Graphics g, Game game) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Hp: " + game.getHealth(), 600, 30);
    }

    /**
     * Calls draw health, coins and wave.
     * @param g Graphics.
     * @param game Game containing health.
     * @param shopManager Class responsible for keeping track of coins.
     * @param waveManager WaveManager used for getting to info about waves.
     */
    public void drawInfo(Graphics g, Game game,ShopManager shopManager,WaveManager waveManager) {
        drawCoins(g, shopManager);
        drawHealth(g, game);
        drawWave(g,waveManager);
    }



}
