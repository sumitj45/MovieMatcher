package com.sumit.MovieMatcher.Services;

import com.sumit.MovieMatcher.Entity.Movie;
import com.sumit.MovieMatcher.Repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    //constructor injection
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
