package com.test.trees.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddNewVolunteerRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String city;
}
