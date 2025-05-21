package Panels;

import Game.*;

import javax.swing.*;
import java.awt.*;

public class TowerMenu extends JPanel {
    JButton normalTower = new JButton("Normal Tower");
    JButton slowTower = new JButton("Slow Tower");
    JButton nextWave = new JButton("Next Wave");
    private String currentlySelectedTower = null;


    public String getCurrentlySelectedTower() {
        return currentlySelectedTower;
    }

    public void setCurrentlySelectedTower(String currentlySelectedTower) {
        this.currentlySelectedTower = currentlySelectedTower;
    }

    public TowerMenu(Game game, MainFrame mainFrame, WaveManager waveManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);
        //mainFrame.setGameState(GameState.PLAY);

        add(Box.createRigidArea(new Dimension(0, 20)));
        normalTower.setPreferredSize(new Dimension(200, 30));
        nextWave.setPreferredSize(new Dimension(200, 30));

        slowTower.setPreferredSize(new Dimension(200, 30));
        slowTower.setVerticalAlignment(SwingConstants.CENTER);
        slowTower.setHorizontalAlignment(SwingConstants.CENTER);
        nextWave.setHorizontalAlignment(SwingConstants.CENTER);
        add(nextWave);
        add(Box.createRigidArea(new Dimension(0, 20)));
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

        nextWave.addActionListener(e -> {
            waveManager.setCurrentWave(waveManager.getCurrentWave() + 1);
        });
    }

}
