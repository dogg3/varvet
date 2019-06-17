package uk.ac.city.douglas.varv.Job.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskDescription {
    @Id
    private String taskDescriptionID;
    private String estimatedTime;
    private String description;
    private String taskType;


    public TaskDescription() {
    }

    public String getTaskDescriptionID() {
        return taskDescriptionID;
    }

    public void setTaskDescriptionID(String taskDescriptionID) {
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





    @Override
    public String toString() {
        return "TaskDescription{" +
                "taskDescriptionID='" + taskDescriptionID + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", description='" + description + '\'' +
                ", taskType='" + taskType + '\'' +
                '}';
    }
}
