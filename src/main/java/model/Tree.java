package model;

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
    @ManyToMany(mappedBy = "stockTrees")
    private List<Tree> stockTrees = new ArrayList<>();
}
