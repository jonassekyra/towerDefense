package Panels;

import Game.GameState;
import Game.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GameOverPanel extends JPanel {
    private final Image background;
    private JButton restartButton = new JButton("Restart");

    public GameOverPanel(MainFrame mainFrame) {
        setPreferredSize(new Dimension(750, 750));

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Game_Over_Screen.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        add(restartButton);
        restartButton.addActionListener(e -> {
            mainFrame.restartGame();
            mainFrame.setGameState(GameState.START);
        });


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
    }
}
