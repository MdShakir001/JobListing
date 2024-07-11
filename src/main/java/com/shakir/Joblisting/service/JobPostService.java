package com.shakir.Joblisting.service;

import com.shakir.Joblisting.Repository.JobPostRepository;
import com.shakir.Joblisting.model.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobRepo;

    public JobPost addJobPost(JobPost job){
        return jobRepo.save(job);
    }
    public List<JobPost> getAllJobPost(){
        return jobRepo.findAll();
    }
    public Optional<JobPost> getJobById(String jobId){
        Optional<JobPost> jobPost=jobRepo.findById(jobId);
        return jobPost;

    }
    public JobPost updateJobById(JobPost updatedJob){
        Optional<JobPost> currJob1=jobRepo.findById(updatedJob.getJobId());
        if(!currJob1.isPresent()){
            return null;
        }
        JobPost currJob=currJob1.get();
        currJob.setExp(updatedJob.getExp());
        currJob.setDesc(updatedJob.getDesc());
        currJob.setTech(updatedJob.getTech());
        return jobRepo.save(currJob);
    }
    public void deleteJobById(String jobId){
        jobRepo.deleteById(jobId);
    }



}
