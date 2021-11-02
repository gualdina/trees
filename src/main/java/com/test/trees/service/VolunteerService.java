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
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;
    private final TreeRepository treeRepository;
    private final StorageRepository storageRepository;


    public VolunteerService(VolunteerRepository volunteerRepository, TreeRepository treeRepository, StorageRepository storageRepository) {
        this.volunteerRepository = volunteerRepository;
        this.treeRepository = treeRepository;
        this.storageRepository = storageRepository;
    }
    //get Volunteer by id
    public Volunteer getVolunteerById(Long id) {
     return volunteerRepository.findById(id).orElseThrow(VolunteerNotFound::new);
    }
    //get all Volunteers
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }
    //Add new Volunteer
    public Volunteer addNewVolunteer(Volunteer volunteer, Long storageId) {
        Storage storage = storageRepository.findById(storageId).orElseThrow(StorageNotFound::new);
        volunteer.setVolunteerInStorage(storage);
        return volunteerRepository.save(volunteer);
    }
    //Add tree to volunteer
    public Volunteer addTreeToVolunteer(Long treeId, Long volunteerId) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        Tree tree = treeRepository.findById(treeId).get();
        tree.getVolunteerWithTrees().add(tree);
        return volunteerRepository.save(volunteer);
    }
    //remove tree from volunteer
    public Volunteer removeTreeFromVolunteer(Long treeId, Long volunteerId) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        Tree tree = treeRepository.findById(treeId).get();
        tree.getVolunteerWithTrees().remove(tree);
        return volunteerRepository.save(volunteer);
    }
    //exclude a Volunteer
    public Volunteer excludeVolunteerById(Long id){
        volunteerRepository.deleteById(id); return null;}
    // update volunteer
    public Volunteer updateVolunteerDetails(Volunteer volunteer) {
        Volunteer newVolunteer = this.getVolunteerById(volunteer.getId());
        return volunteerRepository.save(newVolunteer);
    }

}
