package com.mycompany.myprotectedjpaapplication.services;

import com.mycompany.myprotectedjpaapplication.dto.Student;
import com.mycompany.myprotectedjpaapplication.entities.EStudent;
import com.mycompany.myprotectedjpaapplication.exceptions.UniversalException;
import com.mycompany.myprotectedjpaapplication.repositories.GroupRepository;
import com.mycompany.myprotectedjpaapplication.repositories.StudentRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository sRepository;
    private final GroupRepository gRepository;
    
    
     public Student addStudent(Long groupId, Student student) {
        EStudent estudent = Student.toEntity(student);
        try{
            estudent.setGroup(gRepository.findById(groupId).get());
        }catch(NoSuchElementException ex){
            return null;
        }
        return student.fromEntity(sRepository.save(estudent));
    }

    public Student getStudentById(Long id) {
        try{
            return Student.fromEntity(sRepository.findById(id).get());
        }catch(NoSuchElementException ex){
            throw new UniversalException();
        }
        
    }

    public List<Student> getAllStudents() {
        return sRepository.findAll()
                .stream().map(entityStudent -> {return Student.fromEntity(entityStudent);})
                .collect(Collectors.toList());
    }

    
    public void deleteStudent(Long id) {
        try {
            sRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {}
    }

    
    public Student updateStudent(Student dtoStudent) {
        EStudent currentStudent;
        try{
            currentStudent = sRepository.findById(dtoStudent.getId()).get();
        }catch(NoSuchElementException ex){
            return null;
        }
        currentStudent.setName(dtoStudent.getName());
        currentStudent.setNumber(dtoStudent.getNumber());
        currentStudent.setBirthdate(dtoStudent.getBirthdate());
        return Student.fromEntity(sRepository.save(currentStudent));
    }
}
