package uk.ac.city.douglas.varv.Job.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Job.domain.JobTask;
import uk.ac.city.douglas.varv.Job.domain.TaskDescriptionPart;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-12T17:45:28")
@StaticMetamodel(TaskDescription.class)
public class TaskDescription_ { 

    public static volatile SingularAttribute<TaskDescription, String> estimatedTime;
    public static volatile SingularAttribute<TaskDescription, String> taskType;
    public static volatile SingularAttribute<TaskDescription, Integer> taskDescriptionID;
    public static volatile SingularAttribute<TaskDescription, String> description;
    public static volatile ListAttribute<TaskDescription, JobTask> jobTasks;
    public static volatile ListAttribute<TaskDescription, TaskDescriptionPart> partList;

}