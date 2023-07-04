package com.mycompany.myprotectedjpaapplication.entities;

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
import lombok.Data;

@Entity
@Data
@Table(name="groups", schema="myprotectedjpaapplication", uniqueConstraints = { @UniqueConstraint(columnNames = "name")})
public class EGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="name", columnDefinition="text", length=100, nullable=false, unique=true)
    private String name;
    
    @OneToMany(mappedBy="group", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<EStudent> students;
}
