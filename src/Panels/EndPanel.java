package Panels;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {
    public EndPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(750, 750));
        repaint();

    }

    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Congratulations", 330, 310);
        g2d.drawString("You have finished the game!", 300, 330);
    }
}
