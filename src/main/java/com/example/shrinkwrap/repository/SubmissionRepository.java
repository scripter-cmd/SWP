package com.example.shrinkwrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shrinkwrap.model.Submission;


public interface SubmissionRepository extends JpaRepository<Submission, String> {
    
}
