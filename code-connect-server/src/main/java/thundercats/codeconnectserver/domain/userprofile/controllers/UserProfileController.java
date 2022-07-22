package thundercats.codeconnectserver.domain.userprofile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.services.UserProfileService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/userprofile")
public class UserProfileController {
    private UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfile> create(@RequestBody UserProfile userProfile) throws ResourceCreationException {
        userProfile = userProfileService.create(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserProfile>>getAll(){
        List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserProfile> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        UserProfile userProfile = userProfileService.getById(id);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<UserProfile> getByEmail(@RequestParam String email) throws ResourceNotFoundException {
        UserProfile userProfile = userProfileService.getByEmail(email);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserProfile> update(@PathVariable("id") Long id, @RequestBody UserProfile userProfileDetail) throws ResourceNotFoundException {
        userProfileService.update(id, userProfileDetail);
        return new ResponseEntity<>(userProfileDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        userProfileService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
