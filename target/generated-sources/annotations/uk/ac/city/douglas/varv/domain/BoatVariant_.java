package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.Boat;
import uk.ac.city.douglas.varv.domain.BoatVariantStorage;
import uk.ac.city.douglas.varv.domain.Customer;
import uk.ac.city.douglas.varv.domain.Engine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T22:57:11")
@StaticMetamodel(BoatVariant.class)
public class BoatVariant_ { 

    public static volatile SingularAttribute<BoatVariant, String> engineModel;
    public static volatile SingularAttribute<BoatVariant, Integer> year;
    public static volatile SingularAttribute<BoatVariant, Engine> engine;
    public static volatile SingularAttribute<BoatVariant, Integer> customerId;
    public static volatile SingularAttribute<BoatVariant, String> description;
    public static volatile SingularAttribute<BoatVariant, String> boatBrand;
    public static volatile SingularAttribute<BoatVariant, String> boatModel;
    public static volatile ListAttribute<BoatVariant, BoatVariantStorage> boatVariantStorages;
    public static volatile SingularAttribute<BoatVariant, String> engineBrand;
    public static volatile SingularAttribute<BoatVariant, Boat> boat;
    public static volatile SingularAttribute<BoatVariant, Customer> customer;

}