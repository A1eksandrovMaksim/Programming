package com.mycompany.mywebproject.repos;

import com.mycompany.mywebproject.entities.EntityStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<EntityStudent, Long> {
    @Query(value = "select * from public.students where name ilike '%' || :name || '%'", nativeQuery = true)
    List<EntityStudent> selectByName(String name);
    @Query(value = "delete from public.students where id=:id", nativeQuery = true)
    List<EntityStudent> deleteStudentById(long id);
}

