package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "games.csv";
        GamesList loader = new GamesList();
        List<Game> games = loader.loadGames(inputFilePath);

        GameGenres genreExporter = new GameGenres();
        genreExporter.exportGenres(games, "game_gendres.txt");

        SimulatorGamesExporter simulatorGamesExporter = new SimulatorGamesExporter();
        simulatorGamesExporter.exportSimulatorGames(games, "simulator_games.csv");

        PublisherExporter publisherExporter = new PublisherExporter();
        publisherExporter.exportPublishers(games, "game_publishers.csv");

        System.out.println("Soubory byly úspěšně vygenerovány.");
    }
}
