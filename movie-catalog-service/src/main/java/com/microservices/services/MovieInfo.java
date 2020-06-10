package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.models.CatalogItem;
import com.microservices.models.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(String movieId,int rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+movieId, Movie.class);
		return new CatalogItem(movie.getName(), movie.getDesc(), rating);
	}
	
	public CatalogItem getFallbackCatalogItem(String movieId,int rating) {
		return new CatalogItem("Movie name not found", "", rating);
	}}
