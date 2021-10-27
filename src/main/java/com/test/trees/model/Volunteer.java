package com.test.trees.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    @ManyToOne
    @MapsId("volunteer_id")
    @JoinColumn(name="volunteer_id")
    private Storage storage;
}
