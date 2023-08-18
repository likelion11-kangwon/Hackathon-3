package com.teamProject.mentoring.repository;

import com.teamProject.mentoring.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {
    List<Center> findByName(String centerName);

    List<Center> findByInfoContaining(String area);




}
