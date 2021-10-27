package com.test.trees.controller.response;

import lombok.*;
import com.test.trees.model.TreeType;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeResponse {
    private Long id;
    private TreeType type;
    private String roots;
    private double size;
}
