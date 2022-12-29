package com.example.workout.global.security;

import com.example.workout.global.filter.JwtRequestFilter;
import com.example.workout.global.security.handler.CustomAccessDeniedHandler;
import com.example.workout.global.security.handler.CustomAuthenticationEntryPointHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .cors()
                .and()
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/email/**").permitAll()
                .antMatchers(HttpMethod.POST, "/email/send").permitAll()
                .antMatchers(HttpMethod.HEAD, "/email/**").permitAll()

                .antMatchers("/member/**").permitAll()

                .antMatchers( "/notice/**").hasAuthority("TEACHER")
                .antMatchers(HttpMethod.GET , "/notice/**").hasAuthority("STUDENT")
                .antMatchers("/comment/notice/**").hasAnyAuthority("STUDENT" , "TEACHER")


                .antMatchers("/require/**").hasAuthority("STUDENT")
                .antMatchers(HttpMethod.GET , "/require/**").hasAuthority("STUDENT")
                .antMatchers("/comment/require/**").hasAnyAuthority("STUDENT" , "TEACHER")


                .antMatchers("/board/**").hasAnyAuthority("STUDENT" , "TEACHER")
                .antMatchers("/comment/board/**").hasAnyAuthority("STUDENT" , "TEACHER")



                .anyRequest().authenticated();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .authenticationEntryPoint(new CustomAuthenticationEntryPointHandler());
        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
