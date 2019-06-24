package com.org.home.controller;

import com.org.home.model.Tag;
import com.org.home.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @PostMapping("/tags")
    public ResponseEntity<Tag> create(@Valid @RequestBody Tag tag) {
        return ResponseEntity.ok(tagRepository.save(tag));
    }

    @GetMapping("/tags/{tagId}")
    public ResponseEntity<Tag> findById(@PathVariable Long tagId) {
        if (!tagRepository.existsById(tagId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tagRepository.getOne(tagId));
    }

    @PutMapping("/tags/{tagId}")
    public Tag update(@PathVariable Long tagId, @Valid @RequestBody Tag tag) {
        return tagRepository.findById(tagId).map(tagRes ->{
            tagRes.setName(tag.getName());

            if (tag.getPosts() != null || tag.getPosts().isEmpty()) {
                tagRes.setPosts(tag.getPosts());
            }

            return tagRepository.save(tagRes);

        }).orElseThrow(()->new RuntimeException());
    }

}
