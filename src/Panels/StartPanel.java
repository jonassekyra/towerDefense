package Panels;


import javax.swing.*;
import java.awt.*;
import Game.GameState;
import Game.MainFrame;


public class StartPanel extends JPanel {
    private JButton startButton;
    public StartPanel(MainFrame mainFrame) {
        setLayout(null);
        setPreferredSize(new Dimension(750, 750));

        startButton = new JButton("Start");
        startButton.setBounds(270, 400, 75, 70);
        startButton.addActionListener(e -> {
            mainFrame.setGameState(GameState.DEFAULT);


        });
        this.add(startButton);
    }

}
