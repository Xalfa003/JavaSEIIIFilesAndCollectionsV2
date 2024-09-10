package org.example;

public class Game {
    private String name;
    private int year;
    private String genre;
    private String publisher;

    public Game(String name, int year, String genre, String publisher) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
