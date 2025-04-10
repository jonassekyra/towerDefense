public class Movement {

    public void move(Enemy enemy, Level level) {
        enemy.setLastX(enemy.getX());
        enemy.setLastY(enemy.getY());
        if (level.getMap()[enemy.getX() + 1][enemy.getY()] == 1 && (enemy.getX() + 1) != enemy.getLastX()) {
            enemy.setX(enemy.getX() + 1);
        } else if (level.getMap()[enemy.getX()][enemy.getY() + 1] == 1 && (enemy.getY() + 1) != enemy.getLastY()) {
            enemy.setY(enemy.getY() + 1);
        } else if (level.getMap()[enemy.getX()][enemy.getY() - 1] == 1&& (enemy.getY() - 1) != enemy.getLastY()) {
            enemy.setY(enemy.getY() - 1);
        } else if (level.getMap()[enemy.getX() - 1][enemy.getY()] == 1 && (enemy.getX() - 1)!= enemy.getLastX()) {
            enemy.setX(enemy.getX() - 1);
        }
    }
}