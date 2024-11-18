package com.joesalt.tutorial.config;

import com.joesalt.tutorial.security.JWTAuthenticationFilter;
import com.joesalt.tutorial.security.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

    @Autowired
    private JWTAuthenticationEntryPoint point;

    @Autowired
    private JWTAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        List<MvcRequestMatcher> mvcRequestMatchers = List.of(new MvcRequestMatcher(null, "/auth/**"),
                new MvcRequestMatcher(null, "/health/**"), new MvcRequestMatcher(null, "/swagger-ui/**"));

        RequestMatcher combinedRequestMatcher = request -> mvcRequestMatchers.stream().anyMatch(requestMatcher -> requestMatcher.matches(request));


        //noinspection removal,deprecation
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(combinedRequestMatcher).permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
