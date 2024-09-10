package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SimulatorGamesExporter {
    public void exportSimulatorGames(List<Game> games, String filePath) {
        List<Game> simulatorGames = games.stream()
                .filter(game -> game.getGenre().equalsIgnoreCase("Simulator"))
                .sorted((g1, g2) -> Integer.compare(g1.getYear(), g2.getYear()))
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name,Year\n");
            for (Game game : simulatorGames) {
                writer.write(game.getName() + "," + game.getYear() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

