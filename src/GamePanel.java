import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Level level = new Level();

    public GamePanel() {
        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        level.drawLevel(g2d);

    }
}
