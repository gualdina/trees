package com.test.trees.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.test.trees.model.TreeType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddNewTreeRequest {
    private TreeType type;
    private String roots;
    private double size;
}
