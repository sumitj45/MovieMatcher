package com.sumit.MovieMatcher.Controller;


import com.sumit.MovieMatcher.Entity.Movie;
import com.sumit.MovieMatcher.Services.MovieService;
import com.sumit.MovieMatcher.Services.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    private MovieService movieService;

    @GetMapping("/title")
    public MovieResponse findMovie(String title){
        return movieService.findMovie(title);
    }
    @GetMapping("/genre")
    public List<MovieResponse> findByGenre(@RequestParam String genre){
        return movieService.findByGenre(genre);
    }
//    @PostMapping("/review")


}
