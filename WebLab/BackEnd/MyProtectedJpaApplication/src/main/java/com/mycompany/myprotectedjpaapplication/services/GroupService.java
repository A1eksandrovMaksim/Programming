package com.mycompany.myprotectedjpaapplication.services;

import com.mycompany.myprotectedjpaapplication.dto.Group;
import com.mycompany.myprotectedjpaapplication.exceptions.UniversalException;
import com.mycompany.myprotectedjpaapplication.repositories.GroupRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository gRepository;
    
     public List<Group> getAllGroups() {
        return gRepository.findAll()
                                .stream()
                                .map(entity -> {return Group.fromEntity(entity);})
                                .collect(Collectors.toList());
    }
    
     public Group getGroupById(Long id) {
         try{
            return Group.fromEntity(gRepository.findById(id).orElseThrow());
        }catch(NoSuchElementException ex){
            throw new UniversalException();
        }
    }

    
    public Group addGroup(Group group) {
        return Group.fromEntity(gRepository.save(Group.toEntity(group)));
    }
    
    
    public Group updateGroup(Group group) {
        try{
            Group.fromEntity(gRepository.findById(group.getId()).get());
        }catch(NoSuchElementException ex){
            return null;
        }
        return Group.fromEntity(gRepository.save(Group.toEntity(group)));
    }

    
    public void deleteGroup(Long id) {
        try {
            gRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {}
    }
}
