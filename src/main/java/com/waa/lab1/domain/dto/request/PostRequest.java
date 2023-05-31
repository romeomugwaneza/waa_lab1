package com.waa.lab1.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequest {
    private String title;
    private String content;
    private String author;
}
