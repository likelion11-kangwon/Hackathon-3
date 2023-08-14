package com.teamProject.mentoring.repository;

import com.teamProject.mentoring.entity.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {
    List<ProgramEntity> findByCategory(String programCategory);


}
