package com.teamProject.mentoring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "programs")
public class ProgramEntity {

    @Id
    private Long id;

    private String name;

    private String branch;

    private String area;

    private String category;

}
