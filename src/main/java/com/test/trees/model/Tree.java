package com.test.trees.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.controller.response.TreeResponse;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tree")
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private TreeType type;
    private String roots;
    private double size;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToMany(mappedBy = "volunteerWithTrees")
    List<Tree> volunteerWithTrees = new ArrayList<>();

    @JsonIgnore
    public TreeResponse treeResponse(){
        return new TreeResponse(
              this.getId(),
              this.getType(),
              this.getRoots(),
              this.getSize(),
              this.storage.getName()
        );
    }


}
