package com.ssau.mystudy.controller;

import com.ssau.mystudy.entity.Student;
import com.ssau.mystudy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/count")
    public int count() {
        return studentRepository.count();
    }

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("findByName/{name}")
    public List<Student> findAllByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }
    
    @PostMapping("/add")
    public Student add(@RequestBody Student student){
         return studentRepository.add(student);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id){
        return studentRepository.delete(id);
    }
    
    @PostMapping("/update")
    public Student update(@RequestBody Student student){
         return studentRepository.update(student);
    }
    
    @GetMapping("findById/{id}")
    public List<Student> findById(@PathVariable long id) {
        return studentRepository.findById(id);
    }
}
