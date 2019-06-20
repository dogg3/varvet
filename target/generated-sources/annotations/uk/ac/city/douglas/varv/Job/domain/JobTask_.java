package uk.ac.city.douglas.varv.Job.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Job.domain.Job;
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T13:57:58")
@StaticMetamodel(JobTask.class)
public class JobTask_ { 

    public static volatile SingularAttribute<JobTask, Integer> jobTaskId;
    public static volatile SingularAttribute<JobTask, TaskDescription> taskDescription;
    public static volatile SingularAttribute<JobTask, String> comment;
    public static volatile SingularAttribute<JobTask, Job> job;

}