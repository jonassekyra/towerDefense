package Tower;

import Game.Game;
import Level.Level;

public class TowerManager {
    private Level level;
    private Game game;
    private final Tower[][] towers = new Tower[10][10];

    public TowerManager(Level level, Game game) {
        this.level = level;
        this.game = game;
    }



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
