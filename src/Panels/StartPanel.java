package Panels;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import Game.GameState;
import Game.MainFrame;


public class StartPanel extends JPanel {
    private final Image background;
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
        startButton.addActionListener(e -> mainFrame.setGameState(GameState.PLAY));
        this.add(startButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background,0,0, getWidth(), getHeight(), null);
    }

}
