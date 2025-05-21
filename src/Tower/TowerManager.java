package Tower;

import Level.Level;

public class TowerManager {
    private Level level;
    private final Tower[][] towers = new Tower[10][10];

    public TowerManager(Level level) {
        this.level = level;
    }



    public void updateTowers(Level level) {
        for (int i = 0; i < level.getMap().length; i++) {
            for (int j = 0; j < level.getMap().length; j++) {
                if (towers[i][j] != null) {
                    towers[i][j].canAttack(level);
                }
            }
        }
    }

    public Tower[][] getTowers() {
        return towers;
    }


}
