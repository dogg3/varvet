package uk.ac.city.douglas.varv.Job.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Boat.domain.Boat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T16:54:21")
@StaticMetamodel(BoatVariant.class)
public class BoatVariant_ { 

    public static volatile SingularAttribute<BoatVariant, Integer> year;
    public static volatile SingularAttribute<BoatVariant, Integer> custID;
    public static volatile SingularAttribute<BoatVariant, String> description;
    public static volatile SingularAttribute<BoatVariant, Boat> boat;
    public static volatile SingularAttribute<BoatVariant, Integer> boatId;
    public static volatile SingularAttribute<BoatVariant, Customer> customer;

}