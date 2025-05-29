package Enemy;

import Game.Game;
import Level.Level;
import Position.Position;

/**
 * Moves enemy further on the map.
 */
public class Movement {
    /**
     * Calculates pixel position and tile position.
     * Checks if the enemy go t to teh next tile.
     * Sets direction or moves the enemy.
     * @param enemy Enemy that is supposed to move.
     * @param level Current level.
     * @param game Game that stores players lives.
     */
    public void move(Enemy enemy, Level level, Game game) {
        int tileSize = 75;
        int pixelX = enemy.getPixelX();
        int pixelY = enemy.getPixelY();

        int tileX = pixelX / tileSize;
        int tileY = pixelY / tileSize;

        Position currentPosition = new Position(tileX,tileY);


        if (pixelX % tileSize == 0 && pixelY % tileSize == 0) {
            enemy.setX(tileX);
            enemy.setY(tileY);

        }

        if (hasReachedEnd(enemy,tileSize,game)){
            return;
        }


        setDirection(enemy,level,tileX,tileY,currentPosition,tileSize);
        moveToDirection(enemy);


    }


    /**
     * Moves the enemy in desired direction.
     * Speed == number of pixels traveled per move.
     * @param enemy Enemy that currently moves.
     */
    private void moveToDirection(Enemy enemy) {
        if (enemy.getDirection() != null) {

            int pixelX = enemy.getPixelX();
            int pixelY = enemy.getPixelY();

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
        }
    }

    /**
     * When direction is null it checks where can the enemy go and sets the direction.
     * @param enemy Enemy that is currently moving.
     * @param level Current level.
     * @param tileX X position on a map.
     * @param tileY Y position ona map.
     * @param currentPosition Current position of the enemy(not in pixels).
     * @param tileSize Size of one tile(square).
     */
    private void setDirection(Enemy enemy,Level level,int tileX,int tileY,Position currentPosition,int tileSize) {
        if (enemy.getDirection() == null) {
            if (level.isInBounds(tileX + 1, tileY) && level.getMap()[tileX + 1][tileY] == 1 && !enemy.getVisitedLocations().contains(currentPosition.right())) {
                enemy.setDirection(Direction.RIGHT);
                enemy.getVisitedLocations().add(currentPosition.right());
                enemy.setTargetX(enemy.getTargetX() + tileSize);
                enemy.setProgress(enemy.getProgress() + 1);
            } else if (level.isInBounds(tileX - 1, tileY) && level.getMap()[tileX - 1][tileY] == 1 && !enemy.getVisitedLocations().contains(currentPosition.left())) {
                enemy.setDirection(Direction.LEFT);
                enemy.getVisitedLocations().add(currentPosition.left());
                enemy.setTargetX(enemy.getTargetX() - tileSize);
                enemy.setProgress(enemy.getProgress() + 1);
            } else if (level.isInBounds(tileX, tileY + 1) && level.getMap()[tileX][tileY + 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.down())) {
                enemy.setDirection(Direction.DOWN);
                enemy.getVisitedLocations().add(currentPosition.down());
                enemy.setTargetY(enemy.getTargetY() + tileSize);
                enemy.setProgress(enemy.getProgress() + 1);
            } else if (level.isInBounds(tileX, tileY - 1) && level.getMap()[tileX][tileY - 1] == 1 && !enemy.getVisitedLocations().contains(currentPosition.up())) {
                enemy.setDirection(Direction.UP);
                enemy.getVisitedLocations().add(currentPosition.up());
                enemy.setTargetY(enemy.getTargetY() - tileSize);
                enemy.setProgress(enemy.getProgress() + 1);

            }

        }
    }

    /**
     * Calculates the position of the finish in pixels.
     * checks if the enemy is there and if so it does damage to the player.
     * @param enemy Current Enemy that is being checked.
     * @param tileSize Size of a tile.
     * @param game Game that stores players lives.
     * @return true if the enemy is at the end.
     */
    private boolean hasReachedEnd(Enemy enemy, int tileSize,Game game) {
        int finishPixX = enemy.getEndX() * tileSize;
        int finishPixY = enemy.getEndY() * tileSize;
        if (enemy.getPixelX() == finishPixX && enemy.getPixelY() == finishPixY) {
            enemy.doDamage(game);
            enemy.setHasEnded(true);
            return true;
        }
        return false;
    }

}