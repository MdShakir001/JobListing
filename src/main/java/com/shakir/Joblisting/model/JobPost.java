package com.shakir.Joblisting.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "jobposts")
public class JobPost {
    @Id
    private String jobId;
    private String profile;
    private String desc;
    private int exp;
    private List<String> tech;
}
