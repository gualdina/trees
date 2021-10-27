package com.test.trees.model;

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
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float area;
    private String location;
    @OneToMany(mappedBy = "storage")
    private List<Volunteer> volunteers;

    @ManyToMany //connection to insert and remove pizzas in the order
    @JoinTable( name ="storage_tree_mapping",
            joinColumns = { @JoinColumn(name = "storage_id" ) },
            inverseJoinColumns = { @JoinColumn(name = "tree_id") }
    )
    private List<Tree> stockTrees = new ArrayList<>();
    public void addATree(Tree pizza) {
        stockTrees.add(tree);
    }
    public void removeATree(Tree pizza) {
        stockTrees.remove(tree);
    }
}
