package uk.ac.city.douglas.varv.Job.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class JobPart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int JobPartId;
    private int amount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="jobId")
    private Job job;

    private String description;


    public JobPart() {
    }

    public int getJobPartId() {
        return JobPartId;
    }

    public void setJobPartId(int jobPartId) {
        JobPartId = jobPartId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "JobPart{" +
                "JobPartId=" + JobPartId +
                ", amount=" + amount +
                ", job=" + job +
                ", description='" + description + '\'' +
                '}';
    }
}
