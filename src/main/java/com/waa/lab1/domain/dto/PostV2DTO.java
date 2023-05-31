package com.waa.lab1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostV2DTO {

    private long id;
    private String title;
    private String author;

}
