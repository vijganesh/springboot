package com.microservices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.models.CatalogItem;
import com.microservices.models.Rating;
import com.microservices.services.MovieInfo;
import com.microservices.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder builder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		List<Rating> ratings = userRatingInfo.getUserRating(userId).getRatings();
		return ratings.stream().map(rating->{
			return movieInfo.getCatalogItem(rating.getMovieId(),rating.getRating());
		})
		.collect(Collectors.toList());
	}
}

/*Movie movie = builder.build()
		.get()
		.uri("http://localhost:8091/movies/"+rating.getMovieId())
		.retrieve()
		.bodyToMono(Movie.class)
		.block();*/