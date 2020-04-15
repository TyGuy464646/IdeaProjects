package com.tyler.tileMap;

import com.tyler.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileMap {

    // Variables
    private double x, y;

    private int xmin, ymin, xmax, ymax;

    private double smoothCamera;

    private int[][] map;
    private int tileSize;
    private int numRows, numCols;
    private int width, height;

    private BufferedImage tileset;
    private int numTilesAcross;
    private Tile[][] tiles;

    private int rowOffset, colOffset;
    private int numRowsToDraw, numColsToDraw;


    // Constructor
    public TileMap(int tileSize) {
        this.tileSize = tileSize;

        numRowsToDraw = GamePanel.HEIGHT / tileSize + 2;
        numColsToDraw = GamePanel.WIDTH / tileSize + 2;

        smoothCamera = 0.07;
    }


    // Methods
    public void loadTiles(String s) {
        try {

            tileset = ImageIO.read(
                    getClass().getResourceAsStream(s)
            );
            numTilesAcross = tileset.getWidth() / tileSize;
            tiles = new Tile[2][numTilesAcross];

            BufferedImage subImage;
            for (int y = 0; y < numTilesAcross; y++) {
                subImage = tileset.getSubimage(y * tileSize, 0, tileSize, tileSize);
                tiles[0][y] = new Tile(subImage, Tile.NORMAL);

                subImage = tileset.getSubimage(y * tileSize, tileSize, tileSize, tileSize);
                tiles[1][y] = new Tile(subImage, Tile.BLOCKED);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String s) {
        try {

            InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            numCols = Integer.parseInt(br.readLine());;
            numRows = Integer.parseInt(br.readLine());
            map = new int[numRows][numCols];
            width = numCols * tileSize;
            height = numRows * tileSize;

            String delims = "\\s+";
            for(int row = 0; row < numRows; row++) {
                String line = br.readLine();
                String[] tokens = line.split(delims);

                for (int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getX() {
        return (int)x;
    }
    public int getY() {
        return (int)y;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public int getType(int row, int col) {
        int rc = map[row][col];
        int r = rc / numTilesAcross;
        int c = rc % numTilesAcross;
        return tiles[r][c].getType();
    }

    public void setPosition(double x, double y) {
        this.x += (x - this.x) * smoothCamera;
        this.y += (y - this.y) * smoothCamera;

        fixBounds();

        colOffset = (int)-this.x / tileSize;
        rowOffset = (int)-this.y / tileSize;
    }

    private void fixBounds() {
        if (x < xmin) x = xmin;
        if (y < ymin) y = ymin;
        if (x > xmax) x = xmax;
        if (y > ymax) y = ymax;
    }

}
