//package com.example.meetingroombooking.configuration;
//
//import com.example.meetingroombooking.entity.User;
//import com.example.meetingroombooking.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (userRepository.count() == 0) {
//            User defaultUser = new User();
//            defaultUser.setEmail("akhil@email.com");
//            defaultUser.setPassword(passwordEncoder.encode("Ak@25221"));
//
//            userRepository.save(defaultUser);
//        }
//
//    }
//}
