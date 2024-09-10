package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamesList {
    public List<Game> loadGames(String filePath) {
        List<Game> games = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 4) {
                    System.out.println("Invalid row: " + line);
                    continue;
                }

                String name = data[0];
                String yearStr = data[1].trim();
                String genre = data[2];
                String publisher = data[3];

                try {
                    int year = Integer.parseInt(yearStr);
                    games.add(new Game(name, year, genre, publisher));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year format in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }
}
