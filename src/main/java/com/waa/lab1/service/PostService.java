package com.waa.lab1.service;

import com.waa.lab1.domain.Post;
import com.waa.lab1.domain.dto.PostDTO;
import com.waa.lab1.domain.dto.PostV2DTO;
import com.waa.lab1.domain.dto.request.PostRequest;
import com.waa.lab1.exceptions.ResourceNotFoundException;
import com.waa.lab1.helper.ListMapper;
import com.waa.lab1.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{
    final PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> findAll() {

        return (List<PostDTO>) listMapper.mapList(postRepository.findAll(), new PostDTO());

    }

    @Override
    public List<PostV2DTO> findAllV2() {
        return (List<PostV2DTO>) listMapper.mapList(postRepository.findAllV2(), new PostV2DTO());
    }

    @Override
    public List<PostV2DTO> findAllV2ByAuthor(String author) {
        return (List<PostV2DTO>) listMapper.mapList(postRepository.findAllV2ByAuthor(author), new PostV2DTO());
    }

    @Override
    public PostDTO getPostById(long id) throws ResourceNotFoundException {

        var post = postRepository.getById(id);

        if (post == null)
            throw new ResourceNotFoundException("Post with ID: " + id + " not found for ");

        return modelMapper.map(post, PostDTO.class);

    }

    @Override
    public void save(PostRequest p) {

        var post = new Post();

        post.generateRandomId();
        post.setTitle(p.getTitle());
        post.setContent(p.getContent());
        post.setAuthor(p.getAuthor());

        postRepository.save(post);

    }

    @Override
    public void delete(long id) {

        postRepository.delete(id);

    }

    @Override
    public void update(long postId, PostRequest postRequest) {

        postRepository.update(postId, postRequest);

    }

}
