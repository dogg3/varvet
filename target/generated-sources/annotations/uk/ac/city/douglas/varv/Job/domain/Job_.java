package uk.ac.city.douglas.varv.Job.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Job.domain.JobTask;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T19:38:21")
@StaticMetamodel(Job.class)
public class Job_ { 

    public static volatile SingularAttribute<Job, String> actualTime;
    public static volatile SingularAttribute<Job, String> estimatedTime;
    public static volatile SingularAttribute<Job, Integer> jobId;
    public static volatile SingularAttribute<Job, String> note;
    public static volatile SingularAttribute<Job, String> cost;
    public static volatile SingularAttribute<Job, BoatVariant> boatVariant;
    public static volatile ListAttribute<Job, JobTask> jobTasks;
    public static volatile SingularAttribute<Job, String> dateBooked;
    public static volatile SingularAttribute<Job, String> jobType;
    public static volatile SingularAttribute<Job, String> status;

}