package Position;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position down() {
        return new Position(this.x, this.y+ 1);
    }

    public Position up() {
        return new Position(this.x, this.y - 1);
    }

    public Position left() {
        return new Position(this.x - 1, this.y);
    }

    public Position right() {
        return new Position(this.x + 1, this.y);
    }


    public Position(Position coppiedPosition) {
        this.x = coppiedPosition.x;
        this.y = coppiedPosition.y;
    }

    @Override
    public String toString() {
        return "Position.Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
