package com.spring.mongo.Restful.config;

import com.spring.mongo.Restful.domain.Post;
import com.spring.mongo.Restful.domain.User;
import com.spring.mongo.Restful.dto.AuthorDto;
import com.spring.mongo.Restful.repositories.PostRepository;
import com.spring.mongo.Restful.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Red", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1= new Post(null, Instant.parse("2020-12-23T16:35:40Z"), "Let's go", "Travel to beach", new AuthorDto(u1));
        Post p2= new Post(null, Instant.parse("2020-06-15T18:45:10Z"), "Good Morning", "Going to work", new AuthorDto(u1));
        postRepository.saveAll(Arrays.asList(p1,p2));
    }
}
