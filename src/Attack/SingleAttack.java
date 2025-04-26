package Attack;

import Enemy.Enemy;
import Level.Level;
import Tower.Tower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleAttack implements AttackStrategy {
    public SingleAttack() {
    }

    @Override
    public void attack(Level level, Tower tower) {
        Iterator<Enemy> it = level.getEnemies().iterator();
        while (it.hasNext()) {

            Enemy enemy = it.next();
            if (!enemy.isAlive()){
                it.remove();
            }
            int distanceX = enemy.getX() - tower.getPosX();
            int distanceY = enemy.getY() - tower.getPosY();

            if (Math.abs(distanceX) < tower.getRangeX() && Math.abs(distanceY) < tower.getRangeY()) {
                //results.add(enemy);
                enemy.takeDamage(tower.getDamage(),level.getEnemies());
                System.out.println(enemy.getHealth());
            }
        }
    }
}
