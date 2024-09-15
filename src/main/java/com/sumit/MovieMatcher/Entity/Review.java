package com.sumit.MovieMatcher.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sumit.MovieMatcher.Services.response.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Entity
@Data
@Table(name="review_table")
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString

public class Review {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String movieReview;
    private double rating; // rating dedicated to each review

    @ManyToOne
    @JoinColumn(name="movie_id",nullable = false)
    @JsonIgnore
    private Movie movie; //  it will use to add foreign key in a table with a table_name id_name -->//movie

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    public static ReviewResponse toReviewResponse(Review review){
        return  ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList){
        if(Objects.isNull(reviewList))
            return new ArrayList<>();
        else
            return  reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }
}
