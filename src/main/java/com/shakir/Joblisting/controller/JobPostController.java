package com.shakir.Joblisting.controller;
import com.shakir.Joblisting.model.JobPost;
import com.shakir.Joblisting.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/JobListing")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;


    @GetMapping("/allJobPost")
    public ResponseEntity<List<JobPost>> getAllPost(){
        List<JobPost> jobPostList=jobPostService.getAllJobPost();
        return ResponseEntity.ok(jobPostList);
    }
    @GetMapping("/jobById/{jobId}")
    public ResponseEntity<Optional<JobPost>> getJobById(@PathVariable String jobId){
        return ResponseEntity.ok(jobPostService.getJobById(jobId));
    }
    @PostMapping("/addJobPost")
    public ResponseEntity<?> addJobPost(@RequestBody JobPost jobPost){
        jobPost.setJobId(UUID.randomUUID().toString().split("-")[0]);
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/updateJobPost")
    public ResponseEntity<JobPost> updateJobById(@RequestBody JobPost jobPost){
        JobPost currentJob=jobPostService.updateJobById(jobPost);
        return ResponseEntity.ok(currentJob);
    }
    @DeleteMapping("/deleteJobById/{jobId}")
    public ResponseEntity<?> deleteJobById(@PathVariable String jobId){
        jobPostService.deleteJobById(jobId);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }


}
