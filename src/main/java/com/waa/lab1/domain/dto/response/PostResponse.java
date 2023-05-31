package com.waa.lab1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private long id;
    private String title;
    private String content;
    private String author;

}
