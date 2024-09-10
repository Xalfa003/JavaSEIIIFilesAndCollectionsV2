package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GameGenres {
    public void exportGenres(List<Game> games, String filePath) {
        Set<String> genres = new TreeSet<>();

        for (Game game : games) {
            genres.add(game.getGenre());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.join(",", genres));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

