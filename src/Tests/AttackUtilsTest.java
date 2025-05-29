package Tests;

import Attack.AttackUtils;
import Enemy.Enemy;
import Game.ShopManager;
import Tower.NormalTower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttackUtilsTest {

    private List<Enemy> enemies;
    private ShopManager shopManager;
    private Enemy enemy;
    private Enemy enemy1;
    private NormalTower tower;

    @BeforeEach
    void setUp() {
        tower = new NormalTower();
        enemies = new ArrayList<>();
        shopManager = new ShopManager();
        enemy = new Enemy();
        enemy1 = new Enemy();
        enemy.setProgress(2);
        enemy1.setProgress(4);
        enemy.setHealth(-1);
        enemies.add(enemy1);
        enemies.add(enemy);
        tower.setPosX(2);
        tower.setPosY(4);
    }

    @Test
    void removeDeadEnemy() {
        AttackUtils.removeDeadEnemy(enemies, shopManager, enemy);

        assertFalse(enemies.contains(enemy));

    }

    @Test
    void getFirstTarget() {
        Enemy result = AttackUtils.getFirstTarget(enemies);

        assertEquals(enemy1, result);
    }

    @Test
    void calculateStart() {
        int[] start = AttackUtils.calculateStart(tower);

        assertEquals(182, start[0]);
        assertEquals(332, start[1]);
    }
}