package com.waa.lab1.repository;

import com.waa.lab1.domain.Post;
import com.waa.lab1.domain.PostV2;
import com.waa.lab1.domain.dto.PostDTO;
import com.waa.lab1.domain.dto.request.PostRequest;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();
    List<PostV2> findAllV2();
    Post getById(long id);
    void save(Post newPost);
    void delete(long postId);

    void update(long id, PostRequest post);

    List<PostV2> findAllV2ByAuthor(String author);
}
