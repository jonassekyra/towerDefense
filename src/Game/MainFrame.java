package Game;

import Panels.GamePanel;
import Panels.StartPanel;
import Panels.TowerMenu;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    GamePanel gamePanel;
    TowerMenu towerMenu;
    StartPanel startPanel;
    Game game;
    private GameState gameState;
    private JPanel panels;
    CardLayout cardLayout;
    private JPanel towerGamePanel;

    public MainFrame() {
        game = new Game();
        game.setHealth(100);


        cardLayout = new CardLayout();
        panels = new JPanel(cardLayout);

        towerMenu = new TowerMenu(game, this);
        gamePanel = new GamePanel(game, towerMenu, this);
        startPanel = new StartPanel(this);

        towerGamePanel = new JPanel();
        towerGamePanel.setLayout(new BorderLayout());
        towerGamePanel.add(gamePanel, BorderLayout.CENTER);
        towerGamePanel.add(towerMenu, BorderLayout.EAST);

        panels.add(startPanel, GameState.START.name());
        panels.add(towerGamePanel, GameState.PLAY.name());


        this.setLayout(new BorderLayout());
        this.add(panels, BorderLayout.CENTER);
        this.setTitle("TowerDefense");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setGameState(GameState.START);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        if (gameState == null) {
            System.out.println("Game state is null");
        }
        switch (gameState) {
            case PLACING_TOWER:

                break;
            case START:

                cardLayout.show(panels, gameState.name());
                break;
            case PLAY:

                cardLayout.show(panels, gameState.name());
                //cardLayout.show(panels, "towerMenu");
                gamePanel.startGame();
                break;
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}
