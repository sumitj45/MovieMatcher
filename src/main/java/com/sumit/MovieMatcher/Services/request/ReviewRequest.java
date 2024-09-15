package com.sumit.MovieMatcher.Services.request;
import com.sumit.MovieMatcher.Entity.Movie;
import com.sumit.MovieMatcher.Entity.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReviewRequest {

    private String movieReview;
    private double rating;
    private Long movieId;

    public Review toReview(){
        return Review.builder()
                .movieReview(movieReview)
                .rating(rating)
                .movie(Movie.builder().id(movieId).build())
                .build();
    }
}
