package com.teamProject.mentoring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "company")
public class Company {
    @Id
    private Long ID;

    private String name;

    private String type;

    private String address;
}
