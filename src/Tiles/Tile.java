package Tiles;

import java.awt.image.BufferedImage;

/**
 * Tile used for creating a map.
 */
public class Tile {
    private final BufferedImage image;
    private final TileType tileType;

    public Tile(BufferedImage image, TileType tileType) {
        this.image = image;
        this.tileType = tileType;
    }

    public BufferedImage getImage() {
        return image;
    }

}
