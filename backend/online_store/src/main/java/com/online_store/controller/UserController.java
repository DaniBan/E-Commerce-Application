package com.online_store.controller;

import com.online_store.dao.UserRepository;
import com.online_store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try {
            // register user
            User _user = userRepository
                    .save(new User(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), 1));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping("/users")
//    public ResponseEntity<User> findByUsername(@RequestParam("username") String username) {
//        try {
//            Optional<User> user = userRepository.findByUsername(username);
//
//            if(user != null){
//                return new ResponseEntity<>(user.get(), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/{username}")
//    public ResponseEntity<User> getTutorialByUsername(@PathVariable("username") String username) {
//        Optional<User> userData = userRepository.findBy
//
//        if (userData.isPresent()) {
//            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
