package com.microservices.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.models.Rating;
import com.microservices.models.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataResource {
	@RequestMapping("/{movieId}")
	public Rating getRatiingData(@PathVariable("movieId") String movieId) {
		return new Rating("foo",4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRatiing(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("100", 4),new Rating("200",5));
		UserRating userRating = new UserRating(userId,ratings);
		return userRating;
	}
}
