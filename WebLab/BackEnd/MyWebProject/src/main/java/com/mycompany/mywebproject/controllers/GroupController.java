package com.mycompany.mywebproject.controllers;

import com.mycompany.mywebproject.dto.DtoGroup;
import com.mycompany.mywebproject.entities.EntityGroup;
import com.mycompany.mywebproject.services.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final Service service;
    
    @GetMapping("/")
    public List<DtoGroup> getAll(){
        return service.getAllGroups();
    }
    
    @GetMapping("/{id}")
    public DtoGroup getById(@PathVariable long id) {
        return service.getGroupById(id);
    }

    @PostMapping("/")
    public DtoGroup add(@RequestBody DtoGroup group) {
        return service.addGroup(group);
    }

    @PutMapping("/{id}")
    public DtoGroup update(@RequestBody DtoGroup group, @PathVariable long id) {
        group.setId(id);
        return service.updateGroup(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteGroup(id);
    }
    
}
