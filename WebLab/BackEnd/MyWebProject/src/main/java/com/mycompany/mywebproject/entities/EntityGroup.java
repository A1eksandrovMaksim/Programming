package com.mycompany.mywebproject.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="groups", schema="public", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@Getter
@Setter
public class EntityGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name", columnDefinition = "text", length = 100, nullable = false, unique = true)
    private String name;
    
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EntityStudent> students;
}
