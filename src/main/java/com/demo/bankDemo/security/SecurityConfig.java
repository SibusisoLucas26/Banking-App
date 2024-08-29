package com.demo.bankDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.bankDemo.Controller.PasswordCoder;
import com.demo.bankDemo.Service.Service;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private Service userDetailsService;

    @Autowired
    private PasswordCoder passwordCoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/h2-console/**", "/auth/login", "/auth/register")
                        .permitAll()
                        .anyRequest().authenticated()
                // .anyRequest().permitAll()
                )

                // .formLogin((form) -> form
                // .loginPage("/login")
                // .defaultSuccessUrl("/welcome", true)
                // .permitAll())

                // .logout(LogoutConfigurer::permitAll)
                .csrf((csrf) -> csrf.ignoringRequestMatchers("/auth/register", "/auth/login",
                        "/h2-console/**"));

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordCoder);
    }

}
