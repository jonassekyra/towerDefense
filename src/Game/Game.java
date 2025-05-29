package Game;

/**
 * Hold ShopManager and health.
 */
public class Game implements Resettable {
    /**
     * Players health.
     */
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

    /**
     * Sets health back to 100.
     */
    @Override
    public void reset() {
        setHealth(100);
    }
}
