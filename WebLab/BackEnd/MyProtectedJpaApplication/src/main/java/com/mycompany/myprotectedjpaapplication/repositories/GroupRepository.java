package com.mycompany.myprotectedjpaapplication.repositories;

import com.mycompany.myprotectedjpaapplication.entities.EGroup;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<EGroup, Long>{}
