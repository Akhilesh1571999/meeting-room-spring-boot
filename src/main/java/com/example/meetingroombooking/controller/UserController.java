package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.entity.User;
import com.example.meetingroombooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User user){
//        User savedUser =null;
//        ResponseEntity response = null;
//
//        try {
//            String hashPwd = passwordEncoder.encode(user.getPassword());
//            user.setPassword(hashPwd);
//            savedUser = userService.saveUser(user);
//            if(savedUser.getUserId()>0){
//                response = ResponseEntity.status(HttpStatus.CREATED).body("User is Successfully Added");
//            }
//        }catch (Exception e){
//            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Exception occured due to "+ e.getMessage());
//        }
//
//        return response;
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User user) {
//        String email = user.getEmail();
//        String password = user.getPassword();
//
//        // Validate email and password
//
//        User user1 = userService.login(email, password);
//
//        if (user1 != null) {
//            // User successfully logged in
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            // Invalid credentials
//            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
//        }
//    }

    @GetMapping
    public String welcome() {
        return "Welcome to Google !!";
    }
    @GetMapping("/users")
    public Principal user(Principal principal) {
        System.out.println("username : " + principal.getName());
        return principal;
    }

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> getUsersByEmail(@PathVariable String email) {
        List<User> users = userService.getUserByEmail(email);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            user.setUserId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
