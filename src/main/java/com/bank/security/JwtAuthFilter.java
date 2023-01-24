package com.bank.security;

import com.bank.model.User;
import com.bank.service.AgentServiceImpl;
import com.bank.service.ClientServiceImpl;
import com.bank.service.helpers.JwtHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtHandler jwtHandler;
    private final AgentServiceImpl agentService;
    private final ClientServiceImpl clientService;

    @Autowired
    public JwtAuthFilter(JwtHandler jwtHandler, AgentServiceImpl agentService, ClientServiceImpl clientService) {
        this.agentService = agentService;
        this.clientService = clientService;
        this.jwtHandler = jwtHandler;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("AUTHORIZATION");
        final String userRole;
        final String userEmail;
        final String token;
        final boolean isTokenValid;

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        //extract jwt, username and userrole
        token = authHeader.substring(7);
        userEmail = jwtHandler.extractUsername(token);
        userRole = jwtHandler.extractRole(token);

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            User userDetails = null;
            if("AGENT".equals(userRole) ){
                System.out.println( "inside jwt filter Agent");
                userDetails = agentService.loadUserByEmail(userEmail);
            } else if("CLIENT".equals(userRole)){
                System.out.println( "inside jwt filter Client");
                userDetails = clientService.loadUserByEmail(userEmail);
            }

            if(userDetails != null){
                isTokenValid = jwtHandler.validateToken(token, userDetails);
                if(isTokenValid) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

        }
        filterChain.doFilter(request,response);
    }
}
