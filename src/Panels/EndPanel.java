package Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class EndPanel extends JPanel {

    private final Image  background;

    public EndPanel() {

        setPreferredSize(new Dimension(750, 750));
        repaint();
        this.setBackground(Color.WHITE);
        try{
            background = ImageIO.read(Objects.requireNonNull(getClass().getResource("/end_screen.png")));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, getWidth(),getHeight(), null);
    }
}
