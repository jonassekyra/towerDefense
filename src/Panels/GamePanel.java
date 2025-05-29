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

/**
 * Panel on which the game itself is shown(map,enemies,towers,etc...)
 */
public class GamePanel extends JPanel {
    /**
     * Timer that controls how often the game is refreshed.
     */
    private final Timer timer;
    private final Game game;
    private final TowerManager towerManager;
    private final WaveManager waveManager;
    private boolean running = false;
    private final MainFrame mainFrame;
    private final Level level;
    /**
     * Class where all the render methods are.
     */
    private final Render render;


    /**
     * Creating instances.
     * Creating Timer.
     * Mouse Listener that checks where the player clicked, whether, if the player can place a tower there.
     *
     * @param game Game containing health.
     * @param towerMenu TowerMenu used to get selected tower.
     * @param mainFrame MainFrame Main frame of the game.
     * @param waveManager WaveManager used for getting to info about waves.
     * @param shopManager Class responsible for keeping track of coins.
     */
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
                mainFrame.switchPanels(GameState.PLAY);


            }
        });
    }

    /**
     * Calls render methods.
     * @param g  the <code>Graphics</code> context in which to paint
     */
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

    /**
     * Calls methods for: spawning enemies, removing slow effect, updates towers, projectiles.
     * Ends timer when the game stops.
     * @param e event e.
     */
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

    /**
     * Start timer after 5 seconds.
     * Delay timer doesn't repeat.
     */
    public void startGame() {
        if (!running) {
            running = true;
            Timer deleyTimer = new Timer(5000, e -> timer.start());
            deleyTimer.setRepeats(false);
            deleyTimer.start();

        }
    }

    public Level getLevel() {
        return level;
    }

}
