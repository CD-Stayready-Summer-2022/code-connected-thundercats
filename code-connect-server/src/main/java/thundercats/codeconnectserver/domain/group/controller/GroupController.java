package thundercats.codeconnectserver.domain.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import thundercats.codeconnectserver.domain.group.service.GroupService;

import java.util.List;

public class GroupController {

    private GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

}
