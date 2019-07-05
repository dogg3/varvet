package uk.ac.city.douglas.varv.Job.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class TaskDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskDescriptionID;
    private String estimatedTime;
    private String description;
    private String taskType;

    @OneToMany(mappedBy = "taskDescription")
    private List<JobTask> jobTasks;

    @OneToMany(mappedBy = "taskDescription")
    private List<TaskDescriptionPart> partList;


    public TaskDescription() {
    }

    public int getTaskDescriptionID() {
        return taskDescriptionID;
    }

    public void setTaskDescriptionID(int taskDescriptionID) {
        this.taskDescriptionID = taskDescriptionID;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public List<JobTask> getJobTasks() {
        return jobTasks;
    }

    public void setJobTasks(List<JobTask> jobTasks) {
        this.jobTasks = jobTasks;
    }

    @Override
    public String toString() {
        return "TaskDescription{" +
                "taskDescriptionID=" + taskDescriptionID +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", description='" + description + '\'' +
                ", taskType='" + taskType + '\'' +
                ", jobTasks=" + jobTasks +
                '}';
    }
}
