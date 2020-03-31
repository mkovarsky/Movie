package ru.netology.domain;

public class Manager {
    private Repository repository = new Repository();

    public void addMovie(MovieData movie) {
        repository.save(movie);
    }

    public MovieData[] showAddedMovies(int numberOfMoviesToShow) {
        MovieData[] movies = repository.findAll();

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





