package thundercats.codeconnectserver.domain.group.service;

import org.apache.catalina.User;
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.group.model.Group;

import java.util.List;

public interface GroupService {
    Group create(Group group) throws ResourceCreationException;
    Group getById(Long id) throws ResourceNotFoundException;
    Group update(Long id, Group groupDetail) throws ResourceNotFoundException;
    List<Group> getAllGroups();
    void delete(Long id) throws ResourceNotFoundException;
}
