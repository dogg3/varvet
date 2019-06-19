package uk.ac.city.douglas.varv.Job.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskDescriptionID;
    private String estimatedTime;
    private String description;
    private String taskType;


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
