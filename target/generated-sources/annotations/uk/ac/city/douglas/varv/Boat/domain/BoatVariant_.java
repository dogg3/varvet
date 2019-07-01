package uk.ac.city.douglas.varv.Boat.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatStorage;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariantEngine;
import uk.ac.city.douglas.varv.Job.domain.Job;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-01T17:48:35")
@StaticMetamodel(BoatVariant.class)
public class BoatVariant_ { 

    public static volatile SingularAttribute<BoatVariant, Integer> CustID;
    public static volatile SingularAttribute<BoatVariant, String> year;
    public static volatile ListAttribute<BoatVariant, Job> jobs;
    public static volatile ListAttribute<BoatVariant, BoatVariantEngine> boatVariantEngines;
    public static volatile SingularAttribute<BoatVariant, String> description;
    public static volatile ListAttribute<BoatVariant, BoatStorage> boatStorages;
    public static volatile SingularAttribute<BoatVariant, Integer> customerBoatId;
    public static volatile SingularAttribute<BoatVariant, Boat> boat;
    public static volatile SingularAttribute<BoatVariant, Integer> boatId;
    public static volatile SingularAttribute<BoatVariant, Customer> customer;

}