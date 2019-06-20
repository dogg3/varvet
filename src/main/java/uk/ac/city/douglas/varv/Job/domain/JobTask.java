package uk.ac.city.douglas.varv.Job.domain;

import javax.persistence.*;

@Entity
public class JobTask{

    @Id
    @Column(name="JobTaskId")
    private int jobTaskId;

    @ManyToOne
    @JoinColumn(name = "JobId" )
    private Job job;

    @ManyToOne
    @JoinColumn (name="TaskDescriptionId")
    TaskDescription taskDescription;

    private String comment;


    public JobTask() {
    }

    public int getJobTaskId() {
        return jobTaskId;
    }

    public void setJobTaskId(int jobTaskId) {
        this.jobTaskId = jobTaskId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "JobTask{" +
                "jobTaskId=" + jobTaskId +
                ", job=" + job +
                ", taskDescription=" + taskDescription +
                ", comment='" + comment + '\'' +
                '}';
    }
}