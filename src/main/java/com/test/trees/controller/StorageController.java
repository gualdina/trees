package com.test.trees.controller;

import com.test.trees.controller.request.StorageRequest;
import com.test.trees.controller.response.StorageResponse;
import com.test.trees.model.Storage;
import com.test.trees.service.StorageService;
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

    public List<StorageResponse> storageResponses(List<Storage> storages){
        List<StorageResponse> storageResponses = new ArrayList<>();
        for (Storage storage : storages){storageResponses.add(storage.storageResponse());}
        return storageResponses;
    }
    //get all Storages
    @GetMapping("/storages")
    public List<StorageResponse> getAllStorages(){
        return  this.storageResponses(storageService.getAllStorages());
    }
    //get storage by Id
    @GetMapping("/storage/{id}")
    public StorageResponse getStorageById(@PathVariable(value = "id") Long id){
        return storageService.getStorageById(id).storageResponse();
    }
    //Add new Storage
    @PostMapping(value = "/storage", consumes = "application/json")
    public StorageResponse  addNewStorage(@RequestBody StorageRequest storageRequest){
        return storageService.addNewStorage(storageRequest.storageC()).storageResponse();
    }
    //update Storage
    @PutMapping(value = "/storage-update")
    public StorageResponse updateStorageDetails(@RequestParam Long id, StorageRequest storageRequest){
        return storageService.updateStorageDetails(storageRequest.storageI(id)).storageResponse();
    }
    //add tree to storage
    @PutMapping(value = "/storage/{id}/tree/{id}")
    public StorageResponse addTreeToStorage(@PathVariable Long treeId, Long storageId){
        return storageService.addTreeToStorage(treeId, storageId).storageResponse();
    }
    //add volunteer to storage
    @PutMapping(value = "/storage/{id}/volunteer/{id}")
    public StorageResponse addVolunteerToStorage(@PathVariable Long volunteerId, Long storageId){
        return storageService.addVolunteerToStorage(volunteerId, storageId).storageResponse();
    }
    //delete tree from storage
    @DeleteMapping(value = "/tree-delete")
    public StorageResponse removeTreeToStorage(@PathVariable Long treeId, Long storageId){
        return storageService.removeTreeFromStorage(treeId, storageId).storageResponse();
    }
    // delete volunteer from storage
    @DeleteMapping(value = "/volunteer-delete")
    public StorageResponse removeVolunteerToStorage(@PathVariable Long volunteerId, Long storageId){
        return storageService.removeVolunteerFromStorage(volunteerId, storageId).storageResponse();
    }
    //erase storage
    @DeleteMapping(value = "/storage-delete")
        public void excludeStorageById(@PathVariable Long id){storageService.excludeStorageById(id);
    }
}
