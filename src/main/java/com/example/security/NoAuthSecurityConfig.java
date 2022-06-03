package com.example.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static com.example.security.SecurityConstants.freeEndpoints;
import static com.example.security.SecurityConstants.protectedEndpoints;

@Slf4j
@Configuration
@Order(0)
public class NoAuthSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(freeEndpoints)
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .and()
                .requestMatcher(new NoAuthMatcher())
                .authorizeRequests()
                .antMatchers(protectedEndpoints)
                .denyAll();

    }

    private static class NoAuthMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            return (auth == null);
        }
    }
}
