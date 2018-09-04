package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.BoatVariantStorage;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T15:42:31")
@StaticMetamodel(Storage.class)
public class Storage_ { 

    public static volatile SingularAttribute<Storage, String> name;
    public static volatile SingularAttribute<Storage, Float> length;
    public static volatile SingularAttribute<Storage, Float> width;
    public static volatile SingularAttribute<Storage, Float> spaceLeft;
    public static volatile ListAttribute<Storage, BoatVariantStorage> boatVariantStorages;

}