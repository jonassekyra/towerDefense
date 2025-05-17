package Panels;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TowerMenu extends JPanel {
    JButton normalTower = new JButton("Normal Tower");
    JButton slowTower = new JButton("Slow Tower");
    private String currentlySelectedTower = null;


    public String getCurrentlySelectedTower() {
        return currentlySelectedTower;
    }

    public void setCurrentlySelectedTower(String currentlySelectedTower) {
        this.currentlySelectedTower = currentlySelectedTower;
    }

    public TowerMenu(Game game, MainFrame mainFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);
        mainFrame.setGameState(GameState.DEFAULT);

        add(Box.createRigidArea(new Dimension(0, 20)));
        normalTower.setPreferredSize(new Dimension(200, 30));

        slowTower.setPreferredSize(new Dimension(200, 30));
        slowTower.setVerticalAlignment(SwingConstants.CENTER);
        slowTower.setHorizontalAlignment(SwingConstants.CENTER);

        add(normalTower);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(slowTower);
        normalTower.addActionListener(e -> {
            mainFrame.setGameState(GameState.PLACING_TOWER);
            currentlySelectedTower = normalTower.getText();

        });
        slowTower.addActionListener(e -> {
            mainFrame.setGameState(GameState.PLACING_TOWER);
            currentlySelectedTower = slowTower.getText();
        });
    }

}
