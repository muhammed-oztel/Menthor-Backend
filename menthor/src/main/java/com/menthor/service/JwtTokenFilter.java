package com.menthor.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private TokenManager tokenManager;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /*
         * "Bearer 123hab123123
         */
        final String authHeader = request.getHeader("Authorization");
        // System.out.println("-----------" + authHeader);
        String username = null;
        String token = null;

        if (authHeader != null && authHeader.contains("Bearer")){
            token = authHeader.substring(7);    // Token ı split yapar.

            try {
                username = tokenManager.getUsernameFromToken(token);    // Token dan username çekilir.
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        if (username != null && token != null && SecurityContextHolder.getContext().getAuthentication() == null){

            if (tokenManager.tokenValidate(token)){
                UsernamePasswordAuthenticationToken upassToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                upassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upassToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}