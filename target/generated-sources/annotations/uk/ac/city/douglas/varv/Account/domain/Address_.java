package uk.ac.city.douglas.varv.Account.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Account.domain.Staff;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-24T20:52:39")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> town;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> postCode;
    public static volatile ListAttribute<Address, Staff> staffList;

}