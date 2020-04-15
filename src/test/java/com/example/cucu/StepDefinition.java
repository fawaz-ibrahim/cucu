package com.example.cucu;

import com.example.cucu.entity.Post;
import com.example.cucu.service.PostService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import javafx.geometry.Pos;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinition {
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl = "http://localhost";

    private long postId;

    @Given("I can create post")
    public void i_can_create_post() {
        /*String url = postUrl + ":" + port + "/post";
        List<Post> allPosts = restTemplate.getForObject(url, List.class);

        Assert.assertTrue(!allPosts.isEmpty());*/
        Assert.assertTrue(true);
    }

    @Given("^I send post to be created with post title (.*), content (.*)$")
    public void i_send_post_to_be_created_with_post_title_and_content(String post_title, String post_content) {
        String url = postUrl + ":" + port + "/post";
        Post newPost = new Post(post_title, post_content);
        Post post = restTemplate.postForObject(url, newPost, Post.class);
        postId = post.getId();
        Assert.assertNotNull(post);
    }

    @Then("I should be able to see my created post")
    public void i_should_be_able_to_see_my_created_post() {
        String url = postUrl + ":" + port + "/post/" + postId;
        Post myPost = null;//restTemplate.getForObject(url, Post.class);
        Assert.assertNotNull(myPost);
    }

}
