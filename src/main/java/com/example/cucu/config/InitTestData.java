package com.example.cucu.config;

import com.example.cucu.entity.Post;
import com.example.cucu.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
@Log4j2
public class InitTestData implements ApplicationListener<ApplicationReadyEvent> {

    private final PostService service;

    @Autowired
    public InitTestData(PostService service) {
        this.service = service;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        service.deleteAll();
        service.save(new Post("Post Nr: 1 title", "Post Nr: 1 content"));
        service.save(new Post("Post Nr: 2 title", "Post Nr: 2 content"));
        service.save(new Post("Post Nr: 3 title", "Post Nr: 3 content"));
        service.save(new Post("Post Nr: 4 title", "Post Nr: 4 content"));
        service.save(new Post("Post Nr: 5 title", "Post Nr: 5 content"));
    }
}
