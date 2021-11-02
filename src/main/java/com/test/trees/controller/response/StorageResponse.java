package com.test.trees.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.model.Tree;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageResponse {
    private Long id;
    private String name;
    private float area;
    private String location;
    private List<TreeResponse> treeList = new ArrayList<>();


}
