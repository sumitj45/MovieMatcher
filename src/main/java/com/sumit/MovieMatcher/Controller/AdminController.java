package com.sumit.MovieMatcher.Controller;


import com.sumit.MovieMatcher.Services.AdminService;
import com.sumit.MovieMatcher.Services.request.MovieRequest;
import com.sumit.MovieMatcher.Services.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);
    }

}
