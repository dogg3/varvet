package uk.ac.city.douglas.varv.Job.domain;

import uk.ac.city.douglas.varv.Stock.domain.Part;

import java.util.List;
import java.util.Objects;

public class TaskDescription {
    private String taskDescriptionID;
    private String estimatedTime;
    private String description;
    private String taskType;
    private String jobType;
    List<Part> parts;

    public TaskDescription(String taskDescriptionID, String estimatedTime, String description, String taskType, String jobType) {
        this.taskDescriptionID = taskDescriptionID;
        this.estimatedTime = estimatedTime;
        this.description = description;
        this.taskType = taskType;
        this.jobType = jobType;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDescription that = (TaskDescription) o;
        return Objects.equals(taskDescriptionID, that.taskDescriptionID) &&
                Objects.equals(estimatedTime, that.estimatedTime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(taskType, that.taskType) &&
                Objects.equals(jobType, that.jobType) &&
                Objects.equals(parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskDescriptionID, estimatedTime, description, taskType, jobType, parts);
    }


    @Override
    public String toString() {
        return "TaskDescription{" +
                "taskDescriptionID='" + taskDescriptionID + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", description='" + description + '\'' +
                ", taskType='" + taskType + '\'' +
                ", jobType='" + jobType + '\'' +
                ", parts=" + parts +
                '}';
    }
}
