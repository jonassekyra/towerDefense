package Panels;

import Game.GameState;
import Game.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Panel that is shown when the player loses the game.
 */
public class GameOverPanel extends JPanel {
    private final Image background;

    /**
     * Adding restart button.
     * Loading Image from resources.
     * @param mainFrame Main frame of the game.
     */
    public GameOverPanel(MainFrame mainFrame) {
        setLayout(null);
        setPreferredSize(new Dimension(750, 750));
        JButton restartButton = new JButton();
        restartButton.setSize(525,100);
        restartButton.setLocation(220,460);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(true);
        add(restartButton);

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Game_Over_Screen.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        restartButton.addActionListener(e -> {
            mainFrame.restartGame();
            mainFrame.switchPanels(GameState.START);
        });


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
