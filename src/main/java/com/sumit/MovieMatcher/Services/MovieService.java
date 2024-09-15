package com.sumit.MovieMatcher.Services;

import com.sumit.MovieMatcher.Entity.Genre;
import com.sumit.MovieMatcher.Entity.Movie;
import com.sumit.MovieMatcher.Repository.MovieRepository;
import com.sumit.MovieMatcher.Services.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieResponse findMovie(String title) {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findByTitle(title));

        // Handle scenario where movie does not exist
        return movie.map(Movie::toMovieResponse)
                .orElseThrow(() -> new RuntimeException("Movie with title '" + title + "' not found."));
    }

    public List<MovieResponse> findByGenre(String genre) {
        if (!isValidGenre(genre)) {
            return Collections.emptyList();
        }

        List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));

        // Sort by rating in descending order
        List<MovieResponse> sortedMovies = movieList.stream()
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .map(Movie::toMovieResponse)
                .collect(Collectors.toList());

        // Limit to 5 movies if there are more than 5
        return sortedMovies.size() > 5 ? sortedMovies.subList(0, 5) : sortedMovies;
    }

    private boolean isValidGenre(String genre) {
        return Arrays.stream(Genre.values()).anyMatch(g -> g.name().equalsIgnoreCase(genre));
    }
}
