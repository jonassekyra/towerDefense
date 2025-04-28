package Enemy;

import Game.Game;
import Level.Level;
import Position.Position;

public class Movement {

    public void move(Enemy enemy, Level level, Game game) {


        int tileSize = 75;

        //only for better visuals of the code
        int pixelX = enemy.getPixelX();
        int pixelY = enemy.getPixelY();

        int tileX = pixelX / tileSize;
        int tileY = pixelY / tileSize;

        Position currentPosition = new Position(tileX, tileY);
        Position finishPosition = new Position(enemy.getEndX(), enemy.getEndY());
        int finishPixX = enemy.getEndX() * tileSize;
        int finishPixY = enemy.getEndY() * tileSize;

        if (pixelX % tileSize == 0&&pixelY % tileSize == 0) {
            enemy.setX(tileX);
            enemy.setY(tileY);

        }

        if (pixelX == finishPixX && pixelY == finishPixY) {
            System.out.println("konec");
            enemy.doDamage(game);
            System.out.println(game.getHealth());
            enemy.setHasEnded(true);
            return;
        }
        /*
        if (currentPosition.equals(finishPosition)) {

        }
        \
         */
        if (enemy.getPixelX() % 75 == 0 && enemy.getPixelY() % 75 == 0) {
            if (level.getMap()[tileX + 1][tileY] == 1 && !enemy.getVisitedLocations().contains(currentPosition.right())) {
                enemy.setDirection(Direction.RIGHT);

                enemy.getVisitedLocations().add(currentPosition.right());
                //enemy.setTargetPosition(tileX + 1, tileY);
                //enemy.setX(enemy.getX() + 1);

            } else if (level.getMap()[tileX - 1][tileY] == 1 && !enemy.getVisitedLocations().contains(currentPosition.left())) {
                enemy.setDirection(Direction.LEFT);
                enemy.getVisitedLocations().add(currentPosition.left());
                //enemy.setX(enemy.getX() - 1);


            } else if (level.getMap()[tileX][tileY + 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.down())) {
                enemy.setDirection(Direction.DOWN);
                enemy.getVisitedLocations().add(currentPosition.down());
                //enemy.setY(enemy.getY() + 1);

            } else if (level.getMap()[tileX][tileY - 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.up())) {
                enemy.setDirection(Direction.UP);
                enemy.getVisitedLocations().add(currentPosition.up());
                //enemy.setY(enemy.getY() - 1);
            }
        }


        if (enemy.getDirection() != null) {
            switch (enemy.getDirection()) {
                case LEFT -> enemy.setPixelX(pixelX - enemy.getSpeed());
                case RIGHT -> enemy.setPixelX(pixelX + enemy.getSpeed());
                case UP -> enemy.setPixelY(pixelY - enemy.getSpeed());
                case DOWN -> enemy.setPixelY(pixelY + enemy.getSpeed());
            }
            if (enemy.getPixelX() % 75 == 0 && enemy.getPixelY() % 75 == 0) {

                int newTileX = enemy.getPixelX() / tileSize;
                int newTileY = enemy.getPixelY() / tileSize;

                if (newTileX != tileX || newTileY != tileY) {
                    enemy.setX(newTileX);
                    enemy.setY(newTileY);
                    enemy.setDirection(null);
                }

            }


        }
        System.out.println(enemy.getX());
        System.out.println(enemy.getY());
        try{
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}