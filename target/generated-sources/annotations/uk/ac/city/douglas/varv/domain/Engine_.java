package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.BoatVariant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T22:57:11")
@StaticMetamodel(Engine.class)
public class Engine_ { 

    public static volatile SingularAttribute<Engine, Double> horsePower;
    public static volatile SingularAttribute<Engine, Integer> year;
    public static volatile SingularAttribute<Engine, String> model;
    public static volatile SingularAttribute<Engine, String> brand;
    public static volatile ListAttribute<Engine, BoatVariant> boatVariants;

}