package uk.ac.city.douglas.varv.Account;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import uk.ac.city.douglas.varv.Account.dao.AccountDAO;
import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;
import uk.ac.city.douglas.varv.Job.dao.JobDAOInterface;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class AccountDAOTest {



    AccountDAO dao;


    @Before
    public void setUp() throws Exception {
         this.dao = new AccountDAO();
         this.dao.em = mock(EntityManager.class);

    }
    @Test
    public void getAllCustomers() {
        TypedQuery<Customer> querryByMock = (TypedQuery<Customer>) mock(TypedQuery.class);
        when(this.dao.em.createQuery("SELECT c FROM Customer AS c",Customer.class))
                .thenReturn(querryByMock);
        List<Customer> customers = new ArrayList<>();
        when(querryByMock.getResultList()).thenReturn(customers);

        //action
        List<Customer> acutualCustomers = this.dao.getAllCustomers();
        Assert.assertEquals(customers,acutualCustomers);

    }

    @Test
    public void addCustomer() {

    }

    @Test
    public void eraseCustomerById() {
    }

    @Test
    public void findCustomerById() {
    }
}