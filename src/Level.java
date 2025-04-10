import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Tile> tileTypes = new HashMap<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Tile[][] tiles = new Tile[9][9];
    private int[][] map = new int[9][9];
    Movement movement = new Movement();

    public Level() {
        createTiles();
        loadLevel();
    }

    public HashMap<String, Tile> getTileTypes() {
        return tileTypes;
    }

    public void setTileTypes(HashMap<String, Tile> tileTypes) {
        this.tileTypes = tileTypes;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public void createTiles() {
        try {
            tileTypes.put("path", new Tile(ImageIO.read(Tile.class.getResource("/Tiles/hneda.png")), TileType.PATH));
            tileTypes.put("grass", new Tile(ImageIO.read(Tile.class.getResource("/Tiles/zelena.png")), TileType.GRASS));
            enemies.add(new Enemy(0,0));
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
                            map[i][row] = 0;
                            break;
                        case "1":
                            tiles[i][row] = tileTypes.get("grass");
                            map[i][row] = 1;
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
    public void drawEnemy(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        //mysli si to ze x je 75
        g2D.fillOval(enemies.get(0).getX(), enemies.get(0).getY(), 75,75);
        movement.move(enemies.get(0),this);

    }


}
