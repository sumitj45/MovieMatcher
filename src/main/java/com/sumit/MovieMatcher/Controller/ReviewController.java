package com.sumit.MovieMatcher.Controller;


import com.sumit.MovieMatcher.Entity.Review;
import com.sumit.MovieMatcher.Services.ReviewService;
import com.sumit.MovieMatcher.Services.request.ReviewRequest;
import com.sumit.MovieMatcher.Services.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
   private ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/find")
    public ReviewResponse getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
