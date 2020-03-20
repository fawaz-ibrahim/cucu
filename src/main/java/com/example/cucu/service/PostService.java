package com.example.cucu.service;

import com.example.cucu.entity.Post;
import com.example.cucu.entity.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository repository;

    public List<Post> findAll() {
        return (List<Post>)repository.findAll();
    }

    public Post findById(long id) {
        return repository.findById(id).get();
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public Post deleteById(long id) {
        Post post = findById(id);
        repository.deleteById(post.getId());

        return post;
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
