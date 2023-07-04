package com.mycompany.mywebproject.dto;

import com.mycompany.mywebproject.entities.EntityStudent;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoStudent {
    private long id;
    private String name;
    private Date birthdate;
    private int number;
    
    public static DtoStudent fromEntity(EntityStudent student){
        DtoStudent dtoStudent = new DtoStudent();
        dtoStudent.setId(student.getId());
        dtoStudent.setName(student.getName());
        dtoStudent.setBirthdate(student.getBirthdate());
        dtoStudent.setNumber(student.getNumber());
        return dtoStudent;
    }
    
    public static EntityStudent toEntity(DtoStudent dtoStudent){
        EntityStudent student = new EntityStudent();
        student.setId(dtoStudent.getId());
        student.setName(dtoStudent.getName());
        student.setBirthdate(dtoStudent.getBirthdate());
        student.setNumber(dtoStudent.getNumber());
        return student;
    }
}
