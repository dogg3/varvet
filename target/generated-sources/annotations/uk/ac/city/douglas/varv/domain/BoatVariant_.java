package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.Boat;
import uk.ac.city.douglas.varv.domain.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-26T13:34:16")
@StaticMetamodel(BoatVariant.class)
public class BoatVariant_ { 

    public static volatile SingularAttribute<BoatVariant, Integer> year;
    public static volatile SingularAttribute<BoatVariant, Integer> customerId;
    public static volatile SingularAttribute<BoatVariant, String> description;
    public static volatile SingularAttribute<BoatVariant, Boat> boat;
    public static volatile SingularAttribute<BoatVariant, Integer> boatId;
    public static volatile SingularAttribute<BoatVariant, Customer> customer;

}