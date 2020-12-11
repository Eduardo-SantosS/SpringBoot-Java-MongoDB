package com.spring.mongo.Restful.resources;

import com.spring.mongo.Restful.domain.User;
import com.spring.mongo.Restful.dto.UserDto;
import com.spring.mongo.Restful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> list = userService.findAll();
        List<UserDto> dtoList = list.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }
}
