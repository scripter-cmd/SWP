package com.example.shrinkwrap.controllers;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shrinkwrap.model.Submission;
import com.example.shrinkwrap.repository.SubmissionRepository;






@Controller
@RequestMapping("/submission")
public class controls {   

    @Autowired
    private SubmissionRepository submissionRepository;

    @PostMapping("/save")
public ResponseEntity<Map<String, Object>> saveSubmission(@RequestBody Submission submission) {
    System.out.println("Received Submission: " + submission);
    
    submission.setCreatedDate(LocalDateTime.now());
    submission.setCreatedBy("Admin");
    submission.setSUBMISSION_NUMBER("SN-" + System.currentTimeMillis());

   
    Submission savedSubmission = submissionRepository.save(submission);

    // Create response map
    Map<String, Object> response = new HashMap<>();
    response.put("SubmissionStatus", "In Progress");
    response.put("Id", savedSubmission.getId()); // Assuming ID is auto-generated
    response.put("ProcessStatus", savedSubmission.getSUBMISSION_NUMBER());
    response.put("Owner Id", savedSubmission.getOwnerId());
    response.put("EVENTNAME", "SaveSubmission"); // You can set it based on your requirement

    return ResponseEntity.ok(response);
}


}
