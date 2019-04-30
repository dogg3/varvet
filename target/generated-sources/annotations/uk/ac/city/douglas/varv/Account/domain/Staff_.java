package uk.ac.city.douglas.varv.Account.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uk.ac.city.douglas.varv.Account.domain.Address;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-30T19:28:04")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile SingularAttribute<Staff, String> firstName;
    public static volatile SingularAttribute<Staff, String> lastName;
    public static volatile SingularAttribute<Staff, Address> address;
    public static volatile SingularAttribute<Staff, String> buildingNo;
    public static volatile SingularAttribute<Staff, String> hourlyRate;
    public static volatile SingularAttribute<Staff, Integer> staffID;
    public static volatile SingularAttribute<Staff, String> email;
    public static volatile SingularAttribute<Staff, String> username;

}