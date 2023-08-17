package com.teamProject.mentoring.repository;

import com.teamProject.mentoring.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByName(String companyName);
    List<Company> findByNameContaining(String keyword);

}
