package day02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MovieServiceTest {
    Path path = Paths.get("src/main/resources/day02/movies.csv");
    Path wrongPath = Paths.get("wrongPath/movies.csv");
    MovieService movieService = new MovieService(path);
    List<String> moviesExpected = Arrays.asList("Jurassic park;1993;Steven Spielberg",
            "Titanic;1997;James Cameron", "Star Wars;1977;George Lucas",
            "Lord Of The Rings;2002;Peter Jackson", "Jaws;1975;Steven Spielberg");

    @Test
    void ReadFileTest() {
        List<String> moviesCreated = movieService.readFile(path);
        assertEquals(moviesExpected, moviesCreated);
    }

    @Test
    void ReadFileWrongPathTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> movieService.readFile(wrongPath));
        assertEquals("Can not read file!", ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }

    List<Movie> moviesCreated = movieService.getMovies();

    @Test
    void getMoviesTest() {
        assertEquals(moviesExpected.toString(), moviesCreated.toString());
    }
    @Test
    void getMoviesNthTest() {
        assertEquals("Star Wars;1977;George Lucas", moviesCreated.get(2).toString());
    }
    @Test
    void getMoviesNthDirectorTest() {
        assertEquals("George Lucas", moviesCreated.get(2).getDirector());
    }

    @Test
    void getMoviesNthYearTest() {
        assertEquals(2002, moviesCreated.get(3).getYear());
    }

    @Test
    void getMoviesNthTitleTest() {
        assertEquals("Titanic", moviesCreated.get(1).getTitle());
    }
}
