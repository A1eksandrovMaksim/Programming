package com.mycompany.mywebproject.controllers;

import com.mycompany.mywebproject.dto.DtoStudent;
import com.mycompany.mywebproject.entities.EntityStudent;
import com.mycompany.mywebproject.services.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
     private final Service service;
     
     @GetMapping("/")
    public List<DtoStudent> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public DtoStudent getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PostMapping("/{groupId}")
    public DtoStudent add(@PathVariable Long groupId, @RequestBody DtoStudent student) {
        return service.addStudent(groupId, student);
    }

    @PutMapping("/{id}")
    public DtoStudent update(@PathVariable Long id, @RequestBody DtoStudent student) {
        student.setId(id);
        return service.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
