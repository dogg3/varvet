package uk.ac.city.douglas.varv.Finance.domain;

import javax.persistence.*;

@Entity
public class Invoice {

    @Id
    @Column(name="invoiceNo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceNo;

    @Column(name="Date")
    private String date;
    @Column(name="Cost")
    private String cost;
    @Column(name="VAT")
    private String vat;
    @Column(name="CostAfterVAT")
    private String costAfterVat;
    @Column(name="Status")
    private String status;

    public Invoice() {
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getCostAfterVat() {
        return costAfterVat;
    }

    public void setCostAfterVat(String costAfterVat) {
        this.costAfterVat = costAfterVat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNo=" + invoiceNo +
                ", date='" + date + '\'' +
                ", cost='" + cost + '\'' +
                ", vat='" + vat + '\'' +
                ", costAfterVat='" + costAfterVat + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
