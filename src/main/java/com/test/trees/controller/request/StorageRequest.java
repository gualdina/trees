package com.test.trees.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.trees.model.Storage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageRequest {
    private String name;
    private float area;
    private String location;

    @JsonIgnore
    public Storage storageC(){
        return Storage.builder()
                .name(this.getName())
                .area(this.getArea())
                .location(this.getLocation())
                .volunteers(new ArrayList<>())
                .trees(new ArrayList<>())
                .build();
    }
    @JsonIgnore
    public Storage storageI(Long id){
        return Storage.builder()
                .id(id)
                .name(this.getName())
                .area(this.getArea())
                .location(this.getLocation())
                .build();
    }
}
