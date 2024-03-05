package com.websummarizer.Web.Summarizer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//
//    @Bean
//    protected UserDetailsService getUserDetailsService(){
//        return new CustomUserService();
//    }
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider getDaoAuthProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
//        return daoAuthenticationProvider;
//    }
//
////
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/**").permitAll(); // Allow all requests
//                })
//                .oauth2Login(withDefaults())
//                .logout((logout) -> {
//                    logout.logoutUrl("/logout");
//                    logout.logoutSuccessUrl("/");
//                })
//                .build();
//    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth->{
                    //permit all users at the home page
                    auth.requestMatchers("/").permitAll();

                    //permit only authorized users on other pages
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
