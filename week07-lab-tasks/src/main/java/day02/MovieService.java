package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) {
        movies = getMoviesFromFile(path);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<String> readFile(Path path){
        List<String> moviesCsv = null;
        try {
            moviesCsv = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
        return moviesCsv;
    }

    public List<Movie> getMoviesFromFile(Path path) {
        for (String line: readFile(path)) {
            String title = line.split(";")[0];
            int year = Integer.parseInt(line.split(";")[1]);
            String director = line.split(";")[2];
            movies.add(new Movie(title, year, director));
        }
        return movies;
    }
}
