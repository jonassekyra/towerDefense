import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Level {
    private HashMap<String, Tile> tileTypes = new HashMap<>();
    private Tile[][] tiles = new Tile[9][9];

    public Level() {
        createTiles();
        loadLevel();
    }

    public void createTiles() {
        try {
            tileTypes.put("path", new Tile(ImageIO.read(Tile.class.getResource("/Tiles/hneda.png")), TileType.PATH));
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
                String[] split = line.split(" ");
                for (int i = 0; i < split.length; i++) {
                    switch (split[i]) {
                        case "0":
                            tiles[i][row] = tileTypes.get("path");
                            break;
                        case "1":
                            tiles[i][row] = tileTypes.get("grass");
                            break;

                    }
                }
                row ++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void drawLevel(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                g2D.drawImage(tiles[i][j].getImage(), i * 75,j * 75,75,75,null);
            }
        }

    }

}
