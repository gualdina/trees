package service;

import model.Volunteer;
import org.springframework.stereotype.Service;
import repository.VolunteerRepository;

import java.util.List;

@Service
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
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
    public Volunteer addNewVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }
    //exclude a Volunteer
    public Volunteer excludeVolunteer(Long id){
        Volunteer volunteer= getVolunteerById(id);
        volunteerRepository.delete(volunteer);
        return volunteer;
    }
    // update coffee
    public Volunteer updateVolunteerDetails(Long id, AddNewVolunteerRequest addNewVolunteerRequest) {
        Volunteer volunteerToUpdate = getVolunteerById(id);
        volunteerToUpdate.setFirstName(AddNewVolunteerRequest.getFirstName());
        volunteerToUpdate.setLastName(AddNewVolunteerRequest.getLastName());
        volunteerToUpdate.setAge(AddNewVolunteerRequest.getAge());
        volunteerToUpdate.setCity(AddNewVolunteerRequest.getCity());
        return volunteerToUpdate;
    }
}
