package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
class ManagerTest {
    @Mock
    private Repository repository;
    @InjectMocks
    private Manager manager;
    MovieData first = new MovieData(1, "title1", "genre1");
    MovieData second = new MovieData(2, "title2", "genre2");
    MovieData third = new MovieData(3, "title3", "genre3");
    MovieData fourth = new MovieData(4, "title4", "genre4");
    MovieData fifth = new MovieData(5, "title5", "genre5");
    MovieData sixth = new MovieData(6, "title6", "genre7");
    MovieData seventh = new MovieData(7, "title7", "genre7");
    MovieData eighth = new MovieData(8, "title8", "genre8");
    MovieData ninth = new MovieData(9, "title9", "genre9");
    MovieData tenth = new MovieData(10, "title10", "genre10");

    @Test
    void ShouldMovieAdd() {
        MovieData[] returned = new MovieData[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(tenth);
        manager.addMovie(tenth);
        MovieData[] actual = manager.showAddedMovies(10);
        MovieData[] expected = new MovieData[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }



    @Test
    void ShouldMoviesShownWhenFeedLengthEqualsDefault() {
        MovieData[] returned = new MovieData[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        MovieData[] actual = manager.showAddedMovies(10);
        MovieData[] expected = new MovieData[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldMoviesShownWhenFeedLengthShorterThenDefault() {
        MovieData[] returned = new MovieData[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        MovieData[] actual = manager.showAddedMovies(5);
        MovieData[] expected = new MovieData[]{ninth, eighth, seventh, sixth, fifth,};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldMoviesShownWithNegativeRequest() {
        MovieData[] returned = new MovieData[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        MovieData[] actual = manager.showAddedMovies(-1);
        MovieData[] expected = new MovieData[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);

    }

}
