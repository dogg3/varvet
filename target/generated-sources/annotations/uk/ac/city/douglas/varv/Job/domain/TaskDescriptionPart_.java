package uk.ac.city.douglas.varv.Job.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-05T16:54:31")
@StaticMetamodel(TaskDescriptionPart.class)
public class TaskDescriptionPart_ { 

    public static volatile SingularAttribute<TaskDescriptionPart, Integer> TaskDescriptionPartId;
    public static volatile SingularAttribute<TaskDescriptionPart, Integer> amount;
    public static volatile SingularAttribute<TaskDescriptionPart, TaskDescription> taskDescription;

}