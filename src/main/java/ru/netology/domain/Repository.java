package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
    MovieData[] movies = {
            new MovieData(1, "title1", "genre1"),
            new MovieData(2, "title2", "genre2"),
            new MovieData(3, "title3", "genre3"),
            new MovieData(4, "title4", "genre4"),
            new MovieData(5, "title5", "genre5"),
            new MovieData(6, "title6", "genre6"),
            new MovieData(7, "title7", "genre7"),
            new MovieData(8, "title8", "genre8"),
            new MovieData(9, "title9", "genre9"),
    };

    MovieData[] findAll() {
        for (int i = 0; i < movies.length; i++) {
        }
        return movies;
    }

    void save(MovieData movie) {
        int length = movies.length + 1;
        MovieData[] tmp = new MovieData[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    MovieData findById(int id) {
        for (MovieData movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    void removeById(int id) {
        int length = movies.length - 1;
        MovieData[] tmp = new MovieData[length];
        int index = 0;
        for (MovieData movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    void removeAll() {
        movies = new MovieData[0];
    }

}
