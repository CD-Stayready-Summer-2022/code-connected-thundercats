package thundercats.codeconnectserver.domain.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.group.service.GroupService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/group")
public class GroupController {

    private GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<Group> create(@RequestBody Group group) throws ResourceCreationException {
        group = groupService.create(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Group> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Group group = groupService.getById(id);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Group> update(@PathVariable("id") Long id, @RequestBody Group groupDetail) throws ResourceNotFoundException {
        groupService.update(id, groupDetail);
        return new ResponseEntity<>(groupDetail, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Group>>getAll() {
        List<Group> group = groupService.getAllGroups();
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        groupService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
