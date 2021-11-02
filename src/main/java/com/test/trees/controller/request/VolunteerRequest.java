package com.test.trees.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.model.Storage;
import com.test.trees.model.Volunteer;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private Long storageId;

    @JsonIgnore
    public Volunteer volunteerC() {
        return Volunteer.builder()
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .age(this.getAge())
                .city(this.getCity())
                .volunteerInStorage(new Storage())
                .volunteerWithTrees(new ArrayList<>())
                .build();

    }
    @JsonIgnore
    public Volunteer volunteerI(Long id) {
        return Volunteer.builder()
                .id(id)
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .age(this.getAge())
                .city(this.getCity())
                .build();
    }


}
