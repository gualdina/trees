package com.test.trees.service;


import com.test.trees.controller.exception.StorageNotFound;
import com.test.trees.controller.exception.TreeNotFound;
import com.test.trees.controller.exception.VolunteerNotFound;
import com.test.trees.model.Storage;
import com.test.trees.model.Tree;
import com.test.trees.model.Volunteer;
import com.test.trees.repository.StorageRepository;
import com.test.trees.repository.TreeRepository;
import com.test.trees.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StorageService {
    private final StorageRepository storageRepository;
    private final TreeRepository treeRepository;
    private final VolunteerRepository volunteerRepository;

    public StorageService(StorageRepository storageRepository, TreeRepository treeRepository, VolunteerRepository volunteerRepository) {
        this.storageRepository = storageRepository;
        this.treeRepository = treeRepository;
        this.volunteerRepository = volunteerRepository;
    }
    //get Storage by id
    public Storage getStorageById(Long id) {
       return storageRepository.findById(id).orElseThrow(StorageNotFound::new);
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
    public Storage excludeStorageById(Long id){
        storageRepository.deleteById(id);  return null;}
    // update Storage
    public Storage updateStorageDetails(Storage storage) {
        Storage newStorage = this.getStorageById(storage.getId());
        return storageRepository.save(newStorage);
    }
    //Add tree to storage
    public  Storage addTreeToStorage(Long treeId, Long storageId) {
        Storage storage = storageRepository.findById(storageId).get();
        Tree tree = treeRepository.findById(treeId).get();
        storage.getTrees().add(tree);
        tree.setStorage(storage);
        return storageRepository.save(storage);
    }
    //remove tree from storage
    public  Storage removeTreeFromStorage(Long treeId, Long storageId) {
        Storage storage = storageRepository.findById(storageId).get();
        Tree tree = treeRepository.findById(treeId).get();
        storage.getTrees().remove(tree);
        tree.setStorage(null);
        return storageRepository.save(storage);
    }
    //Add volunteer to storage
    public  Storage addVolunteerToStorage(Long volunteerId, Long storageId) {
        Storage storage = storageRepository.findById(storageId).get();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        storage.getVolunteers().add(volunteer);
        volunteer.setVolunteerInStorage(storage);
        return storageRepository.save(storage);
    }
    //remove volunteer from storage
    public  Storage removeVolunteerFromStorage(Long volunteerId, Long storageId) {
        Storage storage = storageRepository.findById(storageId).get();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        storage.getVolunteers().remove(volunteer);
        volunteer.setVolunteerInStorage(null);
        return storageRepository.save(storage);
    }
}
