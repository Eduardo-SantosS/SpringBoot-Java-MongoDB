package com.spring.mongo.Restful.config;

import com.spring.mongo.Restful.domain.Post;
import com.spring.mongo.Restful.domain.User;
import com.spring.mongo.Restful.dto.AuthorDto;
import com.spring.mongo.Restful.dto.CommentDto;
import com.spring.mongo.Restful.repositories.PostRepository;
import com.spring.mongo.Restful.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

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

        Post p1= new Post(null, new Date(), "Let's go", "Travel to beach", new AuthorDto(u1));
        Post p2= new Post(null, new Date(), "Good Morning", "Going to work", new AuthorDto(u1));

        CommentDto c1 = new CommentDto("Good trip!", new Date(), new AuthorDto(u2));
        CommentDto c2 = new CommentDto("Enjoy!", new Date(), new AuthorDto(u3));
        CommentDto c3 = new CommentDto("Have a good day!", new Date(), new AuthorDto(u2));
        p1.getComments().addAll(Arrays.asList(c1,c2));
        p2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1,p2));

        u1.getPosts().addAll(Arrays.asList(p1,p2));
        userRepository.save(u1);
    }
}
