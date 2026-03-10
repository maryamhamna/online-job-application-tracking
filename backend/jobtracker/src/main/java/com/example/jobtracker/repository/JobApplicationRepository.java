package com.example.jobtracker.repository;

import com.example.jobtracker.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long>{

    List<JobApplication> findByStatus(String status);

    List<JobApplication> findByCandidateNameContainingIgnoreCase(String name);
}