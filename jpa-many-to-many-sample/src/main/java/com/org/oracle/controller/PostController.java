package com.org.oracle.controller;

import com.org.oracle.model.Post;
import com.org.oracle.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@Valid @RequestBody Post post, @RequestParam("data") String data) {
        return ResponseEntity.ok(postRepository.save(post));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findById(@PathVariable Long postId) {
        if (!postRepository.existsById(postId))
            return ResponseEntity.notFound().build();

        Post post = postRepository.findById(postId).get();

        return ResponseEntity.ok(post);
    }

    @PutMapping("/posts/{postId}")
    public @ResponseBody Post update(@PathVariable Long postId, @Valid @RequestBody Post post) {
        return postRepository.findById(postId).map(updatePost -> {
            updatePost.setContent(post.getContent());
            updatePost.setDescription(post.getDescription());
            updatePost.setTitle(post.getTitle());

            if (post.getTags() != null || !post.getTags().isEmpty())
                updatePost.setTags(post.getTags());

            return postRepository.save(updatePost);
        }).orElseThrow(()->new RuntimeException());
    }


}
