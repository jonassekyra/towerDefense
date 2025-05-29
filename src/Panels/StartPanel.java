package Panels;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import Game.GameState;
import Game.MainFrame;

/**
 * Panel that is shown on the start of the game.
 */
public class StartPanel extends JPanel {


    private final Image background;

    /**
     * Adds startButton, background image.
     * Button is placed on a picture, so it doesn't have any graphics, it's transparent.
     * @param mainFrame Main frame of the game.
     */
    public StartPanel(MainFrame mainFrame) {
        setLayout(null);
        setPreferredSize(new Dimension(750, 750));
        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Start_Screen.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        JButton startButton = new JButton();
        startButton.setFocusPainted(true);
        startButton.setContentAreaFilled(false);
        startButton.setBounds(145, 485, 680, 100);
        startButton.addActionListener(e -> mainFrame.switchPanels(GameState.PLAY));
        this.add(startButton);
    }

    /**
     * Drawing the background image.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background,0,0, getWidth(), getHeight(), null);
    }

}
