package com.waa.lab1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsResponse {

    List<PostResponse> postsResponse = new ArrayList<>();

}
