package uk.ac.city.douglas.varv.Stock.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Stock.domain.Inventory;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-12T17:45:28")
@StaticMetamodel(Part.class)
public class Part_ { 

    public static volatile SingularAttribute<Part, String> prisBrutenForp;
    public static volatile SingularAttribute<Part, String> prisStorForp;
    public static volatile SingularAttribute<Part, String> getKatalogPrisInkMoms;
    public static volatile SingularAttribute<Part, String> reseller;
    public static volatile SingularAttribute<Part, String> description;
    public static volatile SingularAttribute<Part, String> artNr;
    public static volatile SingularAttribute<Part, String> prisKod;
    public static volatile SingularAttribute<Part, String> eanKod;
    public static volatile SingularAttribute<Part, String> varuGrupp;
    public static volatile ListAttribute<Part, Inventory> inventories;
    public static volatile SingularAttribute<Part, String> katalogPrisExMoms;
    public static volatile SingularAttribute<Part, String> prisNormalForp;
    public static volatile SingularAttribute<Part, String> antal;
    public static volatile SingularAttribute<Part, String> benamning;
    public static volatile SingularAttribute<Part, String> momsKod;

}