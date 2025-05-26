package Panels;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class TowerMenu extends JPanel {
    JButton normalTower = new JButton("Normal Tower");
    ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Tiles/zelena.png")));
    JButton slowTower = new JButton("Slow Tower",icon);
    JButton nextWave = new JButton("Next Wave");
    private final JButton restart = new JButton("Restart");
    private String currentlySelectedTower = null;
    private HashMap<String,JButton> towerButtons = new HashMap<>();



    public String getCurrentlySelectedTower() {
        return currentlySelectedTower;
    }



    public TowerMenu(MainFrame mainFrame, WaveManager waveManager) {
        towerButtons.put(normalTower.getText(),normalTower);
        towerButtons.put(slowTower.getText(),slowTower);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);

        add(Box.createRigidArea(new Dimension(0, 20)));

        normalTower.setPreferredSize(new Dimension(200, 30));

        nextWave.setPreferredSize(new Dimension(200, 30));

        slowTower.setPreferredSize(new Dimension(200, 30));
        slowTower.setVerticalAlignment(SwingConstants.CENTER);
        slowTower.setBorderPainted(false);
        slowTower.setHorizontalAlignment(SwingConstants.CENTER);
        nextWave.setHorizontalAlignment(SwingConstants.CENTER);

        add(nextWave);

        add(Box.createRigidArea(new Dimension(0, 20)));

        add(normalTower);

        add(Box.createRigidArea(new Dimension(0, 20)));

        add(slowTower);

        restart.setPreferredSize(new Dimension(200, 30));

        add(restart);

        restart.addActionListener(e -> {


        });

        normalTower.addActionListener(e -> {
            mainFrame.setGameState(GameState.PLACING_TOWER);
            selectTower(normalTower.getText());


        });
        slowTower.addActionListener(e -> {
            mainFrame.setGameState(GameState.PLACING_TOWER);
            selectTower(slowTower.getText());
        });

        nextWave.addActionListener(e -> waveManager.nextWave());
    }

    public void selectTower(String towerName) {
        for (JButton button : towerButtons.values()) {
            button.setBackground(Color.WHITE);
        }


        JButton selectedButton = towerButtons.get(towerName);
        if (selectedButton != null) {
            selectedButton.setBackground(Color.RED);
        }

        currentlySelectedTower = towerName;


    }

    public void unselectTower() {
        currentlySelectedTower = null;
        for (JButton button : towerButtons.values()) {
            button.setBackground(Color.WHITE);
        }
    }

}
