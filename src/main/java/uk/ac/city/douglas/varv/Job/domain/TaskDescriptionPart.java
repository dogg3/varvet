package uk.ac.city.douglas.varv.Job.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class TaskDescriptionPart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TaskDescriptionPartId;
    private int amount;

    @ManyToOne
    @JoinColumn(name="TaskDescriptionID")
    private TaskDescription taskDescription;

    public TaskDescriptionPart() {
    }

    public int getTaskDescriptionPartId() {
        return TaskDescriptionPartId;
    }

    public void setTaskDescriptionPartId(int taskDescriptionPartId) {
        TaskDescriptionPartId = taskDescriptionPartId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        this.taskDescription = taskDescription;
    }
}
