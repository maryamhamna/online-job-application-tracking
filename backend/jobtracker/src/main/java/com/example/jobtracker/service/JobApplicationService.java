package com.example.jobtracker.service;

import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repo;

    public JobApplicationService(JobApplicationRepository repo){
        this.repo=repo;
    }

    public List<JobApplication> getAll(){
        return repo.findAll();
    }

    public JobApplication save(JobApplication app){

        if(app.getCandidateName()==null || app.getCandidateName().isEmpty())
            throw new RuntimeException("Candidate Name required");

        if(app.getEmail()==null || app.getEmail().isEmpty())
            throw new RuntimeException("Email required");

        if(app.getPositionApplied()==null || app.getPositionApplied().isEmpty())
            throw new RuntimeException("Position required");

        return repo.save(app);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<JobApplication> search(String name){
        return repo.findByCandidateNameContainingIgnoreCase(name);
    }

    public List<JobApplication> filter(String status){
        return repo.findByStatus(status);
    }
}