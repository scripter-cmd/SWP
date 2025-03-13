package com.solartis.SWP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solartis.SWP.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, String> {
    
}

