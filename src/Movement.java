public class Movement {
/*
    public void move(Enemy enemy, Level level) {
        enemy.setLastX(enemy.getX());
        enemy.setLastY(enemy.getY());
        Position currentPosition = new Position(enemy.getX(),enemy.getY());
        Position lastPosition = new Position(enemy.getX(),enemy.getY());
        //&& (enemy.getX() + 1) != enemy.getLastX()
        if (level.getMap()[enemy.getX() + 1][enemy.getY()] == 1 && !lastPosition.equals(currentPosition.right())) {
            enemy.setX(enemy.getX() + 1);
            //(enemy.getY() + 1) != enemy.getLastY()
            //!lastPosition.equals(new Position(enemy.getX(), enemy.getY() + 1))
        } else if (level.getMap()[enemy.getX()][enemy.getY() + 1] == 1 && (enemy.getY() + 1) != enemy.getLastY() && enemy.getY() != enemy.getLastY()) {
            enemy.setY(enemy.getY() + 1);
            //(enemy.getY() - 1) != enemy.getLastY()
        } else if (level.getMap()[enemy.getX()][enemy.getY() - 1] == 1 &&  !lastPosition.equals(new Position(enemy.getX(), enemy.getY() - 1))) {
            enemy.setY(enemy.getY() - 1);
            //(enemy.getX() - 1)!= enemy.getLastX()
        } else if (level.getMap()[enemy.getX() - 1][enemy.getY()] == 1 && !lastPosition.equals(currentPosition.left())) {
            enemy.setX(enemy.getX() - 1);
        }
    }

 */

    public void move(Enemy enemy, Level level) {

        Position lastPosition = new Position(enemy.getX(), enemy.getY());
        Position currentPosition = new Position(enemy.getX(), enemy.getY());
        Position finishPosition = new Position(enemy.getEndX(), enemy.getEndY());
        if (!currentPosition.equals(finishPosition)) {
            if (level.getMap()[enemy.getX() + 1][enemy.getY()] == 1 && !lastPosition.equals(currentPosition.right())) {
                // This sets the value of the location to a high number that is unreachable so it cannot be accessed.
                System.out.println(currentPosition.right());
                level.getMap()[enemy.getX()][enemy.getY()] = 10;
                enemy.setX(enemy.getX() + 1);

            } else if (level.getMap()[enemy.getX() - 1][enemy.getY()] == 1 && !lastPosition.equals(currentPosition.left())) {
                level.getMap()[enemy.getX()][enemy.getY()] = 10;
                System.out.println(currentPosition.left());
                enemy.setX(enemy.getX() - 1);

            } else if (level.getMap()[enemy.getX()][enemy.getY() + 1] == 1 && !lastPosition.equals(currentPosition.down())) {
                level.getMap()[enemy.getX()][enemy.getY()] = 10;
                System.out.println(currentPosition.down());
                enemy.setY(enemy.getY() + 1);

            } else if (level.getMap()[enemy.getX()][enemy.getY() - 1] == 1 && !lastPosition.equals(currentPosition.up())) {
                level.getMap()[enemy.getX()][enemy.getY()] = 10;
                System.out.println(currentPosition.up());
                enemy.setY(enemy.getY() - 1);

            }


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("konec");
        }

    }


}