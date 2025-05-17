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
    private CardLayout cardLayout;

    public MainFrame() {
        game = new Game();
        game.setHealth(100);


        towerMenu = new TowerMenu(game,this);
        gamePanel = new GamePanel(game, this);
        startPanel = new StartPanel(this);

        cardLayout = new CardLayout();
        panels = new JPanel(cardLayout);

        panels.add(startPanel, GameState.START.name());
        panels.add(gamePanel, GameState.DEFAULT.name());

        this.setLayout(new BorderLayout());
        this.add(panels, BorderLayout.CENTER);
        this.setTitle("TowerDefense");
        this.add(towerMenu, BorderLayout.EAST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //cardLayout.show(panels, "startPanel");


        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setGameState(GameState.START);

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        switch (gameState) {
            case START:
                cardLayout.show(panels, "START");
                break;
            case DEFAULT:
                cardLayout.show(panels, "DEFAULT");
                gamePanel.startGame();
                break;
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}
