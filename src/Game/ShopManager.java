package Game;

import Enemy.Enemy;
import Tower.Tower;

/**
 * Manages coins.
 */
public class ShopManager implements Resettable {
    /**
     * Players currency.
     */
    private int coins;

    /**
     * If the player has enough coin it lets him buy a tower and removes the coins from him.
     * @param tower Tower the player wants to buy.
     * @return True if the player has enough coins.
     */
   public boolean buyTower(Tower tower) {
       if (coins >= tower.getCost()){
           coins -= tower.getCost();
            return true;
       }else {
           return false;
       }

   }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Adds coins to player based on the reward from the enemy.
     * @param enemy that has been killed.
     */
    public void addCoins(Enemy enemy) {
       coins += enemy.getReward();
    }

    /**
     * Resets the amount of coins.
     */
    @Override
    public void reset() {
        setCoins(400);
    }
}
