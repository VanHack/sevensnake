package br.com.camiloporto.sevensnake;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by camiloporto on 11/22/17.
 */
public class GridReader {

    private final String filePath;

    public GridReader(String filePath) {
        this.filePath = filePath;
    }

    public int[][] readGrid() throws IOException {
        Path file = Paths.get(filePath);
        InputStream in = null;
        int[][] grid = null;
        try {
            in = Files.newInputStream(file);
            Scanner csvScanner = new Scanner(in);
            int lineCount = 0;
            while(csvScanner.hasNextLine()) {
                String[] gridLineAsString = csvScanner.nextLine().split(",");
                if(grid == null) {
                    grid = new int[gridLineAsString.length][gridLineAsString.length];
                }
                grid[lineCount++] = gridLineAsInteger(gridLineAsString);
            }
        }
        finally {
            if(in != null) {
              try {
                  in.close();
              } catch (IOException e) {
                  System.err.println("could not close inputstream");
                  e.printStackTrace();
              }
            }
        }
        return grid;
    }

    private int[] gridLineAsInteger(String[] gridLineAsString) {
        int[] asInt = new int[gridLineAsString.length];
        for(int i = 0; i < gridLineAsString.length; i++) {
            asInt[i] = Integer.valueOf(gridLineAsString[i].trim());
        }
        return asInt;
    }
}
