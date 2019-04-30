package uk.ac.city.douglas.varv.Account.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;

    @Test
    public void testPopulate(){
        HashMap<String, String> customerData = new HashMap<>();

       customerData.put("firstName", "Douglas");
       customerData.put("address", "11459");
       customerData.put("lastName", "douglas.landvik@gmail/.com");
       customerData.put("tel", "Douglas");
       customerData.put("email", "Douglas");
       customerData.put("discountPlan", "Douglas");
       customerData.put("buildingNo", "Douglas");
       customerData.put("identifier", "Douglas");

       customer = new Customer();
       customer.populate(customerData);

       Assert.assertNotNull(customer.getCustomerID());
       Assert.assertNotNull(customer.getFirstName());
       Assert.assertNotNull(customer.getLastName());
       Assert.assertNotNull(customer.getTel());
       Assert.assertNotNull(customer.getEmail());
       Assert.assertNotNull(customer.getDiscountPlan());
       Assert.assertNotNull(customer.getIdentifier());

    }


}