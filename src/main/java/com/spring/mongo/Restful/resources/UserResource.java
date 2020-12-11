package com.spring.mongo.Restful.resources;

import com.spring.mongo.Restful.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User u1 = new User("1", "Maria Brown", "maria@gmail.com");
        User u2 = new User("2", "Alex Green", "alex@gmail.com");
        
        return ResponseEntity.ok().body(Arrays.asList(u1, u2));
    }
}
