package Enemy;

import Game.Game;
import Level.Level;
import Position.Position;

public class Movement {

    public void move(Enemy enemy, Level level, Game game) {
        int tileSize = 75;
        int pixelX = enemy.getPixelX();
        int pixelY = enemy.getPixelY();

        int tileX = pixelX / tileSize;
        int tileY = pixelY / tileSize;

        Position currentPosition = new Position(tileX, tileY);

        int finishPixX = enemy.getEndX() * tileSize;
        int finishPixY = enemy.getEndY() * tileSize;

        if (pixelX % tileSize == 0 && pixelY % tileSize == 0) {
            enemy.setX(tileX);
            enemy.setY(tileY);

        }
        if (pixelX == finishPixX && pixelY == finishPixY) {
            System.out.println("end");
            enemy.doDamage(game);
            System.out.println(game.getHealth());
            enemy.setHasEnded(true);
            return;
        }

        if (enemy.getDirection() == null) {
            if (level.isInBounds(tileX + 1, tileY) && level.getMap()[tileX + 1][tileY] == 1 && !enemy.getVisitedLocations().contains(currentPosition.right())) {
                enemy.setDirection(Direction.RIGHT);
                enemy.getVisitedLocations().add(currentPosition.right());
                enemy.setTargetX(enemy.getTargetX() + tileSize);
                enemy.setProgres(enemy.getProgres() + 1);
            } else if (level.isInBounds(tileX - 1, tileY) && level.getMap()[tileX - 1][tileY] == 1 && !enemy.getVisitedLocations().contains(currentPosition.left())) {
                enemy.setDirection(Direction.LEFT);
                enemy.getVisitedLocations().add(currentPosition.left());
                enemy.setTargetX(enemy.getTargetX() - tileSize);
                enemy.setProgres(enemy.getProgres() + 1);
            } else if (level.isInBounds(tileX, tileY + 1) && level.getMap()[tileX][tileY + 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.down())) {
                enemy.setDirection(Direction.DOWN);
                enemy.getVisitedLocations().add(currentPosition.down());
                enemy.setTargetY(enemy.getTargetY() + tileSize);
                enemy.setProgres(enemy.getProgres() + 1);
            } else if (level.isInBounds(tileX, tileY - 1) && level.getMap()[tileX][tileY - 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.up())) {
                enemy.setDirection(Direction.UP);
                enemy.getVisitedLocations().add(currentPosition.up());
                enemy.setTargetY(enemy.getTargetY() - tileSize);
                enemy.setProgres(enemy.getProgres() + 1);

            }

        }

        if (enemy.getDirection() != null) {
            switch (enemy.getDirection()) {
                case LEFT -> {
                    enemy.setPixelX(pixelX - enemy.getSpeed());
                    if (pixelX <= enemy.getTargetX()) {
                        enemy.setPixelX(enemy.getTargetX());
                        enemy.setDirection(null);
                    }
                }
                case RIGHT -> {
                    enemy.setPixelX(pixelX + enemy.getSpeed());
                    if (pixelX >= enemy.getTargetX()) {
                        enemy.setPixelX(enemy.getTargetX());
                        enemy.setDirection(null);
                    }
                }
                case UP -> {
                    enemy.setPixelY(pixelY - enemy.getSpeed());
                    if (pixelY <= enemy.getTargetY()) {
                        enemy.setPixelY(enemy.getTargetY());
                        enemy.setDirection(null);
                    }
                }
                case DOWN -> {
                    enemy.setPixelY(pixelY + enemy.getSpeed());
                    if (pixelY >= enemy.getTargetY()) {
                        enemy.setPixelY(enemy.getTargetY());
                        enemy.setDirection(null);
                    }
                }
            }

            if (enemy.getDirection() == null) {
                int newTileX = enemy.getPixelX() / tileSize;
                int newTileY = enemy.getPixelY() / tileSize;

                if (newTileX != tileX || newTileY != tileY) {
                    enemy.setX(newTileX);
                    enemy.setY(newTileY);

                }
            }
        }



    }

}