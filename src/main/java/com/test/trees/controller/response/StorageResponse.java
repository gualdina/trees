package com.test.trees.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageResponse {
    private Long id;
    private String name;
    private float area;
    private String location;
}
