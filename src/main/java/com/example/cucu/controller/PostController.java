package com.example.cucu.controller;

import com.example.cucu.entity.Post;
import com.example.cucu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPost() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable(value = "id")long id) {
        return postService.findById(id);
    }

    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return postService.save(post);
    }

    public List<Post> getAllPostFallback() {
        //return Collections.emptyList();
        return Arrays.asList(new Post("Empty title", "Empty content"));
    }
}
