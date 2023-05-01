package com.paybykiwi.grapneltest.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "project_employee")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String designation;

}

