package uk.ac.city.douglas.varv.Job.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class TaskDescriptionPart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TaskDescriptionId;
    private int amount;

    @ManyToOne
    @JoinColumn(name="TaskDescriptionID")
    private TaskDescription taskDescription;

    public TaskDescriptionPart() {
    }

    public int getTaskDescriptionId() {
        return TaskDescriptionId;
    }

    public void setTaskDescriptionId(int taskDescriptionId) {
        TaskDescriptionId = taskDescriptionId;
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

    @Override
    public String toString() {
        return "TaskDescriptionPart{" +
                "TaskDescriptionId=" + TaskDescriptionId +
                ", amount=" + amount +
                ", taskDescription=" + taskDescription +
                '}';
    }
}
