package org.example.authservice.config;

import org.example.authservice.services.ClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.server.adapter.HttpWebHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

    private final ClientDetailsService clientDetailsService;
    private final JWTFilter jwtFilter;

    @Autowired
    public SecurityConfig(ClientDetailsService clientDetailsService, JWTFilter jwtFilter) {
        this.clientDetailsService = clientDetailsService;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/auth/login","/hello","/auth/registration", "/error").permitAll()
                        .anyRequest().hasAnyRole("USER","ADMIN")
                )
                .formLogin((form) -> form
                        .loginPage("/auth/login").loginProcessingUrl("/process_login")
                        .defaultSuccessUrl("/hello",true)
                        .failureUrl("/auth/login?error")

                )
                .logout((log) -> log
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login")
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);






        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(clientDetailsService);
        authenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }




}
