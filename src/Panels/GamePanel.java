package Panels;


import Game.*;
import Level.Level;
import Render.Render;
import Tower.Tower;
import Tower.TowerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GamePanel extends JPanel {

    private final Timer timer;
    private final Game game;
    private final TowerManager towerManager;
    private final WaveManager waveManager;
    private boolean running = false;
    private final MainFrame mainFrame;
    private final Level level;
    private final Render render;



    public GamePanel(Game game, TowerMenu towerMenu, MainFrame mainFrame, WaveManager waveManager, ShopManager shopManager) {
        this.level = new Level(shopManager);
        this.waveManager = waveManager;
        this.game = game;
        this.mainFrame = mainFrame;
        towerManager = new TowerManager(game);
        this.render = new Render(level.getEnemyManager(), level.getMovement(), level);

        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);

        shopManager.setCoins(400);

        waveManager.setEnemyManager(level.getEnemyManager());


        timer = new Timer(16, this::actionPerformed);


        addMouseListener(new MouseAdapter() {




            @Override
            public void mouseClicked(MouseEvent e) {
                int tileX = e.getX() / 75;
                int tileY = e.getY() / 75;
                if (!mainFrame.getGameState().equals(GameState.PLACING_TOWER)) {
                    return;
                }
                if (!(level.getMap()[tileX][tileY] != 1 && (tileX < 10 && tileY < 10))) {
                    return;
                }
                if (towerManager.getTowers()[tileX][tileY] != null) {
                    return;
                }
                try {
                    switch (towerMenu.getCurrentlySelectedTower()) {
                        case "Normal Tower":
                            Tower tower = Tower.createTower(1, tileX, tileY);
                            assert tower != null;
                            if (shopManager.buyTower(tower)) {
                                towerManager.getTowers()[tileX][tileY] = tower;
                                towerManager.updateTowers(level);
                                towerMenu.unselectTower();
                                repaint();
                                break;
                            }
                            towerMenu.unselectTower();


                            break;
                        case "Slow Tower":
                            Tower tower1 = Tower.createTower(2, tileX, tileY);
                            assert tower1 != null;
                            if (shopManager.buyTower(tower1)) {
                                towerManager.getTowers()[tileX][tileY] = tower1;
                                towerManager.updateTowers(level);
                                towerMenu.unselectTower();
                                repaint();
                                break;
                            }
                            towerMenu.unselectTower();

                            break;

                        default:
                            towerMenu.unselectTower();
                            break;
                    }



                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                mainFrame.setGameState(GameState.PLAY);


            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        render.drawLevel(g2d, level);
        render.drawTowers(g2d, level, towerManager);
        render.renderProjectile(g2d, level);
        render.drawInfo(g2d,game, game.getShopManager(), waveManager);
        render.drawEnemy(g2d, game);


    }

    public void actionPerformed(ActionEvent e) {
        if (waveManager.getCurrentWave() < waveManager.getWaves().size()) {
            level.getEnemyManager().spawnEnemy(waveManager.getWaves().get(waveManager.getCurrentWave()));
        }
        level.getEnemyManager().removeSlow(waveManager.getWaves().get(waveManager.getCurrentWave()));
        towerManager.updateTowers(level);
        level.updateProjectiles();
        if (waveManager.endGame(mainFrame)) {
            timer.stop();
        }

        repaint();
    }

    public void startGame() {
        if (!running) {
            running = true;
            Timer deleyTimer = new Timer(500, e -> timer.start());
            deleyTimer.setRepeats(false);
            deleyTimer.start();

        }
    }

    public Level getLevel() {
        return level;
    }
}
