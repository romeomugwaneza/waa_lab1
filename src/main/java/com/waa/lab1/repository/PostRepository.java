package com.waa.lab1.repository;

import com.waa.lab1.domain.Post;
import com.waa.lab1.domain.PostV2;
import com.waa.lab1.domain.dto.request.PostRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PostRepository implements IPostRepository{

    private static List<Post> posts;
    private static List<PostV2> postsV2;

    static {
        posts = new ArrayList<>();
        postsV2 = new ArrayList<>();

        posts.addAll(
                List.of(
                new Post(1L,
                        "PumperMonster: When will the pyramid collapse?",
                        "I participate in this project. But this is not an investment recommendation. PumperMonster works the following way: You deposit BNB and can never withdraw the deposit. In reward you get...",
                        "Alexey Inkin"),
                new Post(2L,
                        "ES6 Proxies Made Easy: A Beginner’s Comprehensive Guide",
                        "A beginner-friendly guide to understanding and utilizing the capabilities of ES6 proxies — ES6 (ECMAScript 2015) introduced a...",
                        "Danielle Dias"),
                new Post(3L,
                        "Where Was Django Born? [Research Tutorial]",
                        "Under my previous post about Django Eric Pascula noticed two things. First I subconsciously ignore the existence of the year 2021...",
                        "Tom Smykowski")
                )
        );

        postsV2.addAll(
                List.of(
                        new PostV2(1L,
                                "How we reduced our Android startup time by 77%",
                                "Mobile performance at Turo — The startup time of a mobile app is one of the most important indicators...",
                                "Pavlo Stavytsky"),
                        new PostV2(2L,
                                "The Real Reasons You Should Write Tests",
                                "Software engineers are known to debate everything. But if there’s one thing we agree on, is that we all HATE writing tests...",
                                "Guy Erez")
                )
        );

    }

    public List<Post> findAll(){
        return posts;
    }

    public List<PostV2> findAllV2(){
        return postsV2;
    }

    @Override
    public Post getById(long id) {
        return posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post newPost) {

        posts.add(newPost);

    }

    @Override
    public void delete(long postId) {

        posts = posts.stream()
                .filter(p -> !Objects.equals(p.getId(), postId))
                .toList();

    }


    @Override
    public void update(long id, PostRequest post) {

        posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .ifPresent(p2 ->{
                    p2.setTitle(post.getTitle());
                    p2.setContent(post.getContent());
                    p2.setAuthor(post.getAuthor());
                });

    }

    @Override
    public List<PostV2> findAllV2ByAuthor(String author) {
        return postsV2.stream()
                .filter(p -> p.getAuthor().equals(author))
                .toList();
    }


}
