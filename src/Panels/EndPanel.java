package Panels;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {
    public EndPanel() {

        setPreferredSize(new Dimension(750, 750));
        repaint();
        this.setBackground(Color.WHITE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Congratulations", 330, 310);
        g2d.drawString("You have finished the game!", 300, 330);
    }
}
