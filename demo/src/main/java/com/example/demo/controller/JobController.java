package com.example.demo.controller;

import com.example.demo.dao.JobDAO;
import com.example.demo.model.Job;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.JobDAO;
import com.example.demo.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:5173")

public class JobController {

    @Autowired
    private JobDAO jobDAO;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobDAO.getJobs();
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        boolean success = jobDAO.addJob(job);
        if (success) {
            return ResponseEntity.ok("Job added successfully");
        } else {
            return ResponseEntity.status(500).body("Error adding job");
        }
    }

    
}
