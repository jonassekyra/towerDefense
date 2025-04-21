public class Movement {

    public void move(Enemy enemy, Level level,Game game) {

        Position currentPosition = new Position(enemy.getX(), enemy.getY());
        Position finishPosition = new Position(enemy.getEndX(), enemy.getEndY());
        if (currentPosition.equals(finishPosition)) {
            System.out.println("konec");
            enemy.doDamage(game);
            System.out.println(game.getHealth());
            enemy.setHasEnded(true);
            return;
        }
        if (level.getMap()[enemy.getX() + 1][enemy.getY()] == 1 && !enemy.getVisitedLocations().contains(currentPosition.right())) {


            enemy.getVisitedLocations().add(currentPosition.right());
            enemy.setX(enemy.getX() + 1);

        } else if (level.getMap()[enemy.getX() - 1][enemy.getY()] == 1 && !enemy.getVisitedLocations().contains(currentPosition.left())) {

            enemy.getVisitedLocations().add(currentPosition.left());
            enemy.setX(enemy.getX() - 1);


        } else if (level.getMap()[enemy.getX()][enemy.getY() + 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.down())) {
            enemy.getVisitedLocations().add(currentPosition.down());
            enemy.setY(enemy.getY() + 1);

        } else if (level.getMap()[enemy.getX()][enemy.getY() - 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.up())) {
            enemy.getVisitedLocations().add(currentPosition.up());
            enemy.setY(enemy.getY() - 1);
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}