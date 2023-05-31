package com.waa.lab1.controller;

import com.waa.lab1.domain.dto.PostDTO;
import com.waa.lab1.domain.dto.PostV2DTO;
import com.waa.lab1.domain.dto.request.PostRequest;
import com.waa.lab1.exceptions.ResourceNotFoundException;
import com.waa.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(headers = "X-API-Version=2")
    public List<PostV2DTO> getAllV2(@RequestParam(value = "filter" ,required = false) String author){
        return author != null ? postService.findAllV2ByAuthor(author) : postService.findAllV2();
    }


    @GetMapping
    public List<PostDTO> getAll(){
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public PostDTO getById(@PathVariable("postId") long id) throws ResourceNotFoundException {

        return postService.getPostById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostRequest post){

        postService.save(post);

    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long postId){

        postService.delete(postId);

    }

    @PutMapping("{postId}")
    public void update(@PathVariable("postId") long postId, @RequestBody PostRequest postRequest){

        postService.update(postId, postRequest);

    }
}
