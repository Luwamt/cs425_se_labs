package edu.miu.cs.cs425.eregistrar_webapi_security.filter;

import edu.miu.cs.cs425.eregistrar_webapi_security.service.serviceImpl.eRegistrarUserDetailsService;
import edu.miu.cs.cs425.eregistrar_webapi_security.util.JWTMgmtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class implements application logic
 * for authenticating HttpRequest from web client
 * using the JWT token passed
 */
@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTMgmtUtil jwtMgmtUtil;
    @Autowired
    private eRegistrarUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        // Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmEuYWRtaW4iLCJleHAiOjE2NTE0MzUwODEsImlhdCI6MTY1MTM5OTA4MX0.aPH-bBsaRETUip91m3y3_UTR_EwFFbIpkyOdKSTgM70KT0a7v0uAYh4NtnFqvwEgCN7kuR8MDO5VB3rktBAwpA
        String jwtToken = null;
        String username = null;
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtMgmtUtil.extractUsername(jwtToken);
        }
        if(username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(jwtMgmtUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(
                                new WebAuthenticationDetailsSource()
                                        .buildDetails(request)
                        );
                SecurityContextHolder.getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
