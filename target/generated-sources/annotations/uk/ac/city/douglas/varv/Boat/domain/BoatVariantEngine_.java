package uk.ac.city.douglas.varv.Boat.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Boat.domain.Engine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T08:53:21")
@StaticMetamodel(BoatVariantEngine.class)
public class BoatVariantEngine_ { 

    public static volatile SingularAttribute<BoatVariantEngine, Integer> CustomerBoatEngineId;
    public static volatile SingularAttribute<BoatVariantEngine, BoatVariant> boatVariant;
    public static volatile SingularAttribute<BoatVariantEngine, Engine> engine;

}