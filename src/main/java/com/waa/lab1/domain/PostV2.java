package com.waa.lab1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostV2 {

    private long id;
    private String title;
    private String content;
    private String author;

    public void generateRandomId() {
        this.id = ThreadLocalRandom.current().nextLong(4, 100L);
    }

}
