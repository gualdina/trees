package com.test.trees.controller;

import com.test.trees.controller.request.AddNewStorageRequest;
import com.test.trees.controller.response.StorageResponse;
import com.test.trees.model.Storage;
import com.test.trees.service.StorageService;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class StorageController {

   private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }
    //get storage by Id
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
    //get all Storages
    @GetMapping("/storages")
    public List<StorageResponse> getAllStorages(){
        List<Storage> coffees = storageService.getAllStorages();
        List<StorageResponse> storageResponseList = new ArrayList<>();
        for(Storage storage : coffees){
            storageResponseList.add(new StorageResponse(
                    storage.getId(),
                    storage.getName(),
                    storage.getArea(),
                    storage.getLocation()
            ));
        }

        return storageResponseList;
    }
    //Add new Storage
    @PostMapping(value = "/storage", consumes = "application/json")
    public StorageResponse  addNewStorage(@RequestBody @Valid AddNewStorageRequest addNewStorageRequest){
        Storage storage = storageService.addNewStorage(Storage.builder()
                .name(addNewStorageRequest.getName())
                .area(addNewStorageRequest.getArea())
                .location(addNewStorageRequest.getLocation())
                .build());
        return new StorageResponse(
                storage.getId(),
                storage.getName(),
                storage.getArea(),
                storage.getLocation()
        );
    }
    //update Storage
    @DeleteMapping("/storage/{id}")
        public void excludeStorage(@PathVariable Long id){
        storageService.excludeStorage(id);
        }
}
