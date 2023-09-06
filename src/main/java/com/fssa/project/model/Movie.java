package com.fssa.project.model;
import java.time.LocalDateTime;

public class Movie {
    private int movieId;
    private String name;
    private String genre;
    private LocalDateTime startTime;

    public Movie(int movieId, String name, String genre, LocalDateTime startTime) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
        this.startTime = startTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
