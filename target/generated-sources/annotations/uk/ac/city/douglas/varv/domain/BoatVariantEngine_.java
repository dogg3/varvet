package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.BoatVariant;
import uk.ac.city.douglas.varv.domain.Engine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T16:07:03")
@StaticMetamodel(BoatVariantEngine.class)
public class BoatVariantEngine_ { 

    public static volatile SingularAttribute<BoatVariantEngine, BoatVariant> boatVariant;
    public static volatile SingularAttribute<BoatVariantEngine, Engine> engine;
    public static volatile SingularAttribute<BoatVariantEngine, Integer> customerId;
    public static volatile SingularAttribute<BoatVariantEngine, Integer> boatId;
    public static volatile SingularAttribute<BoatVariantEngine, Integer> engineId;

}