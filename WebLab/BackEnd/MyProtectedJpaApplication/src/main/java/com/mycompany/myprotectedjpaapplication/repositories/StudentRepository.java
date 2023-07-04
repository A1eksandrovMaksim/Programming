package com.mycompany.myprotectedjpaapplication.repositories;

import com.mycompany.myprotectedjpaapplication.entities.EStudent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<EStudent, Long>{
    @Query(value = "select * from public.students where name ilike '%' || :name || '%'", nativeQuery = true)
    List<EStudent> selectByName(String name);
}
