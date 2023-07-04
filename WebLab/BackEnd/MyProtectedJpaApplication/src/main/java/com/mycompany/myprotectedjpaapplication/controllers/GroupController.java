package com.mycompany.myprotectedjpaapplication.controllers;

import com.mycompany.myprotectedjpaapplication.dto.Group;
import com.mycompany.myprotectedjpaapplication.services.GroupService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService service;
    
    @GetMapping("/")
    public List<Group> getAll(){
        return service.getAllGroups();
    }
    
    @GetMapping("/{id}")
    public Group getById(@PathVariable long id) {
        return service.getGroupById(id);
    }

    @PostMapping("/")
    public Group add(@RequestBody Group group) {
        return service.addGroup(group);
    }

    @PutMapping("/{id}")
    public Group update(@RequestBody Group group, @PathVariable long id) {
        group.setId(id);
        return service.updateGroup(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteGroup(id);
    }
}
