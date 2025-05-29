package Game;

public class Game implements Resettable {
    private int health;
    private final ShopManager shopManager;

    public Game() {
        shopManager = new ShopManager();
    }

    public ShopManager getShopManager() {
        return shopManager;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void reset() {
        setHealth(100);
    }
}
