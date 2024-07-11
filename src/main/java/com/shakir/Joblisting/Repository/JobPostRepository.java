package com.shakir.Joblisting.Repository;

import com.shakir.Joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JobPostRepository extends MongoRepository<JobPost,String> {

}
