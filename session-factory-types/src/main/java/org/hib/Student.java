package org.hib;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Column(name="sno")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentNo;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;  
}