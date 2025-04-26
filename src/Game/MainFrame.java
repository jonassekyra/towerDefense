package Game;

import Panels.GamePanel;
import Panels.TowerMenu;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    GamePanel gamePanel;
    TowerMenu towerMenu;
    Game game;
    public MainFrame() {
        game = new Game();
        game.setHealth(100);
        gamePanel = new GamePanel(game);
        towerMenu = new TowerMenu(game);

        this.setLayout(new BorderLayout());
        this.add(gamePanel, BorderLayout.CENTER);
        this.setTitle("TowerDefense");
        this.add(towerMenu, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
