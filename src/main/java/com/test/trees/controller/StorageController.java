package com.test.trees.controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@Validated
public class StorageController {

   private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }
    //get coffee by Id
    @GetMapping("/storage/{id}")
    public StorageResponse getStorageById(@PathVariable Long id){
        Storage storage = storageService.getStorageById(id);
        return new StorageResponse(
                storage.getId(),
                storage.getName(),
                storage.getArea(),
                storage.getLocation()
        );
    }

}
