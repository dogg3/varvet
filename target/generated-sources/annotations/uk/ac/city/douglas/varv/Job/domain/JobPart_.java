package uk.ac.city.douglas.varv.Job.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Job.domain.Job;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-12T17:45:28")
@StaticMetamodel(JobPart.class)
public class JobPart_ { 

    public static volatile SingularAttribute<JobPart, Integer> amount;
    public static volatile SingularAttribute<JobPart, Integer> JobPartId;
    public static volatile SingularAttribute<JobPart, String> description;
    public static volatile SingularAttribute<JobPart, Job> job;

}