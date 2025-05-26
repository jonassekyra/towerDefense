package Panels;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TowerMenu extends JPanel {
    JButton normalTower = new JButton("Normal Tower");
    ImageIcon icon = new ImageIcon(getClass().getResource("/Tiles/zelena.png"));
    JButton slowTower = new JButton("Slow Tower",icon);
    JButton nextWave = new JButton("Next Wave");
    private JButton restart = new JButton("Restart");
    private String currentlySelectedTower = null;
    private HashMap<String,JButton> towerButtons = new HashMap<>();



    public String getCurrentlySelectedTower() {
        return currentlySelectedTower;
    }

    public void setCurrentlySelectedTower(String currentlySelectedTower) {
        this.currentlySelectedTower = currentlySelectedTower;
    }

    public TowerMenu(Game game, MainFrame mainFrame, WaveManager waveManager) {
        towerButtons.put(normalTower.getText(),normalTower);
        towerButtons.put(slowTower.getText(),slowTower);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.GRAY);
        //mainFrame.setGameState(GameState.PLAY);

        add(Box.createRigidArea(new Dimension(0, 20)));
        normalTower.setPreferredSize(new Dimension(200, 30));
        //normalTower.setBackground(Color.BLUE);
        nextWave.setPreferredSize(new Dimension(200, 30));

        slowTower.setPreferredSize(new Dimension(200, 30));
        slowTower.setVerticalAlignment(SwingConstants.CENTER);
        //slowTower.setOpaque(false);
        slowTower.setBorderPainted(false);
        //slowTower.setContentAreaFilled(false);
        slowTower.setHorizontalAlignment(SwingConstants.CENTER);
        //slowTower.setBackground(Color.BLUE);
        nextWave.setHorizontalAlignment(SwingConstants.CENTER);
        add(nextWave);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(normalTower);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(slowTower);

        restart.setPreferredSize(new Dimension(200, 30));
        restart.setVerticalAlignment(SwingConstants.CENTER);
        restart.setOpaque(false);
        restart.setBorderPainted(false);
        restart.setContentAreaFilled(false);
        restart.setHorizontalAlignment(SwingConstants.CENTER);
        add(restart);

        restart.addActionListener(e -> {
            //MainFrame mainFrame = new MainFrame();


        });

        normalTower.addActionListener(e -> {
            mainFrame.setGameState(GameState.PLACING_TOWER);
            //currentlySelectedTower = normalTower.getText();
            //setCurrentlySelectedTower(normalTower.getText());
            selectTower(normalTower.getText());


        });
        slowTower.addActionListener(e -> {
            mainFrame.setGameState(GameState.PLACING_TOWER);
            //if (game.getShopManager().buyTower())
            selectTower(slowTower.getText());
            //currentlySelectedTower = slowTower.getText();
        });

        nextWave.addActionListener(e -> {
            waveManager.nextWave();
        });
    }

    public HashMap<String, JButton> getTowerButtons() {
        return towerButtons;
    }

    public void setTowerButtons(HashMap<String, JButton> towerButtons) {
        this.towerButtons = towerButtons;
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
