package com.spring.mongo.Restful.services;

import com.spring.mongo.Restful.domain.User;
import com.spring.mongo.Restful.dto.UserDto;
import com.spring.mongo.Restful.repositories.UserRepository;
import com.spring.mongo.Restful.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Not found id : " + id));
    }

    public void insert(User obj){
        userRepository.save(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }



    public User fromDto(UserDto obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
