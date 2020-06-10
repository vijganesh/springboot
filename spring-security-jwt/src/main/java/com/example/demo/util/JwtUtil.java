package com.example.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private String SECRET_KEY = "SECRET";
	
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
		final Claims claims = extactAllClaims(token);
		return claimResolver.apply(claims);
	}

	private Claims extactAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		Date tokenDate = extractExpiration(token);
		return tokenDate.before(new Date());
	}
	
	public String generateToken(UserDetails myUserDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,myUserDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public Boolean validateToken(String token, UserDetails myUserDetails) {
		final String userName = extractUserName(token);
		return (userName.equals(myUserDetails.getUsername()) && !isTokenExpired(token));
	}
}
