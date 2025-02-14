package com.PizzaHut.security;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	 
	@Autowired
	private JwtFilter jwtFilter;
	@Autowired
	private CustomUserDetailsService userDetailsService;

	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authManagerBuilder.userDetailsService(userDetailsService);
		return authManagerBuilder.build();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(requests -> 
	            requests
	                // Public Endpoints (No Authentication Required)
	                .antMatchers("/authenticate", "/register").permitAll()
	                
	                // User-Specific Endpoints (Only Users Can Access)
//	                .antMatchers("/user/**").hasAuthority("User")

	                // Admin-Specific Endpoints (Only Admins Can Access)
//	                .antMatchers("/admin/**").hasAuthority("Admin")
//
//	                // Shared Endpoints (Both Users & Admins Can Access)
//	               
//	                .antMatchers("/toppings/**").hasAnyAuthority("User", "Admin")
//	                .antMatchers("/payment/**").hasAnyAuthority("User", "Admin")
//
//	                // Feedback API (Only Logged-in Users Can Submit Feedback)
//	                .antMatchers("/feedback/**").authenticated()
//
//	                // Delivery Status API (Only Admins Can Update Delivery Status)
//	                .antMatchers("/deliverystatus/**").hasAuthority("Admin")
//	                
//	                .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/user/signin").permitAll()
//
//	                // Image API (Public Access Allowed)
//	                .antMatchers("/image/**").permitAll()
//
//	                // Any Other Endpoint Requires Authentication
//	                .anyRequest().authenticated()
	        )
	        .httpBasic(Customizer.withDefaults())
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}
	@Bean
	public UserDetailsService userDetailsService() {
	    return new CustomUserDetailsService();
	}


	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); 
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
