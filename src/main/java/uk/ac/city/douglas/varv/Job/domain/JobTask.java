package uk.ac.city.douglas.varv.Job.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobTask{

    @Id
    @Column(name="taskDescriptionID")
    private int taskDescriptionId;
    @Column(name="estimatedTime")
    private String estimatedTime;
    @Column(name="taskType")
    private String taskType;

}