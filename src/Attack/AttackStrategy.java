package Attack;

import Game.ShopManager;
import Level.Level;
import Tower.Tower;

public interface AttackStrategy {

    void attack(Level level, Tower tower, ShopManager shopManager);




}
