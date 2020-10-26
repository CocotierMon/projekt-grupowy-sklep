package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroupsList")
    public List<String> getGroupsList(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(String newGroup) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroupByID")
    public String getGroupByID(){
        return "Got group by ID";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public String updateGroup(String someGroup) {
        return "Update Group";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(Long groupId){

    }
}
