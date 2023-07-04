package com.mycompany.myprotectedjpaapplication.dto;

import com.mycompany.myprotectedjpaapplication.entities.EStudent;
import java.util.Date;
import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private Date birthdate;
    private int number;
    
    public static Student fromEntity(EStudent estudent){
        Student student = new Student();
        student.setId(estudent.getId());
        student.setName(estudent.getName());
        student.setNumber(estudent.getNumber());
        student.setBirthdate(estudent.getBirthdate());
        return student;
    }
    
    public static EStudent toEntity(Student student){
        EStudent estudent = new EStudent();
        estudent.setId(student.getId());
        estudent.setName(student.getName());
        estudent.setNumber(student.getNumber());
        estudent.setBirthdate(student.getBirthdate());
        return estudent;
    }
}
