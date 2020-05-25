package com.blog.blogservice.services;

import com.blog.blogservice.services.exception.ObjectNotFoundException;
import com.blog.blogservice.domain.Post;
import com.blog.blogservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado.")
        );
    }

}
