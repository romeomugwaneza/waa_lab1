package com.waa.lab1.service;

import com.waa.lab1.domain.dto.PostDTO;
import com.waa.lab1.domain.dto.PostV2DTO;
import com.waa.lab1.domain.dto.request.PostRequest;

import java.util.List;

public interface IPostService {
    List<PostDTO> findAll();
    List<PostV2DTO> findAllV2();
    List<PostV2DTO> findAllV2ByAuthor(String author);

    PostDTO getPostById(long id);

    void save(PostRequest p);

    void delete(long id);

    void update(long postId, PostRequest postRequest);
}
