package Tests;

import Attack.Projectile;
import Enemy.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {
    private Projectile projectile = new Projectile();
    private Enemy enemyInRange = new Enemy();

    @BeforeEach
    void setUp() {
        projectile.setX(75);
        projectile.setY(75);
        enemyInRange.setPixelX(75 + (75/3));
        enemyInRange.setPixelY(75 + (75/3));
    }

    @Test
    void hasHit() {
        boolean result = projectile.hasHit(enemyInRange);
        assertFalse(result);

    }
}