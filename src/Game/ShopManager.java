package Game;

import Enemy.Enemy;
import Tower.Tower;

public class ShopManager implements Resettable {
    private int coins;

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

    public void addCoins(Enemy enemy) {
       coins += enemy.getReward();
    }

    @Override
    public void reset() {
        setCoins(400);
    }
}
