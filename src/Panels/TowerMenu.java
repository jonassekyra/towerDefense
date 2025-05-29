package Panels;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class TowerMenu extends JPanel {

    private final ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/normal_tower.png")));
    private final JButton normalTower = new JButton("Normal Tower - 80", icon);

    private final ImageIcon slowIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/slow_tower.png")));
    private final JButton slowTower = new JButton("Slow Tower - 100", slowIcon);

    private String currentlySelectedTower = null;
    private final HashMap<String, JButton> towerButtons = new HashMap<>();


    public String getCurrentlySelectedTower() {
        return currentlySelectedTower;
    }


    public TowerMenu(MainFrame mainFrame, WaveManager waveManager) {


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);

        add(Box.createRigidArea(new Dimension(0, 20)));

        normalTower.setPreferredSize(new Dimension(250, 30));
        normalTower.setFocusable(true);
        normalTower.setName("Normal Tower");
        normalTower.setBackground(Color.GRAY);


        ImageIcon nextIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/next_wave.png")));
        JButton nextWave = new JButton(nextIcon);
        nextWave.setFocusPainted(true);
        nextWave.setBackground(Color.LIGHT_GRAY);


        slowTower.setPreferredSize(new Dimension(250, 30));
        slowTower.setFocusPainted(true);
        slowTower.setName("Slow Tower");
        slowTower.setBackground(Color.GRAY);

        towerButtons.put(normalTower.getName(), normalTower);
        towerButtons.put(slowTower.getName(), slowTower);

        nextWave.setHorizontalAlignment(SwingConstants.CENTER);

        add(nextWave);

        add(Box.createRigidArea(new Dimension(0, 20)));

        add(normalTower);

        add(Box.createRigidArea(new Dimension(0, 20)));

        add(slowTower);


        normalTower.addActionListener(e -> {
            mainFrame.switchPanels(GameState.PLACING_TOWER);
            selectTower(normalTower.getName());


        });
        slowTower.addActionListener(e -> {
            mainFrame.switchPanels(GameState.PLACING_TOWER);
            selectTower(slowTower.getName());
        });

        nextWave.addActionListener(e -> {
             waveManager.nextWave();



        });


    }

    public void selectTower(String towerName) {
        for (JButton button : towerButtons.values()) {
            button.setBackground(Color.GRAY);
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
            button.setBackground(Color.GRAY);
        }
    }

}
