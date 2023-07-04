package com.mycompany.myprotectedjpaapplication.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name="students", schema="myprotectedjpaapplication")
public class EStudent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;
    
    private int number;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
    @JoinColumn(name="group_id", foreignKey=@ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private EGroup group;
}
