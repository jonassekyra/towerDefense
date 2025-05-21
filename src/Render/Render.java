package Render;

import Attack.Projectile;
import Enemy.Enemy;
import Game.Game;
import Enemy.EnemyManager;
import java.awt.*;
import java.util.Iterator;
import Enemy.Movement;
import Level.Level;
import Tower.TowerManager;

public class Render {
    EnemyManager enemyManager;
    Movement movement;
    Level level;
    public Render(EnemyManager enemyManager, Movement movement, Level level) {
        this.enemyManager = enemyManager;
        this.movement = movement;
        this.level = level;
    }

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
            if (e.isHasStarted()) {
                movement.move(e, level,game);
            } else {
                e.setHasStarted(true);
            }
        }
    }
    public void drawLevel(Graphics g,Level level) {
        Graphics2D g2D = (Graphics2D) g;
        for (int i = 0; i < level.getTiles().length; i++) {
            for (int j = 0; j < level.getTiles()[i].length; j++) {
                g2D.drawImage(level.getTiles()[i][j].getImage(), i * 75, j * 75, 75, 75, null);
            }
        }

    }
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

    public void renderProjectile(Graphics g,Level level) {
        g.setColor(Color.BLUE);
        for (Projectile projectile : level.getProjectiles() ){
            g.fillRect(projectile.getX(), projectile.getY(), 10, 10);
        }
    }
}
