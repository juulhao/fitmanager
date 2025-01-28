package com.fitmanage.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        var userEmail = this.userRepository.findByEmail(userModel.getEmail());

        if (userEmail != null) {
            System.err.println("ERROOOOOU" + userModel);

            return ResponseEntity.status(HttpStatus.CONFLICT).body("userEmail already exists");
        }

        var createUser = this.userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.OK).body(createUser);
    }
    
}
