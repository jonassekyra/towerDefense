package Panels;

import Attack.SingleAttack;
import Game.*;
import Level.Level;
import Render.Render;
import Tower.NormalTower;
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
    Render render = new Render(level.getEnemyManager(),level.getMovement(),level);
    Timer timer;
    Game game;


    public GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);

        timer = new Timer(16, this::actionPerformed);
        timer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int tileX = e.getX()/75;
                int tileY = e.getY()/75;
                if (game.getGameState().equals(GameState.PLACING_TOWER)){
                    if (level.getMap()[tileX][tileY] != 1 && (tileX< 10 && tileY< 10)){
                        try {
                            BufferedImage towerImage = ImageIO.read(getClass().getResource("/tiles/Red.png"));
                            level.getTowers()[tileX][tileY] = new NormalTower(20,towerImage,3,3,tileX,tileY,new SingleAttack(),1000);
                            level.getTowers()[tileX][tileY].setImage(towerImage);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                    System.out.println(tileX + " " + tileY);
                    game.setGameState(GameState.DEFAULT);
                }

                //System.out.println(level.getMap()[tileX][tileY]);
                //System.out.println(level.getTiles()[tileX][tileY].getTileType());
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        level.drawLevel(g2d);
        //level.drawEnemy(g2d,game);
        render.drawEnemy(g2d,game);
        level.drawTowers(g2d);

    }
    public void actionPerformed(ActionEvent e) {
        repaint();
        level.goThroughTowers();
    }

}
