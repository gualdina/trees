package com.test.trees.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
}
