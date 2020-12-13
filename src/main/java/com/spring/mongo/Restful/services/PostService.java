package com.spring.mongo.Restful.services;

import com.spring.mongo.Restful.domain.Post;
import com.spring.mongo.Restful.repositories.PostRepository;
import com.spring.mongo.Restful.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Not found id : " + id));
    }

}
