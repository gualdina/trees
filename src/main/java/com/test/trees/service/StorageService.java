package com.test.trees.service;


import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.stereotype.Service;


@Service
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }
    //get Storage by id
    public EmbeddedMongoProperties.Storage getStorageById(Long id) {
        storageRepository.findById(id);
    }
    //get all Storages
    public List<Storage> getAllStorages() {
        return storageRepository.findAll();
    }
    //Add new Storage
    public Storage addNewStorage(Storage storage) {
        return storageRepository.save(storage);
    }
    //exclude a Storage
    public Storage excludeStorage(Long id){
        Storage storage= getStorageById(id);
        storageRepository.delete(storage);
        return storage;
    }
    // update Storage
    public Storage updateStorageDetails(Long id, AddNewStorageRequest addNewStorageRequest) {
        Storage storageToUpdate = getStorageById(id);
        storageToUpdate.setName(addNewStorageRequest.getName());
        storageToUpdate.setArea(addNewStorageRequest.getArea());
        storageToUpdate.setLocation(addNewStorageRequest.getLocation());
        return storageToUpdate;
    }
}
