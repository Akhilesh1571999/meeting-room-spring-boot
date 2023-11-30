package com.example.meetingroombooking.service;

//import com.example.meetingroombooking.configuration.PasswordEncoder;
import com.example.meetingroombooking.entity.User;
import com.example.meetingroombooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

//    public User login(String email, String password) {
//        User user = userRepository.findByEmail(email);
//
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return user;
//        } else {
//            return null;
//        }
//    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User>  getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
