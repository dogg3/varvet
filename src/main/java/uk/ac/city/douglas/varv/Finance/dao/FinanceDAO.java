package uk.ac.city.douglas.varv.Finance.dao;

import uk.ac.city.douglas.varv.Finance.domain.Invoice;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
public class FinanceDAO implements FinanceDAOInterface {
    @PersistenceContext(unitName="ramsoPU")
    private EntityManager em;

    //INVOICES

    @Override
    public List<Invoice> getAllInvoices() {
        TypedQuery query = em.createQuery("SELECT i FROM Invoice AS i", Invoice.class);
        return query.getResultList();
    }

    @Override
    public void addInvoice(Invoice invoice) {
        em.persist(invoice);

    }

    @Override
    public void eraseInvoiceById(int id) {
        Invoice invoice = em.find(Invoice.class, id);
        em.remove(invoice);
    }

    @Override
    public Invoice findInvoiceById(int id) {
        return em.find(Invoice.class,id);
    }
}
