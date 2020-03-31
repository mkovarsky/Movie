package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    Manager manager = new Manager();

    @Test
    void ShouldMovieAdd() {
        MovieData movieToAdd = new MovieData(10, "title10", "genre10");
        manager.addMovie(movieToAdd);
        MovieData[] actual = manager.showAddedMovies(10);
        MovieData[] expected = {
                new MovieData(10, "title10", "genre10"),
                new MovieData(9, "title9", "genre9"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(5, "title5", "genre5"),
                new MovieData(4, "title4", "genre4"),
                new MovieData(3, "title3", "genre3"),
                new MovieData(2, "title2", "genre2"),
                new MovieData(1, "title1", "genre1"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldMoviesShownWithOutAdd() {
        MovieData[] actual = manager.showAddedMovies(10);
        MovieData[] expected = {
                new MovieData(9, "title9", "genre9"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(5, "title5", "genre5"),
                new MovieData(4, "title4", "genre4"),
                new MovieData(3, "title3", "genre3"),
                new MovieData(2, "title2", "genre2"),
                new MovieData(1, "title1", "genre1"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldMoviesShownWhenFeedLengthShorterTheDefault() {
        MovieData[] actual = manager.showAddedMovies(5);
        MovieData[] expected = {
                new MovieData(9, "title9", "genre9"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(5, "title5", "genre5"),

        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldMoviesShownWithNegativeRequest() {
        MovieData[] actual = manager.showAddedMovies(-1);
        MovieData[] expected = {
                new MovieData(9, "title9", "genre9"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(5, "title5", "genre5"),
                new MovieData(4, "title4", "genre4"),
                new MovieData(3, "title3", "genre3"),
                new MovieData(2, "title2", "genre2"),
                new MovieData(1, "title1", "genre1"),
        };
        assertArrayEquals(expected, actual);

    }
}
