package Panels;

import Attack.SingleAttack;
import Attack.SlowAttack;
import Game.*;
import Level.Level;
import Render.Render;
import Tower.NormalTower;
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
    TowerManager towerManager = new TowerManager(level);
    Timer timer;
    Game game;
    TowerMenu towerMenu;


    public GamePanel(Game game, TowerMenu towerMenu) {
        this.game = game;
        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);

        timer = new Timer(16, this::actionPerformed);
        timer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int tileX = e.getX() / 75;
                int tileY = e.getY() / 75;
                if (!game.getGameState().equals(GameState.PLACING_TOWER)) {
                    return;
                }
                if (!(level.getMap()[tileX][tileY] != 1 && (tileX < 10 && tileY < 10))) {
                    return;
                }
                try {
                    switch (towerMenu.getCurrentlySelectedTower()) {
                        case "Normal Tower":
                            BufferedImage towerImage = ImageIO.read(getClass().getResource("/tiles/Red.png"));
                            towerManager.getTowers()[tileX][tileY] = new NormalTower(20, towerImage, 3, 3, tileX, tileY, new SingleAttack(), 1000);
                            towerManager.getTowers()[tileX][tileY].setImage(towerImage);
                            towerMenu.setCurrentlySelectedTower(null);
                            break;

                        case "Slow Tower":
                            BufferedImage slowImage = ImageIO.read(getClass().getResource("/tiles/Red.png"));
                            towerManager.getTowers()[tileX][tileY] = new NormalTower(20, slowImage, 3, 3, tileX, tileY, new SlowAttack(), 1000);
                            towerManager.getTowers()[tileX][tileY].setImage(slowImage);
                            towerMenu.setCurrentlySelectedTower(null);
                            break;
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                System.out.println(tileX + " " + tileY);
                game.setGameState(GameState.DEFAULT);


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

    }

    public void actionPerformed(ActionEvent e) {
        level.getEnemyManager().spawnEnemy();
        repaint();
        towerManager.updateTowers(level);
    }

}
