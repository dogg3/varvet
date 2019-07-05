package uk.ac.city.douglas.varv.Boat.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-05T16:54:31")
@StaticMetamodel(BoatStorage.class)
public class BoatStorage_ { 

    public static volatile SingularAttribute<BoatStorage, String> pickUpDate;
    public static volatile SingularAttribute<BoatStorage, String> comment;
    public static volatile SingularAttribute<BoatStorage, BoatVariant> customerBoat;
    public static volatile SingularAttribute<BoatStorage, String> dropOffDate;
    public static volatile SingularAttribute<BoatStorage, Integer> boatStorageId;
    public static volatile SingularAttribute<BoatStorage, String> status;

}