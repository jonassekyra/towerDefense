package Game;

import Panels.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final GamePanel gamePanel;
    private final TowerMenu towerMenu;
    private final Game game;
    private GameState gameState;
    private final JPanel panels;
    private final CardLayout cardLayout;
    private final JPanel towerGamePanel;
    private final WaveManager waveManager;


    public MainFrame() {

        waveManager = new WaveManager();
        game = new Game();
        game.setHealth(100);
        setResizable(false);


        cardLayout = new CardLayout();
        panels = new JPanel(cardLayout);

        towerMenu = new TowerMenu(this, waveManager);
        gamePanel = new GamePanel(game, towerMenu, this, waveManager, game.getShopManager());
        EndPanel endPanel = new EndPanel();
        GameOverPanel gameOverPanel = new GameOverPanel(this);
        StartPanel startPanel = new StartPanel(this);

        towerGamePanel = new JPanel();
        towerGamePanel.setLayout(new BorderLayout());
        towerGamePanel.add(gamePanel, BorderLayout.CENTER);
        towerGamePanel.add(towerMenu, BorderLayout.EAST);

        panels.add(startPanel, GameState.START.name());
        panels.add(towerGamePanel, GameState.PLAY.name());
        panels.add(endPanel, GameState.END.name());
        panels.add(gameOverPanel,GameState.GAME_OVER.name());


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
        switch (gameState) {
            case PLACING_TOWER:
                break;
            case START:
                cardLayout.show(panels, gameState.name());
                System.out.println(gameState.name());
                break;
            case PLAY:
                cardLayout.show(panels, gameState.name());
                gamePanel.startGame();
                break;
            case END, GAME_OVER:
                cardLayout.show(panels, gameState.name());
                break;
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public Game getGame() {
        return game;
    }

    public void restartGame() {

        towerGamePanel.remove(gamePanel);

        GamePanel gamePanel = new GamePanel(game, towerMenu, this, waveManager, game.getShopManager());
        towerGamePanel.add(gamePanel,BorderLayout.CENTER);
        game.reset();
        waveManager.reset();
        revalidate();
        repaint();
        gamePanel.startGame();
    }
}
