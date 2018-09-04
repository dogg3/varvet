package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.BoatVariant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T15:42:31")
@StaticMetamodel(Boat.class)
public class Boat_ { 

    public static volatile SingularAttribute<Boat, Float> length;
    public static volatile SingularAttribute<Boat, Float> width;
    public static volatile SingularAttribute<Boat, Float> weight;
    public static volatile SingularAttribute<Boat, String> model;
    public static volatile SingularAttribute<Boat, Float> tank;
    public static volatile SingularAttribute<Boat, String> brand;
    public static volatile ListAttribute<Boat, BoatVariant> boatVariants;

}