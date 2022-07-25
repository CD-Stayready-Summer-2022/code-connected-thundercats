package thundercats.codeconnectserver.domain.group.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.group.repo.GroupRepo;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    private GroupRepo groupRepo;

    @Autowired
    public GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Override
    public Group create(Group group) throws ResourceCreationException {
        return null;
    }

    @Override
    public Group getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Group update(Long id, Group groupDetail) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Group group = getById(id);
        groupRepo.delete(group);

    }
}
