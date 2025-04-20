import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    GamePanel gamePanel;
    TowerMenu towerMenu;
    public MainFrame() {
        gamePanel = new GamePanel();
        towerMenu = new TowerMenu();
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
