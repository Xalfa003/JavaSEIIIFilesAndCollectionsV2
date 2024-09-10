package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PublisherExporter {
    public void exportPublishers(List<Game> games, String filePath) {
        Map<String, Long> publisherCount = games.stream()
                .collect(Collectors.groupingBy(Game::getPublisher, TreeMap::new, Collectors.counting()));

        List<Map.Entry<String, Long>> sortedPublishers = publisherCount.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Publisher,Count\n");
            for (Map.Entry<String, Long> entry : sortedPublishers) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

