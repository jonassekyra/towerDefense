package Level;

import Position.Position;
import Tiles.Tile;
import Tiles.TileType;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * Loads map from a file.
 */
public class MapLoader {
    private Position startPosition;
    private Position endPosition;

    public Position getStartPosition() {
        return startPosition;
    }


    public Position getEndPosition() {
        return endPosition;
    }


    public MapLoader() {
        createTiles();
        loadLevel();
    }

    HashMap<String, Tile> tileTypes = new HashMap<>();
    /**
     * Map of 1 and 0 that the enemy uses to navigate.
     */
    int[][] map = new int[10][10];
    /**
     * Map of Tiles.
     */
    private final Tile[][] tiles = new Tile[10][10];

    /**
     * Creates path and grass tiles from pictures.
     * Adds them to HashMap.
     */
    public void createTiles() {

        try {
            tileTypes.put("path", new Tile(ImageIO.read(Objects.requireNonNull(Tile.class.getResource("/path.png"))), TileType.PATH));
            tileTypes.put("grass", new Tile(ImageIO.read(Objects.requireNonNull(Tile.class.getResource("/grass.png"))), TileType.GRASS));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads both maps and start, end positions from a file.
     */
    public void loadLevel() {
        try (BufferedReader br = new BufferedReader(new FileReader("Map.txt"))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    String[] split = line.split("=");
                    if (split[0].equals("#startPosition")) {
                        startPosition = new Position(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    } else {
                        endPosition = new Position(Integer.parseInt(split[1]), Integer.parseInt(split[2]));

                    }
                } else {
                    String[] split = line.split(" ");
                    for (int i = 0; i < split.length; i++) {
                        switch (split[i]) {
                            case "0":
                                tiles[i][row] = tileTypes.get("grass");
                                map[i][row] = 0;
                                break;
                            case "1":
                                tiles[i][row] = tileTypes.get("path");
                                map[i][row] = 1;
                                break;
                        }
                    }
                    row++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Tile[][] getTiles() {
        return tiles;
    }


    public int[][] getMap() {
        return map;
    }

}
