package com.example.jobtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String email;
    private String phone;
    private String positionApplied;
    private int experience;
    private String status;
    private LocalDate interviewDate;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId(){ return id; }

    public String getCandidateName(){ return candidateName; }
    public void setCandidateName(String candidateName){ this.candidateName=candidateName; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }

    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone=phone; }

    public String getPositionApplied(){ return positionApplied; }
    public void setPositionApplied(String positionApplied){ this.positionApplied=positionApplied; }

    public int getExperience(){ return experience; }
    public void setExperience(int experience){ this.experience=experience; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }

    public LocalDate getInterviewDate(){ return interviewDate; }
    public void setInterviewDate(LocalDate interviewDate){ this.interviewDate=interviewDate; }

    public LocalDateTime getCreatedAt(){ return createdAt; }
}