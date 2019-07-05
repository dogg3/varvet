package uk.ac.city.douglas.varv.Stock.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Stock.domain.Part;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-05T16:54:31")
@StaticMetamodel(Inventory.class)
public class Inventory_ { 

    public static volatile SingularAttribute<Inventory, String> amount;
    public static volatile SingularAttribute<Inventory, Part> part;
    public static volatile SingularAttribute<Inventory, String> thresHold;
    public static volatile SingularAttribute<Inventory, Integer> artNr;

}