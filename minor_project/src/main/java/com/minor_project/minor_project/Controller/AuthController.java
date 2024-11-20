package com.minor_project.minor_project.Controller;


import com.minor_project.minor_project.Entity.User;
import com.minor_project.minor_project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(400).body("Username already taken");
        }

        userService.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        User exitingUser = userService.findByUsername(user.getUsername());
        if(exitingUser!=null &&  new BCryptPasswordEncoder().matches(user.getPassword(),exitingUser .getPassword())){
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
