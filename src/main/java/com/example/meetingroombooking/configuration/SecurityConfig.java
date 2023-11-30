//package com.example.meetingroombooking.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//    @Bean
//    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/api/users","/api/user/get/{id}","/api/users/email/{email}","/api/user/put/{id}","/api/user/delete/{id}",
//                        "/api/bookings","/api/bookings/get","/api/bookings/get/{id}","/api/bookings/put/{id}","/api/bookings/delete/{id}")
//                .authenticated().antMatchers("/api/users/register").permitAll().and().formLogin().and().httpBasic();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoderr(){
//        return new BCryptPasswordEncoder();
//    }
//}
