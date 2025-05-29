package Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Panel that is shown when the game is finished.
 */
public class EndPanel extends JPanel {

    private final Image background;

    /**
     * Loading Image from resources.
     */
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

    /**
     * Drawing the background image.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, getWidth(),getHeight(), null);
    }
}
