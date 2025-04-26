package Panels;

import Game.*;

import javax.swing.*;
import java.awt.*;

public class TowerMenu extends JPanel {
    JButton normalTower = new JButton("Normal Tower");
    JButton slowTower = new JButton("Slow Tower");

    public TowerMenu(Game game) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);
        game.setGameState(GameState.DEFAULT);

        add(Box.createRigidArea(new Dimension(0, 20)));
        normalTower.setPreferredSize(new Dimension(200, 30));

        slowTower.setPreferredSize(new Dimension(200, 30));
        slowTower.setVerticalAlignment(SwingConstants.CENTER);
        slowTower.setHorizontalAlignment(SwingConstants.CENTER);

        add(normalTower);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(slowTower);
        normalTower.addActionListener(e ->{
            game.setGameState(GameState.PLACING_TOWER);

        });
        slowTower.addActionListener(e ->{
            game.setGameState(GameState.PLACING_TOWER);
        });
    }

}
