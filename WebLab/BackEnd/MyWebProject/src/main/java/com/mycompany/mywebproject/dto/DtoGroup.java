package com.mycompany.mywebproject.dto;

import com.mycompany.mywebproject.entities.EntityGroup;
import com.mycompany.mywebproject.entities.EntityStudent;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DtoGroup {
    private long id;
    private String name;
    private List<DtoStudent> students;
    
    public static DtoGroup fromEntity(EntityGroup group){
        DtoGroup dtoGroup = new DtoGroup();
        dtoGroup.setId(group.getId());
        dtoGroup.setName(group.getName());
        dtoGroup.setId(group.getId());
        
        List<DtoStudent> students = new ArrayList<>();
        dtoGroup.setStudents(students);
        
        for(EntityStudent student : group.getStudents()){
            students.add(DtoStudent.fromEntity(student));
        }
        return dtoGroup;
    }
    
    public static EntityGroup toEntity(DtoGroup dtoGroup){
        EntityGroup group = new EntityGroup();
        group.setId(dtoGroup.getId());
        group.setName(dtoGroup.getName());
        group.setId(dtoGroup.getId());
        
        List<EntityStudent> students = new ArrayList<>();
        group.setStudents(students);
        
        for(DtoStudent student : dtoGroup.getStudents()){
            students.add(DtoStudent.toEntity(student));
        }
        return group;
    }
}
