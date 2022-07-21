package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 40;
    private static class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int computeOffset(int length, int rowNum) {
        if (rowNum < length) {
            return -rowNum;
        } else {
            return - (length * 2 - 1) + rowNum;
        }
    }

    public static int computeEffectiveLength(int length, int rowNum) {
        if (rowNum < 0 || rowNum >= length * 2) {
            throw new IllegalArgumentException("row number out of bound");
        }
        if (rowNum < length) {
            return length + rowNum * 2;
        } else {
            return length + (length - 1) * 2 - (rowNum - length) * 2;
        }

    }
    public static void addHexagonRow(TETile[][] world, int length, int rowNum, Position p, TETile tileType) {
        int width = computeEffectiveLength(length, rowNum);
        int offsetX = computeOffset(length, rowNum);
        for (int i = 0; i < width; i++) {
            world[p.x + i + offsetX][p.y] = tileType;
        }
    }
    public static void addHexagon(TETile[][] world, int length, Position p, TETile tileType) {
        Position pPtr = new Position(p.x, p.y);
        for (int i = 0; i < length * 2; i++) {
            addHexagonRow(world, length, i, pPtr, tileType);
            pPtr.y += 1;
        }

    }
    public static void addColumnHexagons(TETile[][] world, int length, Position startPosition,
                                         TETile[] tileTypes, int numHexagons) {
        Position localStartPosition = new Position(startPosition.x, startPosition.y);
        Random r = new Random();

        for (int i = 0; i < numHexagons; i++) {
            addHexagon(world, length, localStartPosition, tileTypes[r.nextInt(5)]);
            localStartPosition.y += length * 2;
        }

    }

    public static void generateHexWorld(TETile[][] world) {
        int[] tileNums = {3, 4, 5, 4, 3};
        Position startPosition = new Position(10, 10);
        TETile [] tileTypes = new TETile[5];
        tileTypes[0] = Tileset.FLOWER;
        tileTypes[1] = Tileset.MOUNTAIN;
        tileTypes[2] = Tileset.TREE;
        tileTypes[3] = Tileset.WALL;
        tileTypes[4] = Tileset.FLOOR;

        addColumnHexagons(world, 3, startPosition, tileTypes, 3);
        startPosition = new Position(15, 7);
        addColumnHexagons(world, 3, startPosition, tileTypes, 4);
        startPosition = new Position(20, 4);
        addColumnHexagons(world, 3, startPosition, tileTypes, 5);
        startPosition = new Position(25, 7);
        addColumnHexagons(world, 3, startPosition, tileTypes, 4);
        startPosition = new Position(30, 10);
        addColumnHexagons(world, 3, startPosition, tileTypes, 3);

    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }
        generateHexWorld(world);
        ter.renderFrame(world);
    }

    @Test
    public void testComputeEffectiveLength() {
        assertEquals(3, computeEffectiveLength(3, 0));
        assertEquals(5, computeEffectiveLength(3, 1));
        assertEquals(7, computeEffectiveLength(3, 2));
        assertEquals(7, computeEffectiveLength(3, 3));
        assertEquals(5, computeEffectiveLength(3, 4));
        assertEquals(3, computeEffectiveLength(3, 5));
    }

    @Test
    public void testComputeOffset() {
        assertEquals(0,computeOffset(3, 0));
        assertEquals(-1, computeOffset(3, 1));
        assertEquals(-2, computeOffset(3, 2));
        assertEquals(-2, computeOffset(3, 3));
        assertEquals(-1, computeOffset(3, 4));
        assertEquals(0, computeOffset(3, 5));
        assertEquals(0, computeOffset(2, 0));
        assertEquals(-1, computeOffset(2, 1));
    }


}

