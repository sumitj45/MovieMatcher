package com.sumit.MovieMatcher.Services;

import com.sumit.MovieMatcher.Entity.Movie;
import com.sumit.MovieMatcher.Repository.MovieRepository;

import com.sumit.MovieMatcher.Entity.Review;
import com.sumit.MovieMatcher.Repository.ReviewRepository;
import com.sumit.MovieMatcher.Services.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private  MovieRepository movieRepository;

    public void addReview(Review review) {
        //need to optimize this method
        //also need to add exception handling
        Movie movie=movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        if(movie!=null){
            Double average=reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
            System.out.println(" Thanks,Review is added successfully...");
        }

    }

    public ReviewResponse getReviewById(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);

        if (review.isPresent())
            return Review.toReviewResponse(review.get());
        else
            return  null;


    }
}
