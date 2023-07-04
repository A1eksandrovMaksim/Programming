package com.mycompany.myprotectedjpaapplication.dto;

import com.mycompany.myprotectedjpaapplication.entities.EGroup;
import com.mycompany.myprotectedjpaapplication.entities.EStudent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;


@Data
public class Group {
    private long id;
    private String name;
    private List<Student> students;
    
    public static Group fromEntity(EGroup egroup){
        Group group = new Group();
        group.setId(egroup.getId());
        group.setName(egroup.getName());
        
        List<Student> students = new ArrayList<>();
        group.setStudents(students);
        
        for(EStudent student : egroup.getStudents()){
            students.add(Student.fromEntity(student));
        }
        return group;
    }
    
    public static EGroup toEntity(Group group){
        EGroup egroup = new EGroup();
        egroup.setId(group.getId());
        egroup.setName(group.getName());
        
        List<EStudent> students = new ArrayList<>();
        egroup.setStudents(students);
        
        for(Student student : group.getStudents()){
            students.add(Student.toEntity(student));
        }
        return egroup;
    }
}
