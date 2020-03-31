package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Repository repository = new Repository();

    @Test
    void ShouldFindAll() {
        MovieData[] actual = repository.findAll();
        MovieData[] expected = {new MovieData(1, "title1", "genre1"),
                new MovieData(2, "title2", "genre2"),
                new MovieData(3, "title3", "genre3"),
                new MovieData(4, "title4", "genre4"),
                new MovieData(5, "title5", "genre5"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(9, "title9", "genre9"),
        };
    }

    @Test
    void ShouldMovieSave() {
        MovieData movieToSave = new MovieData(10, "title10", "genre10");
        repository.save(movieToSave);
        MovieData[] actual = repository.findAll();
        MovieData[] expected = {
                new MovieData(1, "title1", "genre1"),
                new MovieData(2, "title2", "genre2"),
                new MovieData(3, "title3", "genre3"),
                new MovieData(4, "title4", "genre4"),
                new MovieData(5, "title5", "genre5"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(9, "title9", "genre9"),
                new MovieData(10, "title10", "genre10"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldFindById() {
        MovieData actual = repository.findById(6);
        MovieData expected = new MovieData(6, "title6", "genre6");
        assertEquals(expected, actual);
    }

    @Test
    void ShouldFindByIdReturnsNullIfIdDoesNotExist() {
        MovieData actual = repository.findById(25);
        assertEquals(null, actual);
    }

    @Test
    void ShouldRemoveById() {
        repository.removeById(5);
        MovieData[] actual = repository.findAll();
        MovieData[] expected = {
                new MovieData(1, "title1", "genre1"),
                new MovieData(2, "title2", "genre2"),
                new MovieData(3, "title3", "genre3"),
                new MovieData(4, "title4", "genre4"),
                new MovieData(6, "title6", "genre6"),
                new MovieData(7, "title7", "genre7"),
                new MovieData(8, "title8", "genre8"),
                new MovieData(9, "title9", "genre9"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldRemoveAll() {
        repository.removeAll();
        MovieData[] actual = repository.findAll();
        MovieData[] expected = {};
        assertArrayEquals(expected, actual);

    }

}