import javax.swing.*;

public class MainFrame extends JFrame {
    GamePanel gamePanel;
    public MainFrame() {
        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
