package uk.ac.city.douglas.varv.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.domain.BoatVariant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-26T13:34:16")
@StaticMetamodel(Boat.class)
public class Boat_ { 

    public static volatile SingularAttribute<Boat, String> mainCatagory;
    public static volatile SingularAttribute<Boat, Integer> length;
    public static volatile SingularAttribute<Boat, Integer> weight;
    public static volatile SingularAttribute<Boat, Integer> lengthWater;
    public static volatile SingularAttribute<Boat, String> description;
    public static volatile ListAttribute<Boat, BoatVariant> boatVariants;
    public static volatile SingularAttribute<Boat, Float> yearTo;
    public static volatile SingularAttribute<Boat, Integer> depth;
    public static volatile SingularAttribute<Boat, Integer> heightOverWater;
    public static volatile SingularAttribute<Boat, Integer> engineMaxHp;
    public static volatile SingularAttribute<Boat, Float> yearFrom;
    public static volatile SingularAttribute<Boat, Integer> width;
    public static volatile SingularAttribute<Boat, Integer> peopleOnBoard;
    public static volatile SingularAttribute<Boat, String> model;
    public static volatile SingularAttribute<Boat, Integer> engineMinHp;
    public static volatile SingularAttribute<Boat, String> brand;
    public static volatile SingularAttribute<Boat, String> subCatagory;
    public static volatile SingularAttribute<Boat, Integer> boatId;

}