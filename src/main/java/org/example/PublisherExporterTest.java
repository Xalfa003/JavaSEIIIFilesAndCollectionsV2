package org.example;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PublisherExporterTest {

    @Test
    public void testExportPublishers() throws Exception {
        List<Game> games = new ArrayList<>();
        games.add(new Game("Game 1", 2020, "Action", "Publisher A"));
        games.add(new Game("Game 2", 2021, "Simulator", "Publisher A"));
        games.add(new Game("Game 3", 2022, "Action", "Publisher B"));

        PublisherExporter publisherExporter = new PublisherExporter();
        publisherExporter.exportPublishers(games, "src/test/resources/game_publishers.csv");

        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/game_publishers.csv"));
        assertEquals(3, lines.size());

        assertEquals("Publisher,Count", lines.get(0));
        assertEquals("Publisher A,2", lines.get(1));
        assertEquals("Publisher B,1", lines.get(2));
    }
}

