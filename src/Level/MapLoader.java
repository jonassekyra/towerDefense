package Level;

import Position.Position;
import Tiles.Tile;
import Tiles.TileType;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
    int[][] map = new int[10][10];
    private Tile[][] tiles = new Tile[10][10];

    public void createTiles() {

        try {
            tileTypes.put("path", new Tile(ImageIO.read(Tile.class.getResource("/Tiles/brown.png")), TileType.PATH));
            tileTypes.put("grass", new Tile(ImageIO.read(Tile.class.getResource("/Tiles/zelena.png")), TileType.GRASS));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLevel() {
        try (BufferedReader br = new BufferedReader(new FileReader("Map.txt"))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '9') {
                    String[] split = line.split("=");
                    if (split[0].equals("9startPosition")) {
                        startPosition = new Position(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    } else {
                        endPosition = new Position(Integer.parseInt(split[1]), Integer.parseInt(split[2]));

                    }
                } else {
                    String[] split = line.split(" ");
                    for (int i = 0; i < split.length; i++) {
                        switch (split[i]) {
                            case "0":
                                tiles[i][row] = tileTypes.get("path");
                                map[i][row] = 0;
                                break;
                            case "1":
                                tiles[i][row] = tileTypes.get("grass");
                                map[i][row] = 1;
                                break;
                        }
                    }
                    row++;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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

    public void setMap(int[][] map) {
        this.map = map;
    }
}
