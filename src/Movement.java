public class Movement {
    Enemy enemy;
    Level level;

    public void move(Enemy enemy, Level level) {
        if (level.getTiles()[enemy.getX() + 1][enemy.getY()].equals(1)) {
            enemy.setX(enemy.getX() + 1);
        } else if (level.getTiles()[enemy.getX()][enemy.getY() + 1].equals(1)) {
            enemy.setX(enemy.getX() - 1);
        } else if (level.getTiles()[enemy.getX() - 1][enemy.getY()].equals(1)) {
            enemy.setY(enemy.getY() + 1);
        } else if (level.getTiles()[enemy.getX()][enemy.getY() - 1].equals(1)) {
            enemy.setY(enemy.getY()-1);
        }

    }
}