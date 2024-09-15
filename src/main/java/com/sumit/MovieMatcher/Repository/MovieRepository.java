package com.sumit.MovieMatcher.Repository;

import com.sumit.MovieMatcher.Entity.Genre;
import com.sumit.MovieMatcher.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  MovieRepository  extends JpaRepository<Movie,Long> {



    Movie findByTitle(String title);

    List<Movie> findByGenre(Genre genre);

}
