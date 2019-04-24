package uk.ac.city.douglas.varv.Job.dao;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@Stateless
public class VarvRepositoryJPQLTest {




    @PersistenceContext(unitName="ramsoPU")
    private EntityManager em;



    @Test
    public void testPersistence(){



    }

}