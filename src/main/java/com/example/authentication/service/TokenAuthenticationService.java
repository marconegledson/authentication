package com.example.authentication.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	private static final String SECRET = "MySecret";
	private static final String TOKEN_PREFIX = "Bearer";
	private static final String HEADER_STRING = "Authorization";

	public static void addAuthentication(HttpServletResponse response, String username) {
		final String JWT = Jwts.builder().setSubject(username)
				.setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}

	public static Authentication getAuthentication(HttpServletRequest request) {
		UsernamePasswordAuthenticationToken authentication = null;
		final String token = request.getHeader(HEADER_STRING);

		if (!StringUtils.isEmpty(token)) {
			final String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody().getSubject();

			if (!StringUtils.isEmpty(user)) {
				authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}

		return authentication;
	}

}
