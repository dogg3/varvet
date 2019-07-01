package uk.ac.city.douglas.varv.Boat.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariantEngine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-01T17:48:35")
@StaticMetamodel(Engine.class)
public class Engine_ { 

    public static volatile SingularAttribute<Engine, String> horsePower;
    public static volatile SingularAttribute<Engine, String> year;
    public static volatile SingularAttribute<Engine, String> gas;
    public static volatile ListAttribute<Engine, BoatVariantEngine> boatVariantEngines;
    public static volatile SingularAttribute<Engine, String> model;
    public static volatile SingularAttribute<Engine, String> cylinder;
    public static volatile SingularAttribute<Engine, String> type;
    public static volatile SingularAttribute<Engine, String> brand;
    public static volatile SingularAttribute<Engine, Integer> engineId;

}