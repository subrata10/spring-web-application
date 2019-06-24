package com.org.home.controller;

import com.org.home.exception.ResourceNotFoundException;
import com.org.home.model.Post;
import com.org.home.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @GetMapping("/posts/{postId}")
    public Post getPostByPostId(@PathVariable Long postId) {
       return postRepository.findById(postId).orElseThrow(
               ()->new ResourceNotFoundException("Post id "+ postId + " not found.")
       );
    }

    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post, @RequestParam(value = "data", required = true) String data) {
        System.out.println("query param " + data);
        return postRepository.save(post);
    }

    @PutMapping("/posts/{postId}")
    public @ResponseBody Post updatePost(@PathVariable Long postId, @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(
            post -> {
                post.setTitle(postRequest.getTitle());
                post.setContent(postRequest.getContent());
                post.setDescription(postRequest.getDescription());
                return postRepository.save(post);
            }
        ).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " Not found"));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(
                post -> {
                    postRepository.delete(post);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("Post id " + postId + " not found"));
    }

}
