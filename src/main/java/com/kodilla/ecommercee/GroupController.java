package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    private GroupDbService groupDbService;
    private GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getGroupsList")
    public List<GroupDto> getGroupsList() {
        return groupMapper.mapToGroupsListDto(groupDbService.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupDbService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroupByID")
    public GroupDto getGroupByID(@RequestParam Long id) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupDbService.getGroup(id).orElseThrow(GroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupDbService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam Long id) {
        groupDbService.deleteGroup(id);
    }
}