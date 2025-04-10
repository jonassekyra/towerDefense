import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    Level level = new Level();
    Timer timer;


    public GamePanel() {
        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);

        timer = new Timer(16, this::actionPerformed);
        timer.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        level.drawLevel(g2d);
        level.drawEnemy(g2d);

    }
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    private void updateGame(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        level.drawEnemy(g2d);
    }
}
