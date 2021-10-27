package com.test.trees.controller;

import com.test.trees.controller.request.AddNewTreeRequest;
import com.test.trees.controller.response.TreeResponse;
import com.test.trees.controller.response.VolunteerResponse;
import com.test.trees.model.Tree;
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
    //get volunteer by Id
    @GetMapping("/volunteer/{id}")
    public VolunteerResponse getVolunteerById(@PathVariable Long id){
        Volunteer volunteer = volunteerService.getVolunteerById(id);
        return new VolunteerResponse(
                volunteer.getId(),
                volunteer.getFirstName(),
                volunteer.getLastName(),
                volunteer.getAge(),
                volunteer.getCity()
        );
    }
    //get all  volunteers
    @GetMapping("/ volunteers")
    public List<VolunteerResponse> getAllTrees(){
        List<Volunteer> volunteers =  volunteerService.getAllVolunteers();
        List<VolunteerResponse> volunteerResponseList = new ArrayList<>();
        for(Volunteer volunteer : volunteers){
            volunteerResponseList.add(new VolunteerResponse(
                    volunteer.getId(),
                    volunteer.getFirstName(),
                    volunteer.getLastName(),
                    volunteer.getAge(),
                    volunteer.getCity()
            ));
        }

        return volunteerResponseList;
    }

}
