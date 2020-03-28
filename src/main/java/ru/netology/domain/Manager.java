package ru.netology.domain;

public class Manager {
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

    public void addMovie(MovieData movie) {
        int length = movies.length + 1;
        MovieData[] tmp = new MovieData[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieData[] showAddedMovies(int numberOfMoviesToShow) {

        int feedLength = 10; //количество выдаваемых фильмов по умоланию

        if (numberOfMoviesToShow <= 0) {
            numberOfMoviesToShow = feedLength;
        }
        if (feedLength > movies.length) {
            feedLength = movies.length;
        }
        if (numberOfMoviesToShow <= feedLength) {
            feedLength = numberOfMoviesToShow;
        } else {
            feedLength = movies.length;
        }
        MovieData[] addedMovieData = new MovieData[feedLength];
        for (int i = 0; i < addedMovieData.length; i++) {
            int numberOfMovies = movies.length - i - 1;
            addedMovieData[i] = movies[numberOfMovies];
        }
        return addedMovieData;
    }

}




