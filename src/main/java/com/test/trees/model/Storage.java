package com.test.trees.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.controller.response.StorageResponse;
import com.test.trees.controller.response.TreeResponse;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float area;
    private String location;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private List<Volunteer> volunteers = new ArrayList<>();

    @OneToMany(mappedBy = "storage")
    private List<Tree> trees = new ArrayList<>();

    @JsonIgnore
    public StorageResponse storageResponse(){
        List<TreeResponse> treeResponses = new ArrayList<>();
        if (this.trees!=null && !this.trees.isEmpty()) {
            for(Tree tree : this.trees) {
                treeResponses.add(new TreeResponse(
                        tree.getId(),
                        tree.getType(),
                        tree.getRoots(),
                        tree.getSize(),
                        tree.getStorage().getName()
                ));
            }
        }
        return new StorageResponse(
                this.getId(),
                this.getName(),
                this.getArea(),
                this.getLocation(),
                treeResponses);
    }
}
