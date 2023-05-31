package com.waa.lab1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private long id;
    private String title;
    private String content;
    private String author;

    public void generateRandomId() {
        this.id = ThreadLocalRandom.current().nextLong(4, Long.MAX_VALUE);
    }

}




