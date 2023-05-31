package com.waa.lab1.domain.dto.request;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
    private String author;
}
