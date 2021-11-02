package com.test.trees.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.controller.response.TreeResponse;
import com.test.trees.controller.response.VolunteerResponse;
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
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    @ManyToOne
    @JoinColumn(name="volunteer_id")
    private Storage volunteerInStorage = new Storage();
    @ManyToMany
    @JoinTable(
            name = "volunteer_tree",
            joinColumns = @JoinColumn(name= "volunteer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tree_id", referencedColumnName = "id"))
    List<Tree> volunteerWithTrees = new ArrayList<>();

    @JsonIgnore
    public VolunteerResponse volunteerResponse(){
        List<TreeResponse> treeResponses = new ArrayList<>();
        if (this.volunteerWithTrees!=null && !this.volunteerWithTrees.isEmpty()) {
            for (Tree tree : this.volunteerWithTrees) {
                treeResponses.add(new TreeResponse(
                        tree.getId(),
                        tree.getType(),
                        tree.getRoots(),
                        tree.getSize(),
                        tree.getStorage().getName()
                ));
            }
        }
        return new VolunteerResponse(
                this.getId(),
                this.getFirstName(),
                this.getLastName(),
                this.getAge(),
                this.getCity(),
                treeResponses);
    }


}
