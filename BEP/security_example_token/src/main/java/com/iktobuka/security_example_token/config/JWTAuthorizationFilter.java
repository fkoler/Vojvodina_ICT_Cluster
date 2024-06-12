package com.iktobuka.security_example_token.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private SecretKey secretKey;

	public JWTAuthorizationFilter(SecretKey secretKey) {
		super();
		this.secretKey = secretKey;
	}

	private boolean checkJWTToken(
			HttpServletRequest request, 
			HttpServletResponse res
		) {
		String authenticationHeader = request.getHeader(HEADER);
		
		if (authenticationHeader == null || 			!authenticationHeader.startsWith(PREFIX)) {
			return false;
		}
		
		return true;
	}

	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER);

		if (jwtToken == null || !jwtToken.startsWith(PREFIX)) {
			throw new IllegalArgumentException(
					"Invalid JWT token in request headers"
			);
		}

		jwtToken = jwtToken.replace(PREFIX, "");

		try {
			return Jwts.parser().setSigningKey(secretKey)
						.build().parseClaimsJws(jwtToken).getBody();
		} catch (JwtException e) {
			throw new IllegalArgumentException("Invalid JWT token", e);
		}
	}

	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		try {
			if (checkJWTToken(request, response)) {
				Claims claims = validateToken(request);
				if (claims != null && claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		} finally {
			chain.doFilter(request, response);
		}
	}
}
