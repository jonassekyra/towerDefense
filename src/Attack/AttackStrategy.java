package Attack;

import Game.ShopManager;
import Level.Level;
import Tower.Tower;

/**
 * Interface for creating different attack strategies
 */
public interface AttackStrategy {
    /**
     *Method used for firing projectiles.
     * @param level Current level.
     * @param tower Tower that will shoot.
     * @param shopManager Class responsible for keeping track of coins.
     */
    void attack(Level level, Tower tower, ShopManager shopManager);




}
