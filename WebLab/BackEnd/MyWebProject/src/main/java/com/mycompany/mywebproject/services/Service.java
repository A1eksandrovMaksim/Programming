package com.mycompany.mywebproject.services;

import com.mycompany.mywebproject.dto.DtoGroup;
import com.mycompany.mywebproject.dto.DtoStudent;
import com.mycompany.mywebproject.entities.EntityGroup;
import com.mycompany.mywebproject.entities.EntityStudent;
import com.mycompany.mywebproject.exceptions.UniversalException;
import com.mycompany.mywebproject.repos.GroupRepository;
import com.mycompany.mywebproject.repos.StudentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.dao.EmptyResultDataAccessException;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public List<DtoGroup> getAllGroups() {
        return groupRepository.findAll()
                                .stream()
                                .map(entity -> {return DtoGroup.fromEntity(entity);})
                                .collect(Collectors.toList());
    }
    
     public DtoGroup getGroupById(Long id) {
         try{
            return DtoGroup.fromEntity(groupRepository.findById(id).orElseThrow());
        }catch(NoSuchElementException ex){
            throw new UniversalException();
        }
    }

    public DtoGroup addGroup(DtoGroup group) {
        return DtoGroup.fromEntity(groupRepository.save(DtoGroup.toEntity(group)));
    }
    
    public DtoGroup updateGroup(DtoGroup group) {
        try{
            DtoGroup.fromEntity(groupRepository.findById(group.getId()).get());
        }catch(NoSuchElementException ex){
            return null;
        }
        return DtoGroup.fromEntity(groupRepository.save(DtoGroup.toEntity(group)));
    }

    public void deleteGroup(Long id) {
        try {
            groupRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {}
    }

    public DtoStudent addStudent(Long groupId, DtoStudent dtoStudent) {
        EntityStudent student = DtoStudent.toEntity(dtoStudent);
        try{
            student.setGroup(groupRepository.findById(groupId).get());
        }catch(NoSuchElementException ex){
            return null;
        }
        return DtoStudent.fromEntity(studentRepository.save(student));
    }

    public DtoStudent getStudentById(Long id) {
        try{
            return DtoStudent.fromEntity(studentRepository.findById(id).get());
        }catch(NoSuchElementException ex){
            throw new UniversalException();
        }
        
    }

    public List<DtoStudent> getAllStudents() {
        return studentRepository.findAll()
                .stream().map(entityStudent -> {return DtoStudent.fromEntity(entityStudent);})
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {}
    }

    public DtoStudent updateStudent(DtoStudent dtoStudent) {
        EntityStudent currentStudent;
        try{
            currentStudent = studentRepository.findById(dtoStudent.getId()).get();
        }catch(NoSuchElementException ex){
            return null;
        }
        if (dtoStudent.getName() != null)
            currentStudent.setName(dtoStudent.getName());
        if (dtoStudent.getNumber() != 0)
            currentStudent.setNumber(dtoStudent.getNumber());
        if (dtoStudent.getBirthdate() != null)
            currentStudent.setBirthdate(dtoStudent.getBirthdate());

        return DtoStudent.fromEntity(studentRepository.save(currentStudent));
    }
}
