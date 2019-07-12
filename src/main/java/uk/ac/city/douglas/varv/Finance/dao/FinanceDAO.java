package uk.ac.city.douglas.varv.Finance.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Finance.domain.Invoice;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
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

    @Override
    public void editInvoice(HashMap<String, String> invoiceData) {
        Invoice invoice = em.find(Invoice.class, Integer.parseInt(invoiceData.get("invoiceId")));



//        if(customerData.get("firstName")!=null && !customerData.get("firstName").isEmpty()){
//            customer.setFirstName(customerData.get("firstName"));
//        }
//        if(customerData.get("lastName")!=null && !customerData.get("lastName").isEmpty()){
//            customer.setLastName(customerData.get("lastName"));
//        }
//        if(customerData.get("tel")!=null && !customerData.get("tel").isEmpty()){
//            customer.setTel(customerData.get("tel"));
//        }
//        if(customerData.get("email")!=null && !customerData.get("email").isEmpty()){
//            customer.setEmail(customerData.get("email"));
//        }
//        if(customerData.get("discountPlan")!= null && !customerData.get("discountPlan").isEmpty()){
//            customer.setDiscountPlan(customerData.get("discountPlan"));
//        }
//        if(customerData.get("identifier")!=null && !customerData.get("identifier").isEmpty()){
//            customer.setIdentifier(customerData.get("identifier"));
//        }
//
//        if(customerData.get("street")!=null && !customerData.get("street").isEmpty()){
//            customer.setStreet(customerData.get("street"));
//        }
//        if(customerData.get("town")!=null && !customerData.get("town").isEmpty()){
//            customer.setTown(customerData.get("town"));
//        }
//        if(customerData.get("postCode")!=null && !customerData.get("postCode").isEmpty()){
//            customer.setPostCode(customerData.get("postCode"));
//        }

em.merge(invoice);
    }
}
