package com.webapp.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many Subjects belong to one Standard
    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;

    // Many Subjects are taught by one Teacher
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
