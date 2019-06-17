package uk.ac.city.douglas.varv.Finance.dao;

import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Finance.domain.Invoice;

import java.util.List;

public interface FinanceDAOInterface {

    public List<Invoice> getAllInvoices();
    public void addInvoice(Invoice invoice);
    public void eraseInvoiceById(int id);
    public Invoice findInvoiceById(int id);
}
