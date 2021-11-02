package com.test.trees.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.model.Storage;
import com.test.trees.model.Tree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.test.trees.model.TreeType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeRequest {
    private TreeType type;
    private String roots;
    private double size;
    private Long storageId;

    @JsonIgnore
    public Tree treeC() {
        return Tree.builder()
                .type(this.getType())
                .roots(this.getRoots())
                .size(this.getSize())
                .storage(new Storage())
                .build();
    }
    @JsonIgnore
    public Tree treeI(Long id) {
        return Tree.builder()
                .id(id)
                .type(this.getType())
                .roots(this.getRoots())
                .size(this.getSize())
                .build();
    }
}
