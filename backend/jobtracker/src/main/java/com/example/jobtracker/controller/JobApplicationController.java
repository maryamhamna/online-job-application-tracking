package com.example.jobtracker.controller;

import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.service.JobApplicationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service){
        this.service=service;
    }

    @GetMapping
    public List<JobApplication> getAll(){
        return service.getAll();
    }

    @PostMapping
    public JobApplication add(@RequestBody JobApplication app){
        return service.save(app);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/search")
    public List<JobApplication> search(@RequestParam String name){
        return service.search(name);
    }

    @GetMapping("/status/{status}")
    public List<JobApplication> filter(@PathVariable String status){
        return service.filter(status);
    }
}