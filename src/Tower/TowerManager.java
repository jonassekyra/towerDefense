package Tower;

import Game.Game;
import Level.Level;

/**
 * Holds towers.
 */
public class TowerManager {
    private final Game game;
    private final Tower[][] towers = new Tower[10][10];

    public TowerManager(Game game) {
        this.game = game;
    }


    /**
     * iterates trough towers and checks if they can attack.
     * @param level current level with projectiles.
     */
    public void updateTowers(Level level) {
        for (int i = 0; i < level.getMap().length; i++) {
            for (int j = 0; j < level.getMap().length; j++) {
                if (towers[i][j] != null) {
                    towers[i][j].canAttack(level, game.getShopManager());
                }
            }
        }
    }

    public Tower[][] getTowers() {
        return towers;
    }


}
