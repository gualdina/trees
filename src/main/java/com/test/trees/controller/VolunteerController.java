package com.test.trees.controller;

import com.test.trees.controller.request.TreeRequest;
import com.test.trees.controller.request.VolunteerRequest;
import com.test.trees.controller.response.StorageResponse;
import com.test.trees.controller.response.TreeResponse;
import com.test.trees.controller.response.VolunteerResponse;
import com.test.trees.model.Volunteer;
import com.test.trees.service.VolunteerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class VolunteerController {
    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    public List<VolunteerResponse> volunteerResponses(List<Volunteer> volunteers){
        List<VolunteerResponse> volunteerResponses = new ArrayList<>();
        for(Volunteer volunteer : volunteers){
            volunteerResponses.add(volunteer.volunteerResponse());
        }
        return volunteerResponses;
    }
    //get volunteer by Id
    @GetMapping("/volunteer/{id}")
    public VolunteerResponse getVolunteerById(@PathVariable(value = "id") Long id){
        return volunteerService.getVolunteerById(id).volunteerResponse();
    }
    //get all  volunteers
    @GetMapping("/volunteers")
    public List<VolunteerResponse> getAllTrees(){
        return this.volunteerResponses(volunteerService.getAllVolunteers());
    }
    //add volunteer
    @PostMapping(value = "/volunteer", consumes = "application/json", produces = "application/json")
    public VolunteerResponse addNewVolunteer(@RequestBody VolunteerRequest volunteerRequest) {
        return volunteerService.addNewVolunteer(volunteerRequest.volunteerC(), volunteerRequest.getStorageId()).volunteerResponse();
    }
    //update volunteer details
    @PutMapping(value = "/volunteer-update")
    public VolunteerResponse updateVolunteerDetails(@RequestParam Long id, VolunteerRequest volunteerRequest){
        return volunteerService.updateVolunteerDetails(volunteerRequest.volunteerI(id)).volunteerResponse();
    }
    //exclude
    @DeleteMapping("/volunteer/{id}")
    public void excludeVolunteerById(@PathVariable Long id){volunteerService.excludeVolunteerById(id);
    }
    //add tree to storage
    @PutMapping(value = "/volunteer/{id}/tree/{id}")
    public VolunteerResponse addTreeToVolunteer(@PathVariable Long treeId, Long volunteerId){
        return volunteerService.addTreeToVolunteer(treeId, volunteerId).volunteerResponse();
    }
    //delete tree from storage
    @DeleteMapping(value = "/tree-delete")
    public VolunteerResponse removeTreeToVolunteer(@PathVariable Long treeId, Long volunteerId){
        return volunteerService.removeTreeFromVolunteer(treeId, volunteerId).volunteerResponse();
    }
}
