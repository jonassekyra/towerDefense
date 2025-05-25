package Panels;

import Attack.SingleAttack;
import Attack.SlowAttack;
import Game.*;
import Level.Level;
import Render.Render;
import Tower.NormalTower;
import Tower.SlowTower;
import Tower.Tower;
import Tower.TowerManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel {
    Level level = new Level();
    Render render = new Render(level.getEnemyManager(), level.getMovement(), level);

    Timer timer;
    Game game;
    TowerManager towerManager;
    TowerMenu towerMenu;
    WaveManager waveManager;
    private boolean running = false;
    private MainFrame mainFrame;
    private ShopManager shopManager;


    public GamePanel(Game game, TowerMenu towerMenu, MainFrame mainFrame, WaveManager waveManager, ShopManager shopManager) {
        this.waveManager = waveManager;
        this.game = game;
        this.mainFrame = mainFrame;
        this.shopManager = shopManager;
        towerManager = new TowerManager(level,game);
        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);
        shopManager.setCoins(150);

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
                try {
                    switch (towerMenu.getCurrentlySelectedTower()) {
                        case "Normal Tower":
                            Tower tower = Tower.createTower(1, tileX, tileY);
                            if (shopManager.buyTower(tower)) {
                                towerManager.getTowers()[tileX][tileY] = tower;
                                towerManager.updateTowers(level);
                                repaint();
                                break;
                            }

                            towerMenu.setCurrentlySelectedTower(null);

                            break;
                        case "Slow Tower":
                            Tower tower1 = Tower.createTower(2, tileX, tileY);
                            if (shopManager.buyTower(tower1)) {
                                towerManager.getTowers()[tileX][tileY] = tower1;
                                towerManager.updateTowers(level);
                                repaint();
                                break;
                            }

                            break;
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                System.out.println(tileX + " " + tileY);
                mainFrame.setGameState(GameState.PLAY);


            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        render.drawLevel(g2d, level);
        render.drawEnemy(g2d, game);
        render.drawTowers(g2d, level, towerManager);
        render.renderProjectile(g2d, level);
        render.drawWave(g2d, waveManager);
        render.drawCoins(g2d,game.getShopManager());

    }

    public void actionPerformed(ActionEvent e) {
        if (waveManager.getCurrentWave() < waveManager.getWaves().size()) {
            level.getEnemyManager().spawnEnemy(waveManager.getWaves().get(waveManager.getCurrentWave()));
        }
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
            Timer deleyTimer = new Timer(500, e -> {
                timer.start();
            });
            deleyTimer.setRepeats(false);
            deleyTimer.start();

        }
    }

    public Level getLevel() {
        return level;
    }
}
