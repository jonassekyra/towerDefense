import java.util.HashSet;
import java.util.Objects;

public class Enemy {
    private int x;
    private int y;
    private int endX;
    private int endY;
    private boolean hasStarted = false;
    private boolean hasEnded = false;
    private HashSet<Position> visitedLocations = new HashSet<>();
    private int damage;
    private int health;


    public HashSet<Position> getVisitedLocations() {
        return visitedLocations;
    }

    public void setVisitedLocations(HashSet<Position> visitedLocations) {
        this.visitedLocations = visitedLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enemy enemy = (Enemy) o;
        return Objects.equals(visitedLocations, enemy.visitedLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(visitedLocations);
    }

    public Enemy() {
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public boolean isHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
