package com.sumit.MovieMatcher.Services.response;



import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class ReviewResponse {
    private String review;
    private Double rating;


}
