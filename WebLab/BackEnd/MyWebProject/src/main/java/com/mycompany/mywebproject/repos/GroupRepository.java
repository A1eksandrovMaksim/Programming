package com.mycompany.mywebproject.repos;

import com.mycompany.mywebproject.entities.EntityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<EntityGroup, Long> {
}
