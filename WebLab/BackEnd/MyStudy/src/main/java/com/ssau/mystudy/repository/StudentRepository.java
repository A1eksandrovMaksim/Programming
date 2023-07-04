package com.ssau.mystudy.repository;

import com.ssau.mystudy.entity.Student;

import java.util.List;

public interface StudentRepository {
    int count();

    List<Student> findAll();

    List<Student> findAllByName(String name);
    
    Student add(Student student);
    
    boolean delete(long id);
    
    Student update(Student studnt);
    
    List<Student> findById(long id);
}
