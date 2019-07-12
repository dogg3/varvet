package uk.ac.city.douglas.varv.Finance.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T08:53:21")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, String> date;
    public static volatile SingularAttribute<Invoice, String> costAfterVat;
    public static volatile SingularAttribute<Invoice, String> cost;
    public static volatile SingularAttribute<Invoice, String> vat;
    public static volatile SingularAttribute<Invoice, Integer> invoiceNo;
    public static volatile SingularAttribute<Invoice, String> status;

}