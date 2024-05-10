package com.demo.bankDemo.security;
/** 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/home", "/register","/css/**",
				 "/login/**").permitAll()
                .anyRequest().authenticated()
            //  .anyRequest().permitAll()

                            )
            .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(LogoutConfigurer::permitAll)
            .csrf((csrf) -> csrf.ignoringRequestMatchers("/js/**","/images/**","/webjars/**"));

        return http.build();
    }
public BCryptPasswordEncoder passwordCoder(){
    return new BCryptPasswordEncoder();
}



	
}*/
