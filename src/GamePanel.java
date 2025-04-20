import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    Level level = new Level();
    Timer timer;


    public GamePanel() {
        this.setPreferredSize(new Dimension(750, 750));
        this.setVisible(true);

        timer = new Timer(16, this::actionPerformed);
        timer.start();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int tileX = e.getX()/75;
                int tileY = e.getY()/75;
                System.out.println(tileX + " " + tileY);
            }
        });
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
