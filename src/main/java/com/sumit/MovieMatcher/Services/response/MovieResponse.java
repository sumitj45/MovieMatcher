package com.sumit.MovieMatcher.Services.response;

import com.sumit.MovieMatcher.Entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse>reviews;


}
