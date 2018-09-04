package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.BoatVariant;
import uk.ac.city.douglas.varv.domain.Storage;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T22:57:11")
@StaticMetamodel(BoatVariantStorage.class)
public class BoatVariantStorage_ { 

    public static volatile SingularAttribute<BoatVariantStorage, Integer> endDate;
    public static volatile SingularAttribute<BoatVariantStorage, BoatVariant> boatVariant;
    public static volatile SingularAttribute<BoatVariantStorage, Integer> customerId;
    public static volatile SingularAttribute<BoatVariantStorage, Storage> storage;
    public static volatile SingularAttribute<BoatVariantStorage, String> boatBrand;
    public static volatile SingularAttribute<BoatVariantStorage, String> boatModel;
    public static volatile SingularAttribute<BoatVariantStorage, Integer> startDate;
    public static volatile SingularAttribute<BoatVariantStorage, String> storageName;
    public static volatile SingularAttribute<BoatVariantStorage, String> status;

}